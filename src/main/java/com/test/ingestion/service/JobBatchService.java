package com.test.ingestion.service;

import com.test.ingestion.model.JobBatchDetails;
import com.test.ingestion.model.JobBatchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

@Service
public class JobBatchService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<JobBatchResult> lookupJobList(){
        LookupOperation lookupOperationJobInstance = LookupOperation.newLookup()
                .from("BatchJobInstance")
                .localField("jobInstanceId")
                .foreignField("jobInstanceId")
                .as("batchJobInstance");

        LookupOperation lookupOperationJobExecution = LookupOperation.newLookup()
                .from("BatchJobExecution")
                .localField("jobInstanceId")
                .foreignField("jobInstanceId")
                .as("batchJobExecution");

        ProjectionOperation projectionOperation=Aggregation.project("batchJobInstance.jobInstanceId","batchJobExecution.jobExecutionId",
                "batchJobInstance.jobName","batchJobExecution.status","batchJobExecution.exitCode","batchJobExecution.startTime","batchJobExecution.endTime");

//       GroupOperation groupOperation= Aggregation.group("jobInstanceId").
//                push("batchJobInstance.jobInstanceId").as("jobInstanceId")
//                .push("batchJobExecution.jobExecutionId").as("jobExecutionId")
//                .push("batchJobInstance.jobName").as("jobName")
//                .push("batchJobExecution.status").as("jobStatus")
//                .push("batchJobExecution.exitMessage").as("message")
//                .push("batchJobExecution.startTime").as("startTime")
//                .push("batchJobExecution.endTime").as("endTime");
        Aggregation aggregation = Aggregation.newAggregation(lookupOperationJobInstance,Aggregation.unwind("$batchJobInstance"),lookupOperationJobExecution,Aggregation.unwind("$batchJobExecution"),
                projectionOperation);
        List<JobBatchResult> results = mongoTemplate.aggregate(aggregation, "BatchJobInstance", JobBatchResult.class).getMappedResults();
        LOGGER.info("Obj Size " +results.size());
        return results;
    }

    public List<JobBatchDetails> lookupJobDetails(int jobExecId){
        LookupOperation lookupOperationJobInstance = LookupOperation.newLookup()
                .from("BatchJobExecution")
                .localField("jobExecutionId")
                .foreignField("jobExecutionId")
                .as("batchJobExecution");

        LookupOperation lookupOperationJobExecution = LookupOperation.newLookup()
                .from("BatchStepExecution")
                .localField("jobExecutionId")
                .foreignField("jobExecutionId")
                .as("batchStepExecution");

        ProjectionOperation projectionOperation=Aggregation.project("batchStepExecution.stepName","batchJobExecution.jobExecutionId",
                "batchStepExecution.status","batchStepExecution.readCount","batchJobExecution.writeCount","batchJobExecution.processSkipCount");

//       GroupOperation groupOperation= Aggregation.group("jobInstanceId").
//                push("batchJobInstance.jobInstanceId").as("jobInstanceId")
//                .push("batchJobExecution.jobExecutionId").as("jobExecutionId")
//                .push("batchJobInstance.jobName").as("jobName")
//                .push("batchJobExecution.status").as("jobStatus")
//                .push("batchJobExecution.exitMessage").as("message")
//                .push("batchJobExecution.startTime").as("startTime")
//                .push("batchJobExecution.endTime").as("endTime");
        Aggregation aggregation = Aggregation.newAggregation(Aggregation.match(Criteria.where("jobExecutionId").is(Integer.valueOf(jobExecId+""))),lookupOperationJobInstance,Aggregation.unwind("$batchJobExecution"),lookupOperationJobExecution,Aggregation.unwind("batchStepExecution"),
                projectionOperation);
        List<JobBatchDetails> results = mongoTemplate.aggregate(aggregation, "BatchJobExecution", JobBatchDetails.class).getMappedResults();
        LOGGER.info("Obj Size " +results.size());
        return results;
    }
}

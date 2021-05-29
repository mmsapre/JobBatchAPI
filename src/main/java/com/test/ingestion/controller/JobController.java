package com.test.ingestion.controller;

//import com.test.ingestion.repository.MongoDbJobExecutionDao;
//import com.test.ingestion.repository.MongoDbJobInstanceDao;

import com.test.ingestion.model.JobBatchDetails;
import com.test.ingestion.model.JobBatchResult;
import com.test.ingestion.service.JobBatchService;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class JobController {

    @Autowired
    private JobBatchService jobBatchService;

//    @Autowired
//    private MongoDbJobInstanceDao mongoDbJobInstanceDao;
//
//    @Autowired
//    private MongoDbJobExecutionDao mongoDbJobExecutionDao;

    @GetMapping("/jobs")
    public ResponseEntity<List<JobBatchResult>> getAllJobs(@RequestParam(required = false) String jobId) {
        try {
            List<JobInstance> jobInstances = new ArrayList<JobInstance>();

//            if (jobId == null)
//                batchJobInstanceRepository.findAll().forEach(jobInstances::add);
//            else {
//               Optional<JobInstance> jobInstance= batchJobInstanceRepository.findById(jobId);
//               if(jobInstance.isPresent())
//                   jobInstances.add(jobInstance.get());
//            }
//            if (jobInstances.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }

            //jobInstances=mongoDbJobInstanceDao.getAllJobs();
            List<JobBatchResult> jobBatchResults= jobBatchService.lookupJobList();
            return new ResponseEntity<List<JobBatchResult>>(jobBatchResults, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/jobexecution")
    public ResponseEntity<List<JobBatchDetails>> getJobExecutions(@RequestParam(required = true) int jobId) {
        try {
            List<JobExecution> jobExecutions = new ArrayList<JobExecution>();

//            if (jobId == null)
//                batchJobInstanceRepository.findAll().forEach(jobInstances::add);
//            else {
//               Optional<JobInstance> jobInstance= batchJobInstanceRepository.findById(jobId);
//               if(jobInstance.isPresent())
//                   jobInstances.add(jobInstance.get());
//            }
//            if (jobInstances.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }

           // jobExecutions=mongoDbJobExecutionDao.findJobExecutions(jobInstance);
            List<JobBatchDetails> jobBatchDetailsResults= jobBatchService.lookupJobDetails(jobId);
            return new ResponseEntity<List<JobBatchDetails>>(jobBatchDetailsResults, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

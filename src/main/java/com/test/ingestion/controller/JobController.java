package com.test.ingestion.controller;
import com.test.ingestion.model.JobBatchDetails;
import com.test.ingestion.model.JobBatchResult;
import com.test.ingestion.service.JobBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api")
public class JobController {

    @Autowired
    private JobBatchService jobBatchService;

    @GetMapping("/jobs")
    public ResponseEntity<List<JobBatchResult>> getAllJobs(@RequestParam(required = false) String jobId) {
        try {
            List<JobBatchResult> jobBatchResults= jobBatchService.lookupJobList();
            return new ResponseEntity<List<JobBatchResult>>(jobBatchResults, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/jobexecution")
    public ResponseEntity<List<JobBatchDetails>> getJobExecutions(@RequestParam(required = true) int jobId) {
        try {
            List<JobBatchDetails> jobBatchDetailsResults= jobBatchService.lookupJobDetails(jobId);
            return new ResponseEntity<List<JobBatchDetails>>(jobBatchDetailsResults, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

package com.test.ingestion.model;

import java.io.Serializable;

public class JobBatchDetails implements Serializable {

    private  int readCount;
    private int jobExecutionId;
    private String stepName;
    private String status;
    private int writeCount;
    private int processSkipCount;

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

    public int getJobExecutionId() {
        return jobExecutionId;
    }

    public void setJobExecutionId(int jobExecutionId) {
        this.jobExecutionId = jobExecutionId;
    }

    public String getStepName() {
        return stepName;
    }

    public void setStepName(String stepName) {
        this.stepName = stepName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getWriteCount() {
        return writeCount;
    }

    public void setWriteCount(int writeCount) {
        this.writeCount = writeCount;
    }

    public int getProcessSkipCount() {
        return processSkipCount;
    }

    public void setProcessSkipCount(int processSkipCount) {
        this.processSkipCount = processSkipCount;
    }
}

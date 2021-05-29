package com.test.ingestion.model;

import java.io.Serializable;

public class JobBatchResult implements Serializable {

    private  int jobInstanceId;
    private int jobExecutionId;
    private String jobName;
    private String status;
    private String exitCode;
    private String startTime;
    private String endTime;

    public int getJobInstanceId() {
        return jobInstanceId;
    }

    public void setJobInstanceId(int jobInstanceId) {
        this.jobInstanceId = jobInstanceId;
    }

    public int getJobExecutionId() {
        return jobExecutionId;
    }

    public void setJobExecutionId(int jobExecutionId) {
        this.jobExecutionId = jobExecutionId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getExitCode() {
        return exitCode;
    }

    public void setExitCode(String exitCode) {
        this.exitCode = exitCode;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}

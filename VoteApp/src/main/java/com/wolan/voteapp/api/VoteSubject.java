package com.wolan.voteapp.api;

import com.wolan.voteapp.data.VoteEntity;
import java.sql.Timestamp;
import java.util.List;

public class VoteSubject {
    private Long id;
    private String startDate;
    private String endDate;
    private String voteSubject;
    private long positiveCount;
    private long negativeCount;

    public Long getId() {
        return id;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getVoteSubject() {
        return voteSubject;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setVoteSubject(String voteSubject) {
        this.voteSubject = voteSubject;
    }

    public long getPositiveCount() {
        return positiveCount;
    }

    public void setPositiveCount(long positiveCount) {
        this.positiveCount = positiveCount;
    }

    public long getNegativeCount() {
        return negativeCount;
    }

    public void setNegativeCount(long negativeCount) {
        this.negativeCount = negativeCount;
    }
}

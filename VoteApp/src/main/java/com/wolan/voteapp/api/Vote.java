package com.wolan.voteapp.api;

public class Vote {
    private Long id;
    private String loginName;
    private String voteSubject;
    private boolean vote;
    private boolean editable;

    public Long getId() {
        return id;
    }

    public String getLoginName() {
        return loginName;
    }

    public String getVoteSubject() {
        return voteSubject;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public void setVoteSubject(String voteSubject) {
        this.voteSubject = voteSubject;
    }

    public boolean isVote() {
        return vote;
    }

    public void setVote(boolean vote) {
        this.vote = vote;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }
}

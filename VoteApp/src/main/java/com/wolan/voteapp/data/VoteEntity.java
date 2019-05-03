package com.wolan.voteapp.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Vote")
public class VoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "vote")
    private boolean vote;

    @Column(name = "loginName")
    private String loginName;

    @Column(name = "editable")
    private boolean editable;

    @ManyToOne()
    @JoinColumn(name = "Subject_id", nullable = false)
    private VoteSubjectEntity voteSubjectEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isVote() {
        return vote;
    }

    public void setVote(boolean vote) {
        this.vote = vote;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public VoteSubjectEntity getVoteSubjectEntity() {
        return voteSubjectEntity;
    }

    public void setVoteSubjectEntity(VoteSubjectEntity voteSubjectEntity) {
        this.voteSubjectEntity = voteSubjectEntity;
    }
}

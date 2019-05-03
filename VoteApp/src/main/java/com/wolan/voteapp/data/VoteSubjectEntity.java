package com.wolan.voteapp.data;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Subject")
public class VoteSubjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "subject")
    private String voteSubject;

    @Column(name = "startDate")
    private Timestamp startDate;

    @Column(name = "endDate")
    private Timestamp endDate;

    @OneToMany(mappedBy = "voteEntity")
    private List<VoteEntity> voteEntities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVoteSubject() {
        return voteSubject;
    }

    public void setVoteSubject(String voteSubject) {
        this.voteSubject = voteSubject;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public List<VoteEntity> getVoteEntities() {
        return voteEntities;
    }

    public void setVoteEntities(List<VoteEntity> voteEntities) {
        this.voteEntities = voteEntities;
    }
}

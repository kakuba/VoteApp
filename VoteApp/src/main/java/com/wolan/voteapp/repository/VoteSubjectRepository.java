package com.wolan.voteapp.repository;

import com.wolan.voteapp.data.VoteSubjectEntity;
import org.springframework.data.repository.CrudRepository;

public interface VoteSubjectRepository extends CrudRepository<VoteSubjectEntity, Long> {
    VoteSubjectEntity findByVoteSubject(String voteSubject);
}

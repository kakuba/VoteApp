package com.wolan.voteapp.repository;

import com.wolan.voteapp.api.Vote;
import com.wolan.voteapp.data.VoteEntity;
import com.wolan.voteapp.data.VoteSubjectEntity;
import org.springframework.data.repository.CrudRepository;


public interface VoteRepository extends CrudRepository<VoteEntity, Long> {
    VoteEntity findByLoginNameAndVoteSubjectEntity(String loginName, VoteSubjectEntity voteSubjectEntity);
}

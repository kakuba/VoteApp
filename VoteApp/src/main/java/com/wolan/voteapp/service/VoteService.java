package com.wolan.voteapp.service;

import com.wolan.voteapp.api.Vote;
import com.wolan.voteapp.api.VoteSubject;
import com.wolan.voteapp.exception.NotEditableException;
import java.util.List;

public interface VoteService {
    List<VoteSubject> findAllVoteSubjects();

    Vote voteFor(Vote vote) throws NotEditableException;

    VoteSubject createVoteSubject(VoteSubject voteSubject);
}

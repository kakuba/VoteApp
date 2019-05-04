package com.wolan.voteapp.service.impl;

import com.wolan.voteapp.api.Vote;
import com.wolan.voteapp.api.VoteSubject;
import com.wolan.voteapp.data.VoteEntity;
import com.wolan.voteapp.data.VoteSubjectEntity;
import com.wolan.voteapp.exception.NotEditableException;
import com.wolan.voteapp.repository.VoteRepository;
import com.wolan.voteapp.repository.VoteSubjectRepository;
import com.wolan.voteapp.service.VoteService;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteServiceImpl implements VoteService {
    private VoteRepository voteRepository;
    private VoteSubjectRepository voteSubjectRepository;

    @Autowired
    public VoteServiceImpl(VoteRepository voteRepository, VoteSubjectRepository voteSubjectRepository) {
        this.voteRepository = voteRepository;
        this.voteSubjectRepository = voteSubjectRepository;

    }

    @Override
    public List<VoteSubject> findAllVoteSubjects() {
        return mapToVoteSubjects(voteSubjectRepository.findAll());
    }

    private List<VoteSubject> mapToVoteSubjects(Iterable<VoteSubjectEntity> all) {
        return StreamSupport.stream(all.spliterator(), false)
                .map(this::mapToVoteSubject)
                .collect(Collectors.toList());
    }

    private VoteSubject mapToVoteSubject(VoteSubjectEntity voteSubjectEntity) {
        VoteSubject voteSubject = new VoteSubject();
        voteSubject.setId(voteSubjectEntity.getId());
        voteSubject.setStartDate(voteSubjectEntity.getStartDate().toLocalDateTime().format(DateTimeFormatter.ISO_DATE));
        voteSubject.setEndDate(voteSubjectEntity.getEndDate().toLocalDateTime().format(DateTimeFormatter.ISO_DATE));
        voteSubject.setVoteSubject(voteSubjectEntity.getVoteSubject());
        voteSubject.setPositiveCount(countPositive(voteSubjectEntity.getVoteEntities()));
        voteSubject.setNegativeCount(countNegative(voteSubjectEntity.getVoteEntities()));
        return voteSubject;
    }

    private long countNegative(List<VoteEntity> voteEntities) {
        if (voteEntities == null) {
            return 0;
        }
        Predicate<VoteEntity> voteEntityPredicate = VoteEntity::isVote;
        return voteEntities.stream().filter(voteEntityPredicate.negate()).count();
    }

    private long countPositive(List<VoteEntity> voteEntities) {
        if (voteEntities == null) {
            return 0;
        }
        return voteEntities.stream().filter(VoteEntity::isVote).count();
    }


    @Override
    public Vote voteFor(Vote vote) throws NotEditableException {
        VoteSubjectEntity voteSubjectEntity = voteSubjectRepository.findByVoteSubject(vote.getVoteSubject());
        VoteEntity checkedVoteEntity = voteRepository.findByLoginNameAndVoteSubjectEntity(vote.getLoginName(), voteSubjectEntity);
        if (checkedVoteEntity != null && checkedVoteEntity.isEditable()) {
            checkedVoteEntity.setEditable(false);
            checkedVoteEntity.setVote(vote.isVote());
            return saveAndMap(checkedVoteEntity);
        } else if (checkedVoteEntity == null) {
            vote.setEditable(true);
            VoteEntity voteEntity = mapToEntity(vote);
            return saveAndMap(voteEntity);

        }
        throw new NotEditableException();
    }

    @Override
    public VoteSubject createVoteSubject(VoteSubject voteSubject) {
        VoteSubjectEntity voteSubjectEntity = mapToSubjectEntity(voteSubject);
        VoteSubjectEntity savedVoteSubject = voteSubjectRepository.save(voteSubjectEntity);
        return mapToVoteSubject(savedVoteSubject);
    }

    private VoteSubjectEntity mapToSubjectEntity(VoteSubject voteSubject) {
        VoteSubjectEntity voteSubjectEntity = new VoteSubjectEntity();
        voteSubjectEntity.setVoteSubject(voteSubject.getVoteSubject());
        voteSubjectEntity.setStartDate(Timestamp.valueOf(LocalDate.parse(voteSubject.getStartDate()).atStartOfDay()));
        voteSubjectEntity.setEndDate(Timestamp.valueOf(LocalDate.parse(voteSubject.getEndDate()).atStartOfDay()));
        return voteSubjectEntity;
    }

    private Vote saveAndMap(VoteEntity voteEntity) {
        VoteEntity savedVoteEntity = voteRepository.save(voteEntity);
        return mapToVote(savedVoteEntity);
    }

    private VoteEntity mapToEntity(Vote vote) {
        VoteEntity voteEntity = new VoteEntity();
        voteEntity.setId(vote.getId());
        voteEntity.setLoginName(vote.getLoginName());
        voteEntity.setEditable(vote.isEditable());
        voteEntity.setVote(vote.isVote());
        voteEntity.setVoteSubjectEntity(voteSubjectRepository.findByVoteSubject(vote.getVoteSubject()));
        return voteEntity;
    }

    private Vote mapToVote(VoteEntity voteEntity) {
        Vote vote = new Vote();
        vote.setId(voteEntity.getId());
        vote.setLoginName(voteEntity.getLoginName());
        vote.setVoteSubject(voteEntity.getVoteSubjectEntity().getVoteSubject());
        vote.setEditable(voteEntity.isEditable());
        vote.setVote(voteEntity.isEditable());
        return vote;
    }

}

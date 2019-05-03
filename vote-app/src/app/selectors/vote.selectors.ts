import { createSelector } from "@ngrx/store";
import { State } from '../reducers';
import { VoteState } from '../vote.interface';

export const selectVoteState = (state: State) => state.vote;

export const selectVoteSubjects = createSelector(selectVoteState, (state: VoteState) => state.voteSubjects);

export const selectVotes = createSelector(selectVoteState, (state: VoteState) => state.votes);

export const selectVotingFor = createSelector(selectVoteState, (state: VoteState) => state.votingFor);

export const selectLoadingVoteSubjects = createSelector(selectVoteState, (state: VoteState) => state.loadingVoteSubjects);

export const selectCreatingVoteSubject = createSelector(selectVoteState, (state: VoteState) => state.creatingVoteSubject);

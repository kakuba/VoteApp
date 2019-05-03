import { VoteState } from "../vote.interface";
import { 
    VoteActions,
    ActionTypes
} from '../actions/vote.actions';

const initialState: VoteState = {
    voteSubjects: [],
    votes: [],
    loadingVoteSubjects: false,
    votingFor: false,
    creatingVoteSubject: false
}; 

export function voteReducer( state: VoteState = initialState, action: VoteActions ) {
    switch( action.type ) {
        case ActionTypes.LoadVoteSubjects:
            return {
                ...state,
                loadingVoteSubjects: true
            };          
        case ActionTypes.LoadVoteSubjectsSuccess:
            return {
                ...state,
                loadingVoteSubjects: false,
                voteSubjects: action.payload
            };          
        case ActionTypes.LoadVoteSubjectsFailure:
            return {
                ...state,
                loadingVoteSubjects: false
            };          
        case ActionTypes.VoteFor:
            return {
                ...state,
                votingFor: true
            };          
        case ActionTypes.VoteForSuccess:
            let found = false;
            const votes = state.votes.map(vote => {
                if (vote.id === action.payload.id) {
                    found = true;
                    return action.payload;
                }
                return vote;
            });
            if (!found) {
                votes.push(action.payload);
            }
            return {
                ...state,
                votingFor: false,
                votes
            };          
        case ActionTypes.VoteForFailure:
            return {
                ...state,
                votingFor: false
            };          
        case ActionTypes.CreateVoteSubjest:
            return {
                ...state,
                creatingVoteSubjects: true
            };          
        case ActionTypes.CreateVoteSubjestSuccess:
            const voteSubjects = state.voteSubjects;
            voteSubjects.push(action.payload);
            return {
                ...state,
                creatingVoteSubjects: false,
                voteSubjects
            };          
        case ActionTypes.CreateVoteSubjestFailure:
            return {
                ...state,
                creatingVoteSubjects: false
            };          
        default:
            return state;
    } 
}
import { Action } from '@ngrx/store';
import { VoteSubject, Vote } from '../vote.interface';

export enum ActionTypes {
    LoadVoteSubjects = "[voteSubject] load",
    LoadVoteSubjectsSuccess = "[voteSubject] load success",
    LoadVoteSubjectsFailure = "[voteSubject] load failure",
    VoteFor = "[vote] voteFor",
    VoteForSuccess = "[vote] voteFor success",
    VoteForFailure = "[vote] voteFor failure",
    CreateVoteSubjest = "[voteSubject] create",
    CreateVoteSubjestSuccess = "[voteSubject] create success",
    CreateVoteSubjestFailure = "[voteSubject] create failure",

}

export class LoadVoteSubjectsAction implements Action {
    readonly type = ActionTypes.LoadVoteSubjects;
}

export class LoadVoteSubjectsSuccessAction implements Action {
    readonly type = ActionTypes.LoadVoteSubjectsSuccess;

    constructor(public payload: VoteSubject[]) {}
}

export class LoadVoteSubjectsFailureAction implements Action {
    readonly type = ActionTypes.LoadVoteSubjectsFailure;
}

export class VoteForAction implements Action {
    readonly type = ActionTypes.VoteFor;

    constructor(public payload: Vote) {}
}

export class VoteForActionSuccess implements Action {
    readonly type = ActionTypes.VoteForSuccess;

    constructor(public payload: Vote) {}
}

export class VoteForActionFailure implements Action {
    readonly type = ActionTypes.VoteForFailure;
}
export class CreateVoteSubjestAction implements Action {
    readonly type = ActionTypes.CreateVoteSubjest;

    constructor(public payload: VoteSubject) {}
}

export class CreateVoteSubjestActionSuccess implements Action {
    readonly type = ActionTypes.CreateVoteSubjestSuccess;

    constructor(public payload: VoteSubject) {}
}

export class CreateVoteSubjestActionFailure implements Action {
    readonly type = ActionTypes.CreateVoteSubjestFailure;
}


export type VoteActions = LoadVoteSubjectsAction | LoadVoteSubjectsSuccessAction | LoadVoteSubjectsFailureAction 
| VoteForAction | VoteForActionSuccess | VoteForActionFailure 
| CreateVoteSubjestAction | CreateVoteSubjestActionSuccess | CreateVoteSubjestActionFailure; 




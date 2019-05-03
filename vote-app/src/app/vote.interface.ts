export interface Vote {
    id: number;
    loginName: string;
    voteSubject: string;
    vote: boolean;
    editable: boolean;
}

export interface VoteSubject {
    id: number;
    startDate: string;
    endDate: string;
    voteSubject: string;
    positiveCount: number;
    negativeCount: number;
}

export interface VoteState {
    voteSubjects: VoteSubject[];
    votes: Vote[];
    loadingVoteSubjects: boolean;
    votingFor: boolean;
    creatingVoteSubject: boolean;
}
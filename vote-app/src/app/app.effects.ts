import { Injectable } from '@angular/core';
import { Actions, Effect, ofType } from '@ngrx/effects';
import { VoteServiceService } from './vote-service.service';
import { ActionTypes, LoadVoteSubjectsAction, LoadVoteSubjectsSuccessAction, LoadVoteSubjectsFailureAction, VoteForAction, VoteForActionSuccess, VoteForActionFailure, CreateVoteSubjestAction, CreateVoteSubjestActionSuccess, CreateVoteSubjestActionFailure } from './actions/vote.actions';
import { 
  mergeMap, 
  catchError, 
  map 
} from 'rxjs/operators'
import { Action } from 'rxjs/internal/scheduler/Action';
import { Observable, of } from 'rxjs';
import { VoteSubject, Vote } from './vote.interface';

@Injectable()
export class AppEffects {
  constructor(private actions$: Actions, private voteService: VoteServiceService) {}

  @Effect()
  loadVoteSubjects$ = this.actions$.pipe(
    ofType(ActionTypes.LoadVoteSubjects), 
    mergeMap((action: LoadVoteSubjectsAction): Observable<LoadVoteSubjectsSuccessAction | LoadVoteSubjectsFailureAction> => 
      this.voteService.getAllVoteSubjects().pipe(
        map((voteSubjects : VoteSubject[]) => new LoadVoteSubjectsSuccessAction(voteSubjects)), 
        catchError(() => of(new LoadVoteSubjectsFailureAction()))
      )
    )
  );

  @Effect()
  voteFor$ = this.actions$.pipe(
    ofType(ActionTypes.VoteFor), 
    mergeMap((action: VoteForAction): Observable<VoteForActionSuccess | VoteForActionFailure> => 
      this.voteService.voteFor(action.payload).pipe(
        map((vote : Vote) => new VoteForActionSuccess(vote)), 
        catchError(() => of(new VoteForActionFailure()))
      )
    )
  );

  @Effect()
  createVoteSubject$ = this.actions$.pipe(
    ofType(ActionTypes.CreateVoteSubjest), 
    mergeMap((action: CreateVoteSubjestAction): Observable<CreateVoteSubjestActionSuccess | CreateVoteSubjestActionFailure> => 
      this.voteService.createVoteSubject(action.payload).pipe(
        map((voteSubject : VoteSubject) => new CreateVoteSubjestActionSuccess(voteSubject)), 
        catchError(() => of(new CreateVoteSubjestActionFailure()))
      )
    )
  );
}
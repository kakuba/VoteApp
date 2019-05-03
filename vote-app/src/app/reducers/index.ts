import {
  ActionReducer,
  ActionReducerMap,
  createFeatureSelector,
  createSelector,
  MetaReducer
} from '@ngrx/store';
import { environment } from '../../environments/environment';
import { VoteState } from '../vote.interface';
import { voteReducer } from './vote.reducer';

export interface State {
  vote: VoteState;
}

export const reducers: ActionReducerMap<State> = {
  vote: voteReducer  
};


export const metaReducers: MetaReducer<State>[] = !environment.production ? [] : [];

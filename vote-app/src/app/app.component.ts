import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { VoteSubject } from './vote.interface';
import { Store, select } from '@ngrx/store';
import { State } from './reducers';
import { selectVoteSubjects } from './selectors/vote.selectors';
import { LoadVoteSubjectsAction } from './actions/vote.actions';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  
  voteSubjects$: Observable<VoteSubject[]>;
  
  constructor(private store: Store<State>) {
    this.voteSubjects$ = store.pipe(select(selectVoteSubjects));
  };
  
  ngOnInit(): void {
    this.store.dispatch(new LoadVoteSubjectsAction());
  }
}

import { Component, OnInit, Input } from '@angular/core';
import { VoteSubject } from '../vote.interface';

@Component({
  selector: 'app-vote-subject',
  templateUrl: './vote-subject.component.html',
  styleUrls: ['./vote-subject.component.sass']
})
export class VoteSubjectComponent implements OnInit {

  @Input()
  voteSubject: VoteSubject;

  constructor() { }

  ngOnInit() {
  }

}

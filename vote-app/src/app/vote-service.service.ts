import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { 
  Vote, 
  VoteSubject
} from './vote.interface';

@Injectable({
  providedIn: 'root'
})
export class VoteServiceService {

  constructor(private http: HttpClient) { }

  getAllVoteSubjects(){
    return this.http.get("http://localhost:8080/vote/subject/");
  }

  createVoteSubject(voteSubject: VoteSubject) {
    return this.http.post("http://localhost:8080/vote/subject/", voteSubject);
  }

  voteFor(vote: Vote) {
    return this.http.post("http://localhost:8080/vote/vote/", vote);
  }
}

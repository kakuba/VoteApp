import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VoteSubjectComponent } from './vote-subject.component';

describe('VoteSubjectComponent', () => {
  let component: VoteSubjectComponent;
  let fixture: ComponentFixture<VoteSubjectComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VoteSubjectComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VoteSubjectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

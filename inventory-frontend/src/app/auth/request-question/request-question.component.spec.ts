import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RequestQuestionComponent } from './request-question.component';

describe('RequestQuestionComponent', () => {
  let component: RequestQuestionComponent;
  let fixture: ComponentFixture<RequestQuestionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RequestQuestionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RequestQuestionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

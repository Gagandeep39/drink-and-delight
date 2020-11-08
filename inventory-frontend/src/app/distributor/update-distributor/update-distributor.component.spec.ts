import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateDistributorComponent } from './update-distributor.component';

describe('UpdateDistributorComponent', () => {
  let component: UpdateDistributorComponent;
  let fixture: ComponentFixture<UpdateDistributorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateDistributorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateDistributorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

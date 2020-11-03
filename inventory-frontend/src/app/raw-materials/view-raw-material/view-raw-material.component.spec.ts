import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewRawMaterialComponent } from './view-raw-material.component';

describe('ViewRawMaterialComponent', () => {
  let component: ViewRawMaterialComponent;
  let fixture: ComponentFixture<ViewRawMaterialComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewRawMaterialComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewRawMaterialComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

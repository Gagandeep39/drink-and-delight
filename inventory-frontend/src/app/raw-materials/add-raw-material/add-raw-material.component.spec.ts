import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddRawMaterialComponent } from './add-raw-material.component';

describe('AddRawMaterialComponent', () => {
  let component: AddRawMaterialComponent;
  let fixture: ComponentFixture<AddRawMaterialComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddRawMaterialComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddRawMaterialComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddRawMaterialOrderComponent } from './add-raw-material-order.component';

describe('AddRawMaterialOrderComponent', () => {
  let component: AddRawMaterialOrderComponent;
  let fixture: ComponentFixture<AddRawMaterialOrderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddRawMaterialOrderComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddRawMaterialOrderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

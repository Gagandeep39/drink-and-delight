import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddProductOrderComponent } from './add-product-order.component';

describe('AddProductOrderComponent', () => {
  let component: AddProductOrderComponent;
  let fixture: ComponentFixture<AddProductOrderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddProductOrderComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddProductOrderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

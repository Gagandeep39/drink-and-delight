import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateSupplierComponent } from './update-supplier.component';

describe('UpdateSupplierComponent', () => {
  let component: UpdateSupplierComponent;
  let fixture: ComponentFixture<UpdateSupplierComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateSupplierComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateSupplierComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

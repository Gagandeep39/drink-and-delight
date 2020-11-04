import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewProductOrdersComponent } from './view-product-orders.component';

describe('ViewProductOrdersComponent', () => {
  let component: ViewProductOrdersComponent;
  let fixture: ComponentFixture<ViewProductOrdersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewProductOrdersComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewProductOrdersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

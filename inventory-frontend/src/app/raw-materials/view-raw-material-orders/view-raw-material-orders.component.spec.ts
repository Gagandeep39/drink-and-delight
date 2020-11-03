import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewRawMaterialOrdersComponent } from './view-raw-material-orders.component';

describe('ViewRawMaterialOrdersComponent', () => {
  let component: ViewRawMaterialOrdersComponent;
  let fixture: ComponentFixture<ViewRawMaterialOrdersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewRawMaterialOrdersComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewRawMaterialOrdersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

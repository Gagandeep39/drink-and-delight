import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Supplier } from 'src/app/models/supplier.model';
import { AuthService } from 'src/app/services/auth.service';
import { SupplierService } from 'src/app/services/supplier.service';

@Component({
  selector: 'app-view-supplier',
  templateUrl: './view-supplier.component.html',
  styleUrls: ['./view-supplier.component.css'],
})
export class ViewSupplierComponent implements OnInit {
  supplier: Supplier;
  suppliers: Supplier[];
  role;
  constructor(
    private supplierService: SupplierService,
    private router: Router,
    private authService: AuthService
  ) {}

  ngOnInit(): void {
    this.role = this.authService.getRole();
    this.supplierService
      .fetchAllSuppliers()
      .subscribe((response: Supplier[]) => {
        this.suppliers = response;
      });
  }
  reload() {
    this.router.navigate(['/dashboard/suppliers']);
  }

  updateSupplier(id: number) {
    this.router.navigate(['/dashboard/updatesupplier', id]);
  }
}

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Supplier } from 'src/app/models/supplier.model';
import { SupplierService } from 'src/app/services/supplier.service';

@Component({
  selector: 'app-add-supplier',
  templateUrl: './add-supplier.component.html',
  styleUrls: ['./add-supplier.component.css'],
})
export class AddSupplierComponent implements OnInit {
  supplier: Supplier;
  constructor(private service: SupplierService, private router: Router) {
    this.supplier = new Supplier();
  }

  ngOnInit(): void {}

  addSupplier() {
    this.service.addSupplier(this.supplier).subscribe((res) => {
      this.router.navigate(['/dashboard/suppliers']);
    });
  }
}

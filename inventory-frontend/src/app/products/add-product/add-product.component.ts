import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from 'src/app/models/product.model';
import { Warehouse } from 'src/app/models/warehouse.model';
import { ProductService } from 'src/app/services/product.service';
import { WarehouseService } from 'src/app/services/warehouse.service';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css'],
})
export class AddProductComponent implements OnInit {
  product: Product;
  warehouses: Warehouse[] = [];
  warehouseId;

  constructor(
    private service: ProductService,
    private warehouseService: WarehouseService,
    private router: Router
  ) {
    this.product = new Product();
    this.warehouseService.fetchAllWarehouse().subscribe((data: Warehouse[]) => {
      this.warehouses = data;
    });
  }

  ngOnInit(): void {
    this.product = new Product();
  }

  saveProduct(formData) {
    let warhouse = new Warehouse();
    this.product.quantityAvailable = 0;
    warhouse.warehouseId = +formData.warehouseId;
    this.product.warehouse = warhouse;
    this.service.addProduct(this.product).subscribe((res) => {
      this.router.navigate(['/dashboard/products']);
    });
  }
}

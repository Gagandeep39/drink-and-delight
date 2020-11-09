import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RawMaterial } from 'src/app/models/raw-material.model';
import { Warehouse } from 'src/app/models/warehouse.model';
import { RawmaterialService } from 'src/app/services/rawmaterial.service';
import { SupplierService } from 'src/app/services/supplier.service';
import { WarehouseService } from 'src/app/services/warehouse.service';

@Component({
  selector: 'app-add-raw-material',
  templateUrl: './add-raw-material.component.html',
  styleUrls: ['./add-raw-material.component.css'],
})
export class AddRawMaterialComponent implements OnInit {
  rawMaterial: RawMaterial;
  warehouses: Warehouse[] = [];

  constructor(
    private rawMaterialService: RawmaterialService,
    private warehouseService: WarehouseService,
    private router: Router
  ) {
   
  }

  ngOnInit(): void {
    this.rawMaterial = new RawMaterial();
    this.warehouseService.fetchAllWarehouse().subscribe((data: Warehouse[]) => {
      this.warehouses = data;
    });
  }

  saveRawMaterial(formData) {
    let warehouse = new Warehouse();
    this.rawMaterial.quantityAvailable = 0;
    warehouse.warehouseId = +formData.warehouse;
    this.rawMaterial.warehouse = warehouse;

    this.rawMaterialService
      .createRawMaterial(this.rawMaterial)
      .subscribe((res) => {
        this.router.navigate(['/dashboard/rawmaterials'])
      });
  }
}

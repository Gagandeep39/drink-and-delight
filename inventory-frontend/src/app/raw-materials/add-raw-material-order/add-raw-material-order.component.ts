import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Gender } from 'src/app/models/gender.model';
import { RawMaterial } from 'src/app/models/raw-material.model';
import { Supplier } from 'src/app/models/supplier.model';
import { RawmaterialOrderService } from 'src/app/services/rawmaterial-order.service';
import { RawmaterialService } from 'src/app/services/rawmaterial.service';
import { SupplierService } from 'src/app/services/supplier.service';

@Component({
  selector: 'app-add-raw-material-order',
  templateUrl: './add-raw-material-order.component.html',
  styleUrls: ['./add-raw-material-order.component.css'],
})
export class AddRawMaterialOrderComponent implements OnInit {
  genders = Gender;
  submitted = false;
  rawMaterialForm: FormGroup;
  message = null;
  rawMaterials: RawMaterial[] = [];
  suppliers: Supplier[] = [];
  measurementUnit = 'Select Raw Material';

  constructor(
    private rawMateriOrderService: RawmaterialOrderService,
    private router: Router,
    private rawMaterialService: RawmaterialService,
    private supplierService: SupplierService
  ) {
    this.initForm();
    this.initSupplierDropdown();
    this.initRawmterialDropdown();
  }
  initSupplierDropdown() {
    this.supplierService
      .fetchAllSuppliers()
      .subscribe((res: Supplier[]) => (this.suppliers = res));
  }
  initRawmterialDropdown() {
    this.rawMaterialService
      .fetchAllRawmaterials()
      .subscribe((res: RawMaterial[]) => (this.rawMaterials = res));
  }

  ngOnInit(): void {}

  submitForm() {
    this.submitted = true;
    console.log(this.rawMaterialForm.value);
    
    if (this.rawMaterialForm.valid)
      this.createRawMaterial(this.rawMaterialForm.value);
  }

  createRawMaterial(formData) {
    this.rawMateriOrderService
      .createRawMaterialOrderRequest(formData)
      .subscribe(
        (response) => {
          this.message =
            'Successfully purchased Raw Material with Order ID ' +
            response['rawMaterialId'];
          setTimeout(() => {
            this.router.navigateByUrl('/dashboard/rawmaterialorders');
          }, 3000);
        },
        (error) => {
          console.log(error);
          if (error.error.message === 'FieldException')
            error.error.errors.forEach((element) =>
              this.rawMaterialForm.controls[element.field]?.setErrors({
                serverValidationError: element.message,
              })
            );
          else throw new Error(error);
        }
      );
  }

  initForm() {
    this.rawMaterialForm = new FormGroup({
      rawMaterialId: new FormControl('', [Validators.required]),
      quantity: new FormControl('', [Validators.required]),
      pricePerUnit: new FormControl('', [Validators.required]),
      qualityCheck: new FormControl('', [Validators.required]),
      deliveryDate: new FormControl('', [Validators.required]),
      expiryDate: new FormControl('', [Validators.required]),
      supplierId: new FormControl('', [Validators.required]),
    });
  }

  updateUnit(id) {
    this.measurementUnit = this.rawMaterials.find(rm => rm.rawMaterialId == id).quantityUnit;
  }
}

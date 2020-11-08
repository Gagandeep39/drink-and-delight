/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-11-08 14:53:14
 * @modify date 2020-11-08 14:53:14
 * @desc Update Status Popup
 */
import { Inject } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ProductOrder } from 'src/app/models/product-order.model';
import { LoadingService } from 'src/app/services/loading.service';
import { ProductOrderService } from 'src/app/services/product-order.service';

@Component({
  selector: 'app-update-status',
  templateUrl: './update-status.component.html',
  styleUrls: ['./update-status.component.css'],
})
export class UpdateStatusComponent implements OnInit {
  statuses = ['Delivered', 'Cancelled'];
  statusForm: FormGroup;

  constructor(
    @Inject(MAT_DIALOG_DATA)
    public data: ProductOrder,
    private productOrderService: ProductOrderService,
    private dialogRef: MatDialogRef<UpdateStatusComponent>,
    public loadingService: LoadingService
  ) {
    console.log(data);
    this.initForm();
  }
  initForm() {
    this.statusForm = new FormGroup({
      newStatus: new FormControl('', Validators.required),
    });
  }

  ngOnInit(): void {}

  submitForm() {
    if (this.statusForm.valid) this.updateData();
  }

  updateData() {
    let data = {
      orderId: this.data.productOrderId,
      status: this.statusForm.value.newStatus,
    };
    this.loadingService.enableLoading();
    this.productOrderService.updateStatus(data).subscribe(
      (res) => {
        console.log(res);

        this.loadingService.disableLoading();
        this.dialogRef.close(res);
      },
      (error) => {
        this.loadingService.disableLoading();
        throw new Error(error);
      }
    );
  }
}

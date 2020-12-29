import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Distributor } from 'src/app/models/distributor.model';
import { ProductOrderRequest } from 'src/app/models/product-order-request';
import { Product } from 'src/app/models/product.model';
import { DistributorService } from 'src/app/services/distributor.service';
import { ProductOrderService } from 'src/app/services/product-order.service';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-add-product-order',
  templateUrl: './add-product-order.component.html',
  styleUrls: ['./add-product-order.component.css'],
})
export class AddProductOrderComponent implements OnInit {
  productOrderRequest;
  distributor: Distributor[] = [];
  distributorId: number;
  productId: number;
  orderStatus: string;
  products: Product[];
  unit: string = 'Select Product';
  validationDate = new Date().toISOString().slice(0,10);
  quantity:string;
  price:string;

  constructor(
    private productOrderService: ProductOrderService,
    private productService: ProductService,
    private router: Router,
    private distributorService: DistributorService
  ) {
    this.productOrderRequest = new ProductOrderRequest();
  }

  ngOnInit() {
    this.distributorService
      .fetchAllDistributors()
      .subscribe((response: Distributor[]) => {
        this.distributor = response;
        console.log(this.distributor);
      });
    this.productService.fetchAllProducts().subscribe((response: Product[]) => {
      this.products = response;
    });
  }

  getSelectedOptionText(id: number) {
    this.distributorId = id;
  }

  selectProduct(productId) {
    this.productId = productId;
    this.unit = this.products.find(
      (p) => p.productId == productId
    ).quantityUnit;
  }

  placeOrder() {
    this.productOrderRequest.productId = this.productId;
    this.productOrderRequest.quantity=Number(this.quantity);
    this.productOrderRequest.pricePerUnit=Number(this.price);
    this.productOrderRequest.qualityCheck = 'Passed';
    this.productOrderRequest.distributorId = this.distributorId;

    this.productOrderService
      .createProductOrderRequest(this.productOrderRequest)
      .subscribe((x) => {
        this.router.navigate(['/dashboard/productorders']);
      });
    
  }
}
import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/model/product.model';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {

  product : Product;

  constructor(private service : ProductService) { 
    this.product = new Product();
  }

  ngOnInit(): void {
  }


  saveProduct() {
    this.service.addProduct(this.product);
    console.log(this.product);
  }

}

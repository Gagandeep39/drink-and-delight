import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Product } from '../model/product.model';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  applicationUrl = environment.applicationUrl;

  constructor(private httpClient : HttpClient) { }

  getAllProducts() {
    return this.httpClient.get<Product[]>("http://localhost:9400/stock/product");
  }

  addProduct(product : Product) {
    return this.httpClient.post<Product>("http://localhost:9400/stock/product",product);    
  }
}

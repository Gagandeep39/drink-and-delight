import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  serviceUrl = `${environment.protocol}${environment.applicationUrl}/${environment.stockManagementService}`;

  constructor(private http: HttpClient) {}

  fetchAllProducts() {
    return this.http.get(this.serviceUrl + '/productStock');
  }

  getProductByProductId(productId: number) {
    return this.http.get(this.serviceUrl + '/productStock/' + productId);
  }
}

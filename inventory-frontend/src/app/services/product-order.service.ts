/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-11-03 17:02:23
 * @modify date 2020-11-03 17:02:23
 * @desc [description]
 */
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class ProductOrderService {
  serviceUrl = `http://${environment.applicationUrl}/${environment.productOrderService}`;
  constructor(private http: HttpClient) {}

  fetchAllProductOrders() {
    return this.http.get(`${this.serviceUrl}/productOrder`);
  }

  createProductOrderRequest(productOrder) {
    return this.http.post(`${this.serviceUrl}/productOrder`, productOrder);
  }
}

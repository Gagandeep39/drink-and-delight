/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-11-08 18:35:38
 * @modify date 2020-11-08 18:35:38
 * @desc Manage Supplier related operation
 */
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class SupplierService {
  serviceUrl =
    environment.protocol +
    environment.applicationUrl +
    '/' +
    environment.supplierService;

  constructor(private http: HttpClient) {}

  fetchAllSuppliers() {
    return this.http.get(this.serviceUrl + '/supplier');
  }

  addSupplier(formData) {
    return this.http.post(this.serviceUrl + '/supplier', formData);
  }

  updateSupplier(formData) {
    return this.http.put(this.serviceUrl + '/supplier', formData);
  }

  fetchById(id) {
    return this.http.get(this.serviceUrl + '/supplier/' + id);
  }
}

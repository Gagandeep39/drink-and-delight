import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class WarehouseService {
  serviceUrl =
    environment.protocol +
    environment.applicationUrl +
    '/' +
    environment.supplierService;

  constructor(private http: HttpClient) {}

  fetchAllWarehouse() {
    return this.http.get(this.serviceUrl + '/warehouse');
  }
}

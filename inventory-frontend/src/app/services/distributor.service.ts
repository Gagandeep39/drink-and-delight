/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-11-03 17:02:08
 * @modify date 2020-11-03 17:02:08
 * @desc [description]
 */
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class DistributorService {
  serviceUrl =
    environment.protocol +
    environment.applicationUrl +
    '/' +
    environment.supplierService;

  constructor(private http: HttpClient) {}

  fetchAllDistributors() {
    return this.http.get(this.serviceUrl + '/distributor');
  }

  addDistributor(formData) {
    return this.http.post(this.serviceUrl + '/distributor', formData);
  }

  updateDistributor(formData) {
    return this.http.put(this.serviceUrl + '/distributor', formData);
  }

  fetchById(id) {
    return this.http.get(this.serviceUrl + '/distributor/' + id);
  }
}

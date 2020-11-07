/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-11-05 00:48:39
 * @modify date 2020-11-05 00:48:39
 * @desc Used to manage Users
 */
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class ManageUserService {
  authServiceUrl = `${environment.protocol}${environment.applicationUrl}/${environment.authService}`;

  constructor(private http: HttpClient) {}

  fetchAllUsers() {
    return this.http.get(`${this.authServiceUrl}/register`);
  }

  updateUser(formData) {
    return this.http.put(`${this.authServiceUrl}/register`, formData);
  }

  addUser(formData) {
    return this.http.post(`${this.authServiceUrl}/register`, formData);
  }

  fetchById(id) {
    return this.http.get(`${this.authServiceUrl}/register/${id}`);
  }
}

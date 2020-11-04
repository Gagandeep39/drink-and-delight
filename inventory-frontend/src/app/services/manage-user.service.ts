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
  authServiceUrl = `http://${environment.applicationUrl}/${environment.authService}`;

  constructor(private http: HttpClient) {}

  fetchAllUsers() {
    return this.http.get(`${this.authServiceUrl}/register`);
  }

  updateUser() {}

  addUser() {}
}
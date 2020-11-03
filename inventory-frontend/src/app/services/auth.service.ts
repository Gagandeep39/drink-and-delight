/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-11-04 01:14:46
 * @modify date 2020-11-04 01:14:46
 * @desc Auth Service
 */
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  authServiceUrl = `http://${environment.applicationUrl}/${environment.authService}/`;

  constructor(private http: HttpClient) {}

  login (formData) {
    return this.http.post(this.authServiceUrl + 'auth/login', formData);
  }
}

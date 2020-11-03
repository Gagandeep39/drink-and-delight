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
import { User } from '../models/user.model';
import { tap } from 'rxjs/operators';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  authServiceUrl = `http://${environment.applicationUrl}/${environment.authService}/`;

  constructor(private http: HttpClient, private router: Router) {}

  login(formData) {
    return this.http
      .post(this.authServiceUrl + 'auth/login', formData)
      .pipe(tap((user: User) => this.saveToSessionStorage(user)));
  }

  saveToSessionStorage(user: User) {
    sessionStorage.setItem('user', JSON.stringify(user));
  }

  fetchFromSessionStorage() {
    return JSON.parse(sessionStorage.getItem('user'));
  }

  logout(): void {
    sessionStorage.clear();
    localStorage.clear();
    this.router.navigate(['/login']);
  }
}

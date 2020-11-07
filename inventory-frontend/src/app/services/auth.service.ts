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
import { JwtHelperService } from '@auth0/angular-jwt';
import { EventService } from './event.service';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  authServiceUrl = `${environment.protocol}${environment.applicationUrl}/${environment.authService}`;

  constructor(
    private http: HttpClient,
    private router: Router,
    private jwtHelper: JwtHelperService,
    private eventServie: EventService
  ) {}

  login(formData) {
    return this.http
      .post(`${this.authServiceUrl}/auth/login`, formData)
      .pipe(tap((user: User) => {
        this.saveToSessionStorage(user);
        this.eventServie.loggedInUser.next(user);
      }));
  }

  saveToSessionStorage(user: User) {
    sessionStorage.setItem('user', JSON.stringify(user));
  }

  fetchFromSessionStorage(): User {
    return JSON.parse(sessionStorage.getItem('user'));
  }

  logout(): void {
    sessionStorage.clear();
    localStorage.clear();
    this.router.navigate(['/login']);
  }

  redirectIfLoggedIn() {
    if (this.fetchFromSessionStorage()?.token)
      this.router.navigate(['/dashboard']);
  }

  isAuthenticated(): boolean {
    const token = this.fetchFromSessionStorage()?.token;
    return !this.jwtHelper.isTokenExpired(token);
  }

  requestSecretQuestion (username) {
    return this.http.get(`${this.authServiceUrl}/auth/forgotpassword/${username}`);
  }

  requestPasswordReset (formData) {
    return this.http.put(`${this.authServiceUrl}/auth/forgotpassword`, formData);
  }

  getRole() {
    return this.fetchFromSessionStorage()?.role;
  }
}

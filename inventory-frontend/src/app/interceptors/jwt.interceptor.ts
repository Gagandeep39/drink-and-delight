/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-11-04 01:49:07
 * @modify date 2020-11-04 01:49:07
 * @desc Auth Interceptor
 */
import {
  HttpEvent,
  HttpHandler,
  HttpInterceptor,
  HttpRequest,
} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthService } from '../services/auth.service';

@Injectable()
export class JwtInterceptor implements HttpInterceptor {
  constructor(private authService: AuthService) {}
  intercept(
    request: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {
    let authReq = request;
    const token = this.authService.fetchFromSessionStorage()?.token;
    if (token != null)
      authReq = request.clone({
        headers: request.headers.set('Authorization', 'Bearer ' + token),
      });
    return next.handle(authReq);
  }
}

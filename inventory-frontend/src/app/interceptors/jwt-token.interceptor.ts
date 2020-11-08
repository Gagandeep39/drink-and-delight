/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-11-05 01:15:10
 * @modify date 2020-11-05 01:15:10
 * @desc JWT interceptor, Appends JWT token
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
export class JwtTokenInterceptor implements HttpInterceptor {
  constructor(private authService: AuthService) {}

  intercept(
    request: HttpRequest<unknown>,
    next: HttpHandler
  ): Observable<HttpEvent<unknown>> {
    let authReq = request;
    const token = this.authService.fetchFromSessionStorage()?.token;
    // Null will still add a token 
    if (token !== undefined)
      authReq = request.clone({
        headers: request.headers.append('Authorization', `Bearer ${token}`)
        
      // .append('access-control-allow-origin', '*')
      // .append('Access-Control-Allow-Headers', 'authorization')
      // .append('Access-Control-Allow-Methods', "*"),
      });
    return next.handle(authReq);
  }
}

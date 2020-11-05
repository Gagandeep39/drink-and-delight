/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-11-05 01:15:10
 * @modify date 2020-11-05 01:15:10
 * @desc Add cors header
 */
import {
  HttpEvent,
  HttpHandler,
  HttpInterceptor,
  HttpRequest,
} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable()
export class CorsInterceptor implements HttpInterceptor {
  constructor() {}

  intercept(
    request: HttpRequest<unknown>,
    next: HttpHandler
  ): Observable<HttpEvent<unknown>> {
    let allReq = request.clone({
      headers: request.headers.set('Access-Control-Allow-Origin', '*'),
    });
    return next.handle(allReq);
  }
}

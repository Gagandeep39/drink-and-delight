/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-11-04 09:27:13
 * @modify date 2020-11-04 09:27:13
 * @desc Global Interceptors
 */
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { ErrorHandler } from '@angular/core';
import { JWT_OPTIONS } from '@auth0/angular-jwt';
import { GlobalErrorHandler } from '../providers/global-error-handler';
import { CorsInterceptor } from './cors.interceptor';
import { HttpErrorInterceptor } from './http-error.interceptor';
import { JwtTokenInterceptor } from './jwt-token.interceptor';

export const httpInterceptors = [
  {
    provide: HTTP_INTERCEPTORS,
    useClass: JwtTokenInterceptor,
    multi: true,
  },
  {
    provide: JWT_OPTIONS,
    useValue: JWT_OPTIONS,
  },
  {
    provide: ErrorHandler,
    useClass: GlobalErrorHandler,
  },
  {
    provide: HTTP_INTERCEPTORS,
    useClass: HttpErrorInterceptor,
    multi: true,
  },
  // Breaks Code for now 
  // {
  //   provide: HTTP_INTERCEPTORS,
  //   useClass: CorsInterceptor,
  //   multi: true,
  // },
];

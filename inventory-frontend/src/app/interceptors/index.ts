import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { JwtInterceptor, JWT_OPTIONS } from '@auth0/angular-jwt';

/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-11-04 09:27:13
 * @modify date 2020-11-04 09:27:13
 * @desc Global Interceptors
 */
export const httpInterceptors = [
  {
    provide: HTTP_INTERCEPTORS,
    useClass: JwtInterceptor,
    multi: true,
  },
  { provide: JWT_OPTIONS, useValue: JWT_OPTIONS },
];

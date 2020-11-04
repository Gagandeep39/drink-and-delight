/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-11-03 17:02:23
 * @modify date 2020-11-03 17:02:23
 * @desc [description]
 */
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProductOrderService {
  applicationUrl = environment.applicationUrl;

  constructor() { }
}

/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-11-04 20:11:27
 * @modify date 2020-11-04 20:11:27
 * @desc Loading UI status 
 */
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class LoadingService {
  public loading = false;

  constructor() {}

  enableLoading() {
    this.loading = true;
  }

  disableLoading() {
    this.loading = false;
  }
}

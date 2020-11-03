import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SupplierService {
  applicationUrl = environment.applicationUrl;

  constructor() { }
}

import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class RawmaterialOrderService {
  applicationUrl = environment.applicationUrl;

  constructor() { }
}
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class RawmaterialService {
  applicationUrl = environment.applicationUrl;

  constructor() { }
}

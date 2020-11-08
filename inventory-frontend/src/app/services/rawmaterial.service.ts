import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class RawmaterialService {
  serviceUrl = `${environment.protocol}${environment.applicationUrl}/${environment.stockManagementService}`;

  constructor(private http: HttpClient) {}

  fetchAllRawmaterials() {
    console.log('Executed');
    
    return this.http.get(this.serviceUrl + '/rawMaterialStock');
  }
}

import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { RawMaterial } from '../model/raw-material.model';

@Injectable({
  providedIn: 'root'
})
export class RawmaterialOrderService {
  applicationUrl = environment.applicationUrl;

  constructor(private httpClient : HttpClient) { }

  getAllRawMaterials() {
    return this.httpClient.get<RawMaterial[]>("");
  }

  AddRawMaterial(product : RawMaterial) {
    return this.httpClient.post<RawMaterial>("","");    
  }
}

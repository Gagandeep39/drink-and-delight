import { Component, OnInit } from '@angular/core';
import { RawMaterial } from 'src/app/model/raw-material.model';
import { RawmaterialService } from 'src/app/services/rawmaterial.service';

@Component({
  selector: 'app-view-raw-material',
  templateUrl: './view-raw-material.component.html',
  styleUrls: ['./view-raw-material.component.css']
})
export class ViewRawMaterialComponent implements OnInit {

  rawMaterials : RawMaterial[] = [];

  constructor(private rawMaterialService : RawmaterialService) { }

  ngOnInit(): void {
    this.rawMaterialService.getAllRawMaterials().subscribe(data => {
      this.rawMaterials = data;
    });
  }

}

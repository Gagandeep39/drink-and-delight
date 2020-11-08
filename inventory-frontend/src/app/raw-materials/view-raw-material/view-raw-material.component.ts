import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RawMaterial } from 'src/app/models/raw-material.model';
import { RawmaterialService } from 'src/app/services/rawmaterial.service';

@Component({
  selector: 'app-view-raw-material',
  templateUrl: './view-raw-material.component.html',
  styleUrls: ['./view-raw-material.component.css'],
})
export class ViewRawMaterialComponent implements OnInit {
  rawMaterials: RawMaterial[] = [];

  constructor(
    private rawMaterialService: RawmaterialService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.rawMaterialService
      .fetchAllRawmaterials()
      .subscribe((data: RawMaterial[]) => {
        this.rawMaterials = data;
      });
  }

  navigate(): void {
    this.router.navigate(['/dashboard/addrawmaterial']);
  }
}

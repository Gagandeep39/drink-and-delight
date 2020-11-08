import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Distributor } from 'src/app/models/distributor.model';
import { DistributorService } from 'src/app/services/distributor.service';

@Component({
  selector: 'app-add-distributor',
  templateUrl: './add-distributor.component.html',
  styleUrls: ['./add-distributor.component.css'],
})
export class AddDistributorComponent implements OnInit {
  distributor: Distributor;
  constructor(private service: DistributorService, private router: Router) {
    this.distributor = new Distributor();
  }

  ngOnInit(): void {}

  addDistributor() {
    this.service.addDistributor(this.distributor).subscribe((res) => {
      this.router.navigate(['/dashboard/distributors']);
    });
  }
}

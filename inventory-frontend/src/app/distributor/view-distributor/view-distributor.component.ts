import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Distributor } from 'src/app/models/distributor.model';
import { AuthService } from 'src/app/services/auth.service';
import { DistributorService } from 'src/app/services/distributor.service';

@Component({
  selector: 'app-view-distributor',
  templateUrl: './view-distributor.component.html',
  styleUrls: ['./view-distributor.component.css'],
})
export class ViewDistributorComponent implements OnInit {
  distributor: Distributor;
  distributors: Distributor[];
  role;
  constructor(
    private distributorService: DistributorService,
    private router: Router,
    private authService: AuthService
  ) {}

  ngOnInit(): void {
    this.role = this.authService.getRole();
    this.distributorService
      .fetchAllDistributors()
      .subscribe((response: Distributor[]) => {
        this.distributors = response;
      });
  }

  updateDistributor(id: number) {
    console.log(id);
    
    this.router.navigate(['/dashboard/updatedistributor', id]);
  }
}

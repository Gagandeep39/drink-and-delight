import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Distributor } from 'src/app/models/distributor.model';
import { DistributorService } from 'src/app/services/distributor.service';

@Component({
  selector: 'app-update-distributor',
  templateUrl: './update-distributor.component.html',
  styleUrls: ['./update-distributor.component.css'],
})
export class UpdateDistributorComponent implements OnInit {
  id: number;
  distributor: Distributor;
  constructor(
    private route: ActivatedRoute,
    private service: DistributorService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.distributor = new Distributor();
    this.id = this.route.snapshot.params['id'];
    this.service.fetchById(this.id).subscribe(
      (data: Distributor) => {
        console.log(data);
        this.distributor = data;
      },
      (error) => console.log(error)
    );
  }

  updateDistributor() {
    this.service.updateDistributor(this.distributor).subscribe(
      (data) => {
        this.distributor = new Distributor();
        this.gotoList();
      },
      (error) => console.log(error)
    );
  }

  onSubmit() {
    this.updateDistributor();
  }
  gotoList() {
    this.router.navigate(['/dashboard/distributors']);
  }
}

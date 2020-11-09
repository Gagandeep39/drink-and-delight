/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-11-05 02:27:43
 * @modify date 2020-11-05 02:27:43
 * @desc View all users
 */
import {
  Component,
  OnInit,
  ViewChild,
  AfterViewInit,
  OnDestroy,
} from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Subscription } from 'rxjs';
import { UserDetails } from 'src/app/models/user-details.model';
import { LoadingService } from 'src/app/services/loading.service';
import { ManageUserService } from 'src/app/services/manage-user.service';

@Component({
  selector: 'app-view-users',
  templateUrl: './view-users.component.html',
  styleUrls: ['./view-users.component.css'],
})
export class ViewUsersComponent implements OnInit, AfterViewInit, OnDestroy {
  dataSource = new MatTableDataSource<UserDetails>();
  @ViewChild(MatSort, { static: false }) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;
  // Specify columns tht should be rendered, must match names of matColumnDef
  // ID is not beign displayed as its not present here
  displayedColumns: string[] = [
    'userId',
    'username',
    'name',
    'role',
    'phoneNo',
    'city',
    'edit'
  ];
  userSubscription: Subscription;

  constructor(
    private manageUserService: ManageUserService, // private store: Store<fromTraining.State>,
    public loadingService: LoadingService
  ) {}

  ngOnInit(): void {
    this.fetchAllUsers();
  }
  fetchAllUsers() {
    this.loadingService.enableLoading();
    this.userSubscription = this.manageUserService
      .fetchAllUsers()
      .subscribe((response: UserDetails[]) => {
        this.dataSource.data = response;
        this.loadingService.disableLoading();
      });
  }

  ngAfterViewInit() {
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
  }

  doFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  ngOnDestroy(): void {
    this.userSubscription.unsubscribe();
  }
}

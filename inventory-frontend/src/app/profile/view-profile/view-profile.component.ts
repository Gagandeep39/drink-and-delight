import { Component, OnInit } from '@angular/core';
import { UserDetails } from 'src/app/models/user-details.model';
import { AuthService } from 'src/app/services/auth.service';
import { LoadingService } from 'src/app/services/loading.service';
import { ManageUserService } from 'src/app/services/manage-user.service';

@Component({
  selector: 'app-view-profile',
  templateUrl: './view-profile.component.html',
  styleUrls: ['./view-profile.component.css'],
})
export class ViewProfileComponent implements OnInit {
  user: UserDetails;

  constructor(
    public loadingService: LoadingService,
    private manageUser: ManageUserService,
    private authService: AuthService
  ) {
    this.fetchUser();
  }

  fetchUser() {
    this.loadingService.enableLoading();
    this.manageUser
      .fetchById(this.authService.fetchFromSessionStorage()?.userId)
      .subscribe(
        (res: UserDetails) => {
          this.user = res;
          this.loadingService.disableLoading();
        },
        (error) => {
          this.loadingService.disableLoading();
          throw new Error('Cannot connect to server');
        }
      );
  }

  ngOnInit(): void {}
}

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user.model';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css'],
})
export class NavigationComponent implements OnInit {
  public user: User = null;
  paths = [
    {
      route: '/dashboard/viewprofile',
      class: 'fas fa-user',
      label: 'Profile',
      role: 'User',
    },
    {
      route: '/dashboard/productorders',
      class: 'fas fa-truck-moving',
      label: 'Products Orders',
      role: 'User',
    },
    {
      route: '/dashboard/products',
      class: 'fas fa-boxes',
      label: 'Products',
      role: 'User',
    },
    {
      route: '/dashboard/rawmaterialorders',
      class: 'fas fa-truck-moving',
      label: 'RM Orders',
      role: 'User',
    },
    {
      route: '/dashboard/rawmaterials',
      class: 'fas fa-boxes',
      label: 'Raw Materials',
      role: 'User',
    },
    {
      route: '/dashboard/suppliers',
      class: 'fas fa-people-carry',
      label: 'Suppliers',
      role: 'User',
    },
    {
      route: '/dashboard/distributors',
      class: 'fas fa-people-carry',
      label: 'Distributors',
      role: 'User',
    },
    {
      route: '/dashboard/users',
      class: 'fas fa-users',
      label: 'Manage Users',
      role: 'Admin',
    },
  ];

  constructor(private authService: AuthService, private router: Router) {}

  ngOnInit(): void {
    if (this.authService.fetchFromSessionStorage() !== null)
      this.user = this.authService.fetchFromSessionStorage();
    else this.router.navigateByUrl('/login');
    if (this.user.role === 'User')
      this.paths = this.paths.filter((path) => path.role === this.user.role);
  }

  signOut() {
    this.authService.logout();
  }
}

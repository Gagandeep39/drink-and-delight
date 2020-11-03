/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-11-03 14:51:33
 * @modify date 2020-11-03 14:51:33
 * @desc Centralized Routing
 */
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ChangePasswordComponent } from './auth/change-password/change-password.component';
import { LoginComponent } from './auth/login/login.component';
import { AddProductOrderComponent } from './products/add-product-order/add-product-order.component';
import { AddProductComponent } from './products/add-product/add-product.component';
import { ViewProductOrdersComponent } from './products/view-product-orders/view-product-orders.component';
import { ViewProductsComponent } from './products/view-products/view-products.component';
import { ViewProfileComponent } from './profile/view-profile/view-profile.component';
import { AddRawMaterialOrderComponent } from './raw-materials/add-raw-material-order/add-raw-material-order.component';
import { AddRawMaterialComponent } from './raw-materials/add-raw-material/add-raw-material.component';
import { ViewRawMaterialOrdersComponent } from './raw-materials/view-raw-material-orders/view-raw-material-orders.component';
import { ViewRawMaterialComponent } from './raw-materials/view-raw-material/view-raw-material.component';
import { AddUserComponent } from './users/add-user/add-user.component';
import { ViewUsersComponent } from './users/view-users/view-users.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'changepassword', component: ChangePasswordComponent },
  { path: 'products', component: ViewProductsComponent },
  { path: 'addproduct', component: AddProductComponent },
  { path: 'productorders', component: ViewProductOrdersComponent },
  { path: 'addproductorder', component: AddProductOrderComponent },
  { path: 'rawmaterials', component: ViewRawMaterialComponent },
  { path: 'addrawmaterial', component: AddRawMaterialComponent },
  { path: 'rawmaterialorders', component: ViewRawMaterialOrdersComponent },
  { path: 'addrawmaterialorder', component: AddRawMaterialOrderComponent },
  { path: 'users', component: ViewUsersComponent },
  { path: 'adduser', component: AddUserComponent },
  { path: 'viewprofile', component: ViewProfileComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}

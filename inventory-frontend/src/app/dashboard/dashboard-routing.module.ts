/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-11-03 22:11:13
 * @modify date 2020-11-03 22:11:13
 * @desc Dashboard routing module
 */
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddDistributorComponent } from '../distributor/add-distributor/add-distributor.component';
import { ViewDistributorComponent } from '../distributor/view-distributor/view-distributor.component';
import { AuthGuard } from '../guards/auth.guard';
import { AddProductOrderComponent } from '../products/add-product-order/add-product-order.component';
import { AddProductComponent } from '../products/add-product/add-product.component';
import { ViewProductOrdersComponent } from '../products/view-product-orders/view-product-orders.component';
import { ViewProductsComponent } from '../products/view-products/view-products.component';
import { ViewProfileComponent } from '../profile/view-profile/view-profile.component';
import { AddRawMaterialOrderComponent } from '../raw-materials/add-raw-material-order/add-raw-material-order.component';
import { AddRawMaterialComponent } from '../raw-materials/add-raw-material/add-raw-material.component';
import { ViewRawMaterialOrdersComponent } from '../raw-materials/view-raw-material-orders/view-raw-material-orders.component';
import { ViewRawMaterialComponent } from '../raw-materials/view-raw-material/view-raw-material.component';
import { AddSupplierComponent } from '../supplier/add-supplier/add-supplier.component';
import { ViewSupplierComponent } from '../supplier/view-supplier/view-supplier.component';
import { AddUserComponent } from '../users/add-user/add-user.component';
import { ViewUsersComponent } from '../users/view-users/view-users.component';
import { DashboardComponent } from './dashboard.component';

const routes: Routes = [
  {
    path: 'dashboard',
    component: DashboardComponent,
    canActivate: [AuthGuard],
    children: [
      { path: 'products', component: ViewProductsComponent },
      { path: 'addproduct', component: AddProductComponent },
      { path: 'productorders', component: ViewProductOrdersComponent },
      { path: 'addproductorder', component: AddProductOrderComponent },
      { path: 'rawmaterials', component: ViewRawMaterialComponent },
      { path: 'addrawmaterial', component: AddRawMaterialComponent },
      { path: 'rawmaterialorders', component: ViewRawMaterialOrdersComponent },
      { path: 'addrawmaterialorder', component: AddRawMaterialOrderComponent },
      { path: 'suppliers', component: ViewSupplierComponent },
      { path: 'addsupplier', component: AddSupplierComponent },
      { path: 'distributors', component: ViewDistributorComponent },
      { path: 'adddistributors', component: AddDistributorComponent },
      { path: 'users', component: ViewUsersComponent },
      { path: 'adduser', component: AddUserComponent },
      { path: 'viewprofile', component: ViewProfileComponent },
      { path: '', component: ViewProfileComponent },
      { path: '**', redirectTo: '/404' },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class DashboardRoutingModule {}

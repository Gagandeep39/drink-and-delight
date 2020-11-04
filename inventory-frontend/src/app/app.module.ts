import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FooterComponent } from './shared/footer/footer.component';
import { NavigationComponent } from './shared/navigation/navigation.component';
import { ViewProductsComponent } from './products/view-products/view-products.component';
import { AddProductComponent } from './products/add-product/add-product.component';
import { AddRawMaterialComponent } from './raw-materials/add-raw-material/add-raw-material.component';
import { ViewRawMaterialComponent } from './raw-materials/view-raw-material/view-raw-material.component';
import { ViewRawMaterialOrdersComponent } from './raw-materials/view-raw-material-orders/view-raw-material-orders.component';
import { AddRawMaterialOrderComponent } from './raw-materials/add-raw-material-order/add-raw-material-order.component';
import { AddProductOrderComponent } from './products/add-product-order/add-product-order.component';
import { ViewProductOrdersComponent } from './products/view-product-orders/view-product-orders.component';
import { AddUserComponent } from './users/add-user/add-user.component';
import { ViewUsersComponent } from './users/view-users/view-users.component';
import { ViewProfileComponent } from './profile/view-profile/view-profile.component';
import { LoginComponent } from './auth/login/login.component';
import { ChangePasswordComponent } from './auth/change-password/change-password.component';
import { AddSupplierComponent } from './supplier/add-supplier/add-supplier.component';
import { ViewSupplierComponent } from './supplier/view-supplier/view-supplier.component';
import { ViewDistributorComponent } from './distributor/view-distributor/view-distributor.component';
import { AddDistributorComponent } from './distributor/add-distributor/add-distributor.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    NavigationComponent,
    ViewProductsComponent,
    AddProductComponent,
    AddRawMaterialComponent,
    ViewRawMaterialComponent,
    ViewRawMaterialOrdersComponent,
    AddRawMaterialOrderComponent,
    AddProductOrderComponent,
    ViewProductOrdersComponent,
    AddUserComponent,
    ViewUsersComponent,
    ViewProfileComponent,
    LoginComponent,
    ChangePasswordComponent,
    AddSupplierComponent,
    ViewSupplierComponent,
    ViewDistributorComponent,
    AddDistributorComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}

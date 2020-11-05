/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-11-03 22:15:06
 * @modify date 2020-11-03 22:15:06
 * @desc Auth related functions
 */
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ChangePasswordComponent } from './change-password/change-password.component';
import { LoginComponent } from './login/login.component';
import { AuthComponent } from "./auth.component";
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AuthRoutingModule } from './auth-routing.module';
import { SharedModule } from '../shared/shared.module';
import { RequestQuestionComponent } from './request-question/request-question.component';



@NgModule({
  declarations: [
    LoginComponent,
    ChangePasswordComponent,
    AuthComponent,
    RequestQuestionComponent
  ],
  imports: [
    CommonModule,
    AuthRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    SharedModule
  ]
})
export class AuthModule { }

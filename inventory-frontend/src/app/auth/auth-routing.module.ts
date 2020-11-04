/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-11-03 22:11:13
 * @modify date 2020-11-03 22:11:13
 * @desc Auth routing module
 */
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthComponent } from './auth.component';
import { ChangePasswordComponent } from './change-password/change-password.component';
import { LoginComponent } from './login/login.component';
import { RequestQuestionComponent } from './request-question/request-question.component';

const routes: Routes = [
  {
    path: 'login',
    component: AuthComponent,
    children: [
      { path: '', component: LoginComponent },
      { path: 'changepassword', component: ChangePasswordComponent },
      { path: 'forgotpassword', component: RequestQuestionComponent },
      { path: '**', redirectTo: '/404' },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class AuthRoutingModule {}

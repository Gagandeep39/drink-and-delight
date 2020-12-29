/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-11-05 03:12:11
 * @modify date 2020-11-05 03:12:11
 * @desc Add user
 */
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { Gender } from 'src/app/models/gender.model';
import { LoadingService } from 'src/app/services/loading.service';
import { ManageUserService } from 'src/app/services/manage-user.service';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css'],
})
export class AddUserComponent implements OnInit {
  genders = Gender;
  submitted = false;
  userForm: FormGroup;
  addUserSubscription: Subscription;
  message = null;
  maxDate = new Date(new Date().setFullYear(new Date().getFullYear() - 14)).toISOString().slice(0, 10)
  // new Date().toISOString().slice(0,10) - ;

  constructor(
    private manageUserService: ManageUserService,
    public loadingService: LoadingService,
    private router: Router
  ) {
    this.initForm();
  }

  ngOnInit(): void {}

  submitForm() {
    this.submitted = true;
    if (this.userForm.valid) this.addUser(this.userForm.value);
  }

  addUser(formData) {
    this.loadingService.enableLoading();
    this.addUserSubscription = this.manageUserService
      .addUser(formData)
      .subscribe(
        (response) => {
          this.loadingService.disableLoading();
          this.message =
            'Successfully Created user with ID ' + response['userId'];
          setTimeout(() => {
            this.router.navigateByUrl('/dashboard/users');
          }, 3000);
        },
        (error) => {
          console.log(error);
          this.loadingService.disableLoading();
          if (error.error.message === 'FieldException')
            error.error.errors.forEach((element) =>
              this.userForm.controls[element.field]?.setErrors({
                serverValidationError: element.message,
              })
            );
          else throw new Error(error);
        }
      );
  }

  initForm() {
    this.userForm = new FormGroup(
      {
        firstName: new FormControl('', [Validators.required]),
        lastName: new FormControl('', [Validators.required]),
        phoneNo: new FormControl('', [Validators.required]),
        emailId: new FormControl('', [Validators.required]),
        dob: new FormControl('', [Validators.required]),
        designation: new FormControl('', [Validators.required]),
        gender: new FormControl('', [Validators.required]),
        username: new FormControl('', [Validators.required]),
        password: new FormControl('', [Validators.required]),
        password2: new FormControl('', [Validators.required]),
        address: new FormGroup({
          state: new FormControl('', [
            Validators.required,
            Validators.minLength(4),
            Validators.maxLength(30),
          ]),
          area: new FormControl('', [
            Validators.required,
            Validators.minLength(4),
            Validators.maxLength(30),
          ]),
          city: new FormControl('', [
            Validators.required,
            Validators.minLength(4),
            Validators.maxLength(30),
          ]),
          pincode: new FormControl('', [
            Validators.required,
            Validators.pattern('[0-9]{6}'),
          ]),
        }),
      },
      { validators: this.matchPassword }
    );
  }

  matchPassword(control: FormControl) {
    const password = control.get('password').value;
    const password2 = control.get('password2').value;
    if (password != password2) {
      control.get('password2').setErrors({ passwordMatchError: true });
    } else {
      return null;
    }
  }
}

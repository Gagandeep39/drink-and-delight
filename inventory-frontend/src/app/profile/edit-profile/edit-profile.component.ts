/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-11-05 20:01:13
 * @modify date 2020-11-05 20:01:13
 * @desc Allows Profile Editing
 */
import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { Gender } from 'src/app/models/gender.model';
import { AuthService } from 'src/app/services/auth.service';
import { LoadingService } from 'src/app/services/loading.service';
import { ManageUserService } from 'src/app/services/manage-user.service';

@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.css'],
})
export class EditProfileComponent implements OnInit, OnDestroy {
  message = null;
  userForm: FormGroup;
  submitted = false;
  userFormSubscription: Subscription;
  genders = Gender;

  constructor(
    private userService: ManageUserService,
    public loadingService: LoadingService,
    private router: Router,
    public authService: AuthService,
    private route: ActivatedRoute
  ) { }

  fetchUserDataFromServer() {
    this.loadingService.enableLoading();
    this.userService
      .fetchById(this.authService.fetchFromSessionStorage()?.userId)
      .subscribe((res) => {
        this.loadingService.disableLoading();
        this.populateFormFields(res);
      });
  }

  submitForm() {
    this.submitted = true;
    console.log(this.userForm.getRawValue());

    if (this.userForm.valid) this.updateUser(this.userForm.getRawValue());
  }

  initForm() {
    console.log();
    this.userForm = new FormGroup({
      userId: new FormControl(''),
      firstName: new FormControl('', [Validators.required]),
      lastName: new FormControl('', [Validators.required]),
      phoneNo: new FormControl('', [Validators.required]),
      emailId: new FormControl('', [Validators.required]),
      dob: new FormControl('', [Validators.required]),
      designation: new FormControl('', [Validators.required]),
      gender: new FormControl('', [Validators.required]),
      securityQuestion: new FormControl('', [Validators.required]),
      securityAnswer: new FormControl('', [Validators.required]),
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
    });
  }

  populateFormFields(userDetails) {
    this.userForm.patchValue({
      userId: userDetails.userId,
      firstName: userDetails.firstName,
      lastName: userDetails.lastName,
      phoneNo: userDetails.phoneNo,
      emailId: userDetails.emailId,
      dob: userDetails.dob,
      designation: userDetails.designation,
      gender: userDetails.gender,
      securityQuestion: '',
      securityAnswer: '',
      address: {
        state: userDetails.address.state,
        area: userDetails.address.area,
        city: userDetails.address.city,
        pincode: userDetails.address.pincode,
      },
    });
  }

  updateUser(formData) {
    this.userService.updateUser(formData).subscribe(
      (response) => {
        this.router.navigate(['/dashboard']);
        this.loadingService.disableLoading();
        this.message =
          'Successfully Created user with ID ' + response['userId'];
        setTimeout(() => {
          this.router.navigateByUrl('/dashboard/users');
        }, 3000);
      },
      (error) => {
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

  ngOnInit(): void {
    this.initForm();
    if (this.route.snapshot.params['id'])
      this.adminEdit(this.route.snapshot.params['id'])
    else
      this.fetchUserDataFromServer();
  }

  adminEdit(id: number) {
    this.loadingService.enableLoading();
    this.userService
      .fetchById(id)
      .subscribe((res) => {
        this.loadingService.disableLoading();
        this.populateFormFields(res);
      });
  }

  ngOnDestroy(): void {
    if (this.userFormSubscription) this.userFormSubscription.unsubscribe();
  }

  goBack() {
    if (this.route.snapshot.params['id'])
      this.router.navigateByUrl('/dashboard/users');
    else 
      this.router.navigateByUrl('/dashboard');
  }
}

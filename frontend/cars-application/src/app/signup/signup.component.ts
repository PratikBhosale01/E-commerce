import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from "@angular/forms"
import { MatSnackBar } from '@angular/material/snack-bar';
import { Route, Router } from '@angular/router';
import { LoginService } from '../service/login.service';
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  public form !: FormGroup;
  ;

  constructor(private formBuilder: FormBuilder, private snackBar: MatSnackBar, private http: HttpClient, private router: Router,
    private log: LoginService) {
    this.form = this.formBuilder.group({
      email: ['', [Validators.required,Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")]],
      username: ['', [Validators.required,Validators.minLength(6),Validators.maxLength(10)]],
      password: ['', [Validators.required , Validators.pattern(/^(?=.*\d)(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z]).{8,}$/)]],
      address: ['', [Validators.required, Validators.minLength(6)]],
    });
  }
  ngOnInit(): void {
    if (this.log.loggedin) {
      alert("You are already login");
      this.router.navigateByUrl("/dashbord")
    }
  }


  signUp() {
    this.http.post('http://localhost:8081/userproduct/userproduct', this.form.value)
      .subscribe(response => {
        console.log(response);
      });
    if (this.form.valid) {
      console.log(this.form.value);
      this.router.navigateByUrl("/login")
      this.snackBar.open('Form submitted successfully!', '', { duration: 3000 });
    } else {
      this.snackBar.open('Please fix the errors in the form.', '', { duration: 3000 });
    }


  }

  get username(){
    return this.form.get('username');
  }

  get email(){
    return this.form.get('email');
  }

get password(){
  return this.form.get('password');
}

get address(){
  return this.form.get('address');
}


}

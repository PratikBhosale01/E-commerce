import { HttpClient } from '@angular/common/http';
import { Token } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { LoginService } from '../service/login.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  responsedata: any;
  logindetails = this.log.loggedin;

  public token: string = "";
  public form !: FormGroup;
  constructor(private formBuilder: FormBuilder, private snackBar: MatSnackBar, private http: HttpClient, private router: Router,
    private log: LoginService) {
    this.form = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(7)]]
    });
  }

  ngOnInit(): void {

    if (this.log.loggedin && localStorage.getItem('user') == "admin") {

      this.router.navigateByUrl("/admin");
    } else if (this.log.loggedin) {
      alert("You are already login");
      this.router.navigateByUrl("/dashbord")

    }


  }




  login() {
    // console.log(this.form.value);
    this.log.login(this.form.value).subscribe(response => {
      this.responsedata = response;
      localStorage.setItem("jwtToken", this.responsedata.token);
      alert(this.responsedata.message);
      // console.log(this.responsedata.role);
      this.token = this.responsedata.token;

      if (this.responsedata.role == "admin") {
        //console.log(this.responsedata.token);
        this.router.navigateByUrl("/admin");
        localStorage.setItem("user", "admin");
        this.log.isloggedin();

      } else if (this.responsedata.message == "User successfully logged in") {
        // console.log(this.responsedata.email);
        localStorage.setItem("email", this.responsedata.email);
        // console.log(localStorage.getItem('email'))
        this.log.isloggedin();
        localStorage.setItem("user", "user")
        this.router.navigateByUrl("/dashboard");
        this.snackBar.open('Login successfully!', '', { duration: 3000 });
      } else if (!this.responsedata.message) { alert("please input valid username and password") }
    });
    if (this.form.valid) {
      // console.log(this.form.value);

    } else{
       
      this.snackBar.open('please input valid username and password.', '', { duration: 3000 });
      
    }



  }
}

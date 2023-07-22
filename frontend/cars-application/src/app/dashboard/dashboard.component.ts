import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { product } from '../model/product';
import { LoginService } from '../service/login.service';
import { ProductService } from '../service/product.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  public AllProducts: any;
  formBuilder: any;
  email = localStorage.getItem('email');
  products:any = []
  cartItems:product[]=[];
  data: any;
  logindetail = this.login.loggedin;

  constructor(private http: HttpClient, private prod: ProductService, private login: LoginService, private router: Router) {


  }
  ngOnInit(): void {


    this.http.get(`http://localhost:8081/userproduct/user/${localStorage.getItem('email')}`)
      .subscribe(response => {
        console.log(response);
        this.data = response;
        // this.cartItems = this.data.products;

      });

    this.prod.getProducts(localStorage.getItem('jwtToken')).subscribe(response => {
      //  console.log(response);
      this.AllProducts = response;

    });

  }
  public form !: FormGroup;

  addToCart(product: any) {
    // console.log(product);
    if (!this.cartItems) {
      this.cartItems = []; // initialize the array if it's null
    }
    this.cartItems.push(product); // add the item to the array
    
    console.log(this.cartItems);

    if (this.login.loggedin) {
      // this.products.push(product);
      var user = {
        email: this.email,
        products: this.cartItems
      };
      // console.log(this.products);
      // console.log(localStorage.getItem('email'))
      alert("added to cart");
      this.http.post('http://localhost:8081/userproduct/update', user)
        .subscribe(response => {
          // console.log(response);
        });
    }
    else {
      alert("please login to add")
      this.router.navigateByUrl("/login");
    }
  }
  logout() {
    this.login.isloggedout;
    location.reload();
    localStorage.setItem("email", '');
    alert("logged out");
  }
}














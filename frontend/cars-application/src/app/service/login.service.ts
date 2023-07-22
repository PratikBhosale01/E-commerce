import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  loggedin:boolean=false;

  constructor( private http:HttpClient) { 


  }


  login(data:any) {
   return this.http.post('http://localhost:8085/userservice/login',data);

   
  }


   isloggedin() {
    this.loggedin=true;
  }


  isloggedout() {
    this.loggedin=false;
  }




}








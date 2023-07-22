import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http:HttpClient) {
   }


   getProducts(token:any){
    const headers = new HttpHeaders({
      'Content-Type'  : 'application/json',
      'Authorization' : `Bearer ${token}`
    });
   return this.http.get('http://localhost:8081s/product/get', { headers });

   }

   saveProducts(token:any,data:any){
    const headers = new HttpHeaders({
      'Content-Type'  : 'application/json',
      'Authorization' : `Bearer ${token}`
    });
   return this.http.post('http://localhost:8081/product/save', data ,{ headers });

   }


   deleteProduct(token:any,productid:any){
    const headers = new HttpHeaders({
      'Content-Type'  : 'application/json',
      'Authorization' : `Bearer ${token}`
    });
   return this.http.delete(`http://localhost:8081/product/delete-product/${productid}`,{ headers });

   }



























}

import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../models/product';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient) { }

  private url: string = "/products";

  public getProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(environment.baseUrl+this.url, {headers: environment.headers, withCredentials: environment.withCredentials})
  }

  public getProduct(id: number): Observable<Product>{
    return this.http.get<Product>(environment.baseUrl+this.url+'/'+id, {headers: environment.headers, withCredentials: environment.withCredentials})
  }

  public addToCart(product: Product): void {
    
  }
}

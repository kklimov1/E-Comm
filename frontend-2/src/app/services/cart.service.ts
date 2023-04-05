import { Injectable } from '@angular/core';
import { Product } from '../models/product';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  listProducts: Product[] = [];
  constructor() { }
  public getCart(): Product[] {
    return this.listProducts;
  }
  public emptyCart(): void {
    this.listProducts = [];
  }
  public addToCart(prod: Product): void {
    this.listProducts.push(prod);
  }
}

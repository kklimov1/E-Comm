import { Component, OnInit } from '@angular/core';

import { Product } from 'src/app/models/product';
import { CartService } from 'src/app/services/cart.service';
import { UntypedFormControl, UntypedFormGroup } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit{
  cartList: Product[] =[];
  total: number=0;

  checkoutForm = new UntypedFormGroup({
    address: new UntypedFormControl(''),
    zipCode: new UntypedFormControl(''),
    Country: new UntypedFormControl('')
  })

  constructor(private router: Router, private cartService: CartService) {};

  ngOnInit(): void { this.cartList = this.cartService.getCart();
    for (let i=0; i<this.cartList.length; i++) {
      this.total+= this.cartList[i].price;
    }}

  emptyCart(): void {
    this.cartService.emptyCart();
  }

  home(): void {
    this.router.navigate(['home']);
  }

  buy(): void {
    this.emptyCart();
    this.router.navigate(['thank-you']);
  }
}

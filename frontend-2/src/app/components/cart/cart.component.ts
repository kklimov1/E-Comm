import { Component, OnInit } from '@angular/core';
import { UntypedFormControl, UntypedFormGroup } from '@angular/forms';
import { Product } from 'src/app/models/product';
import { CartService } from 'src/app/services/cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit{
  cartList: Product[] =[];
  checkoutForm = new UntypedFormGroup({
    address: new UntypedFormControl(''),
    zipCode: new UntypedFormControl(''),
    Country: new UntypedFormControl('')
  })
  constructor(private cartService: CartService) {};

  ngOnInit(): void { this.cartList = this.cartService.getCart(); }

  emptyCart(): void {
    this.cartService.emptyCart();
  }
}

import { Component, Input } from '@angular/core';
import { Product } from 'src/app/models/product';
import { CartService } from 'src/app/services/cart.service';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent {
  @Input() productInfo!: Product;

  constructor(private productService: ProductService, private cartService: CartService) { }

  ngOnInit(): void {}

  addToCart(product: Product): void {
    this.cartService.addToCart(product);
    console.log(JSON.stringify( this.cartService.getCart()));
  }
}

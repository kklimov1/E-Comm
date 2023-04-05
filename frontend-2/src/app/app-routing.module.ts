import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { CartComponent } from './components/cart/cart.component';
import { ThankYouComponent } from './components/thank-you/thank-you.component';

const routes: Routes = [
  { path: "login", component: LoginComponent },
  { path: "", redirectTo:"/login", pathMatch: "full"},
  { path: "register", component: RegisterComponent },
  { path: "thank-you", component: ThankYouComponent},
  { path: "home", component: HomePageComponent },
  { path: "cart", component: CartComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { Component , OnInit} from '@angular/core';
import { FormBuilder, UntypedFormGroup, UntypedFormControl } from '@angular/forms';
import { AuthService } from 'src/app/services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
  login = new UntypedFormGroup({
    username: new UntypedFormControl(''),
    password: new UntypedFormControl('')
  })

  constructor(private authService: AuthService, private router: Router) {}

  ngOnInit(): void {
   
  }

  onSubmit(): void {
    this.authService.login(this.login.get('username')?.value, this.login.get('password')?.value).subscribe(
      () => {
        this.authService.loggedIn=true;
      },
      (err) => console.log(err),
      () => this.router.navigate(['home'])
    );
  }

  register(): void {
    this.router.navigate(['register']);
  }
}

import { Component, OnInit } from '@angular/core';
import { UntypedFormControl, UntypedFormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  registerForm = new UntypedFormGroup({
    email: new UntypedFormControl(''),
    fname: new UntypedFormControl(''),
    lname: new UntypedFormControl(''),
    username: new UntypedFormControl(''),
    password: new UntypedFormControl('')
  })

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit(): void {
  }
  
  onSubmit(): void {
    this.authService.register(this.registerForm.get('email')?.value, this.registerForm.get('fname')?.value, this.registerForm.get('lname')?.value, this.registerForm.get('username')?.value, this.registerForm.get('password')?.value).subscribe( () => console.log("Registered user"),
    (err) => alert(err),
    () => this.router.navigate(['login'])
    );
  }
}

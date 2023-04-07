import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
@Injectable({
  providedIn: 'root'
})
export class AuthService {

  authUrl: string = `${environment.baseUrl}`;
  loggedIn: boolean = false;

  constructor(private http: HttpClient) { }

  login(username: string, password: string): Observable<any> {
    const payload = {username:username, password:password};
    console.log(this.authUrl);
    return this.http.post<any>(`${this.authUrl}/login`, payload, {headers: environment.headers, withCredentials: environment.withCredentials});
  }

  logout(): void{
    this.http.post(`${this.authUrl}/logout`, null);
  }

  register(email: string, firstName: string, lastName: string, username: string, password: string): Observable<any> {
    const payload = {email: email, firstName: firstName, lastName: lastName, username: username, password: password};
    return this.http.post<any>(`${this.authUrl}/register`, payload, {headers: environment.headers});
  }

}

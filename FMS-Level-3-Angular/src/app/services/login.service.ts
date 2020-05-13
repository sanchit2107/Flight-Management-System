import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { UserLogin } from '../model/user-login.component';
import { User } from '../model/user.component';
import { Observable, of } from 'rxjs';
import {catchError, tap} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private loginUrl = 'http://localhost:9092/login';  // URL to web api

  httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };

  constructor(private http: HttpClient) {
  }


  /** POST: add a new User to the server */
  userLogin(user: UserLogin): Observable<User> {
    return this.http.post<User>(this.loginUrl, user, this.httpOptions).pipe(
      tap((newUser: User) => {
        if (newUser != null) {
          this.log(`Logged in with User Id: ${newUser.userId}`);
        } else if (newUser == null) {
          this.log(`Login failed, check username and password`);
        }
      }),
      catchError(this.handleError<User>(`addUser`))
    );
  }

  /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

  private log(message: string) {
    alert('Server message:' + message);
  }
}

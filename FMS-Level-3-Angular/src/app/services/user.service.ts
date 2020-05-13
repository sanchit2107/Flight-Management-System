import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable, of} from 'rxjs';
import { User } from '../model/user.component';
import { tap, catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private userUrl = 'http://localhost:9092/user';  // URL to web api

  httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };

  constructor(private http: HttpClient) {
  }

  /** GET Users from the server */
  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(`${this.userUrl}/readAllUsers`)
      .pipe(
        tap(_ => this.log('Fetched Users')),
        catchError(this.handleError<User[]>(`getUsers`, []))
      );
  }

  /** GET User by id. Will 404 if id not found */
  getUser(id: number): Observable<User> {
    const url = `${this.userUrl}/${id}`;
    return this.http.get<User>(url).pipe(
      tap(_ => this.log(`Fetched User Id: ${id}`)),
      catchError(this.handleError<User>(`getUser Id: ${id}`))
    );
  }

  //////// Save methods //////////

  /** POST: add a new User to the server */
  addUser(user: User): Observable<User> {
    return this.http.post<User>(`${this.userUrl}/createUser`, user, this.httpOptions).pipe(
      tap((newUser: User) => this.log(`Made Account with User Id: ${newUser.userId}`)),
      catchError(this.handleError<User>(`addUser`))
    );
  }

  /** DELETE: Delete the user from the server */
  deleteUser(id: number): Observable<User> {
    const url = `${this.userUrl}/${id}`;
    return this.http.delete<User>(url, this.httpOptions).pipe(
      tap(_ => this.log(`Deleted User id: ${id}`)),
      catchError(this.handleError<User>(`deleteUser`))
    );
  }

  /** PUT: update the hero on the server */
  updateUser(user: User): Observable<any> {
    const url = `${this.userUrl}/${user.userId}`;
    return this.http.put(url, user, this.httpOptions).pipe(
      tap((newUser: User) => this.log(`Updated Booking with Id: ${newUser.userId}`)),
      catchError(this.handleError<User>(`updateUser`))
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

import { Injectable } from '@angular/core';
import { User } from '../model/user.component';
import { ScheduledFlight } from '../model/scheduled-flight';

@Injectable({
  providedIn: 'root'
})
export class GlobalService {

  loginStatus: boolean;
  currentUser: User;
  currentScheduledFlight: ScheduledFlight;

  constructor() {
    this.currentUser = new User();
    this.currentScheduledFlight = new ScheduledFlight();
    this.loginStatus = false;
  }

  // Current user----------------------------------------------
  public setCurrentUser(user: User) {
    this.currentUser = user;
  }

  public getCurrentUser(): User {
    return this.currentUser;
  }

  // Current User----------------------------------------------

  // Current User----------------------------------------------
  public setScheduledFlight(scheduledFlight: ScheduledFlight): void {
    this.currentScheduledFlight = scheduledFlight;
  }

  public getScheduledFlight(): ScheduledFlight {
    return this.currentScheduledFlight;
  }

  // Current User----------------------------------------------

  // Login Status----------------------------------------------
  public getLoginStatus(): boolean {
    return this.loginStatus;
  }

  public setLoginStatus(status: boolean) {
    this.loginStatus = status;
  }

  // Login Status----------------------------------------------
}

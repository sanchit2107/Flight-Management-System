import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateUserComponent } from './create-user/create-user.component';
import { UpdateUserComponent } from './update-user/update-user.component';
import { ListUserComponent } from './list-user/list-user.component';
import { UserDetailsComponent } from './user-details/user-details.component';


const routes: Routes = [
  {path: '',redirectTo: 'user',pathMatch:'full'},
  {path: 'add', component: CreateUserComponent},
  {path: 'update/:id', component: UpdateUserComponent},
  {path: 'details/:id', component: UserDetailsComponent},
  {path: 'users', component: ListUserComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

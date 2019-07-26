import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListComponent } from './list/list.component';
import { FormComponent } from './form/form.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
{ path: '', redirectTo: '/login', pathMatch: 'full' },
{ path: 'lists', component: ListComponent },
{ path: 'addentity', component: FormComponent },
{ path: 'login', component: LoginComponent },
{ path: '**', redirectTo: '/login', pathMatch: 'full' }
];

@NgModule({
imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

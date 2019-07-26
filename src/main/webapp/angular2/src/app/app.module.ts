import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { ListComponent } from './list/list.component';
import { FormComponent } from './form/form.component';
import { EmployeeService } from './service/employee-service.service';
import { DepartmentService } from './service/department-service.service';
import { LoginComponent } from './login/login.component';

@NgModule({
declarations: [
AppComponent,
ListComponent,
FormComponent,
LoginComponent
],
imports: [
BrowserModule,
AppRoutingModule,
HttpClientModule,
FormsModule
],
providers: [
EmployeeService,
DepartmentService
],
bootstrap: [AppComponent]
})
export class AppModule { }


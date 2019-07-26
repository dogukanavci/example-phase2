import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../entity/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user : User;
  constructor(private route: ActivatedRoute, private router: Router) {
   this.user = new User();
   }

  ngOnInit() {
    localStorage.setItem("logged", "false");
  }

  onSubmit() {
    let password = this.user.password;
    if(localStorage.getItem(this.user.username)==password && password !=null){
      console.log("login successful");
      localStorage.setItem("logged", "true");
      this.router.navigate(['/lists']);
    }
    else{
      alert("Login failed");
    }

  }

  onRegister(){
    localStorage.setItem(this.user.username, this.user.password);
    alert("Registered succesfully!");
  }
}

import { Component } from '@angular/core';
import { AppComponent } from '../app.component';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

constructor(public app:AppComponent, public http:HttpClient){}


  isLogin:boolean=true


  whatToShow:number=0
  wts:number=0  

  username:String=' ';
  password:String=' ';

  login(){
    console.log("username: "+this.username);
    console.log("password: "+this.password);

    let obj=[
      this.username,
      this.password
    ]
    let url = this.app.baseUrl + 'login/log';

    this.http.post(url,obj).subscribe((data:any)=>{
      console.log(data);
      if(data==null)
        window.alert("something is wrong")
      if(data.id<1)
        window.alert(data.errorMessage)
      else
        this.app.id=data.id
      this.app.whatToShow=data.accountType
    })
    
  }  

  changeWts(num:number)
  {
    this.whatToShow=num;

    this.isLogin = num !== 1;   //false
    
  }
}

import { Component } from '@angular/core';
import { AppComponent } from '../../app.component';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

  constructor(public app: AppComponent,public http:HttpClient){}
  
 // accountType:number='';       //int accountType;    //1.admin 2.seller 3.Buyer
  

  roles: { value: number, name: string }[] = [
    { value: 1, name: 'Admin' },
    { value: 2, name: 'Seller' },
    { value: 3, name: 'Buyer' }
  ];
  
  selectedRole: number = 1; // Default to admin
  name:String=''
  username: string = '';
  password: string = '';

  registerYourself() {
    console.log('Selected Role:', this.selectedRole);
    console.log('name:', this.name);

    console.log('UserName:', this.username);
    console.log('Password:', this.password);
    
    let obj={
      
      "name":this.name,
      "username":this.username,
      "password":this.password,
      "accountType":this.selectedRole
    }

    let url=this.app.baseUrl+'login/register'
    this.http.post(url,obj).subscribe((data:any)=>{
      if(data==1)
        window.alert("registration sucessful")
      else if(data==2)
        window.alert("username exist")
      else if(data==3)
        window.alert("name already register")
      else
      window.alert("something is wrong")
    })

  }

  // backToLogin() {
  //   this.router.navigate(['/']);
  // }
}


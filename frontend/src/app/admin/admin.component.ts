import { Component } from '@angular/core';
import { AppComponent } from '../app.component';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrl: './admin.component.css'
})
export class AdminComponent {
  
  name:String='';
  constructor(public app: AppComponent, public http:HttpClient){

    let url=this.app.baseUrl+'login/getName'+this.app.id;
    this.http.get(url).subscribe((data:any)=>{

      this.name=data
    })
  }

  whatToShow:number=0

  changeWhatToShow(num:number){
    this.whatToShow=num
  }

 

  
}

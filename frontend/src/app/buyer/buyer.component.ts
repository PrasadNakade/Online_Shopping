import { Component } from '@angular/core';
import { AppComponent } from '../app.component';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-buyer',
  templateUrl: './buyer.component.html',
  styleUrl: './buyer.component.css'
})
export class BuyerComponent {

  name:String='';
  whatToShow:number=0;
  constructor(public app:AppComponent,public http:HttpClient){

    let url=this.app.baseUrl+'login/getName'+this.app.id
    this.http.get(url).subscribe((data:any)=>{
      if(data==null)
        window.alert('something is wrong')
      else
      this.name=data

    })

  }

  changeWhatToShow(num:number){
    this.whatToShow=num
  }
  

}

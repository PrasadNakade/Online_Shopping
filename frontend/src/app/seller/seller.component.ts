import { Component } from '@angular/core';
import { AppComponent } from '../app.component';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-seller',
  templateUrl: './seller.component.html',
  styleUrl: './seller.component.css'
})
export class SellerComponent {

  name:String='';
  whatToShow:number=0
  constructor(public app:AppComponent,public http:HttpClient){

    let url=this.app.baseUrl+'login/getName'+this.app.id
    this.http.get(url).subscribe((data:any)=>{
      this.name=data
    })

  }


  changeWhatToShow(num:number){
    this.whatToShow=num
  }


  

}

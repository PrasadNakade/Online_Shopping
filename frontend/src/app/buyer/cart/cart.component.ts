import { Component } from '@angular/core';
import { AppComponent } from '../../app.component';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrl: './cart.component.css'
})
export class CartComponent {

  list:any[]=[];
  userquantity:number=0;
  constructor(public app:AppComponent, public http: HttpClient){
  
    let url=this.app.baseUrl+'buyer/getAllCartInfo'+this.app.id
    this.http.get(url).subscribe((data:any)=>{
      this.list=data
      
  
    })
  }

  deleteCat(l:any){
    let url=this.app.baseUrl+'buyer/deleteCategory'+l.id
    this.http.get(url).subscribe((data:any)=>{
      if(data==0){
        window.alert("something is wrong")
      }else
      {
        
        this.list.splice(this.list.indexOf(l),1)
      } 
  })
  }

  validateQunatity(l:any)   //10 < 20
  {
    if(l.userquantity > l.quantity){
    window.alert("Only " +l.quantity+ " Quantity Available")
  
  }
}
cartItems: any[] = [];

  placeOrder()
  {
    console.log("enter placeorder")
    const orderItems = this.list.map(item => [item.id, item.userquantity]);
     for(let i=0;i<this.cartItems.length;i++)
     {
      let myArray:any[]=new Array(2);
      console.log(this.list[i].id);
      console.log(this.cartItems[i].id);
      myArray[0]=this.cartItems[i].id;
      myArray[1]=this.cartItems[i].userquantity;

      this.list.push(myArray);
      console.log(this.list);

     }
     let url=this.app.baseUrl+"buyer/placeOrder"+this.app.id;
    this.http.post(url,orderItems).subscribe((data:any)=>{

      if(data==0)
      {
        window.alert("something wrong")
      }
      else
      {
      
        window.alert('done')
        this.cartItems=[];
      }
    })

  }
 
}
import { Component } from '@angular/core';
import { AppComponent } from '../../app.component';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrl: './product.component.css'
})
export class ProductComponent {


  list2:any[]=[];
  list:any[]=[];
  list3:any[]=[];
  constructor(public app:AppComponent,public http: HttpClient){

    let url2=this.app.baseUrl+'seller/getAllProducts'+this.app.id
    this.http.get(url2).subscribe((data:any)=>{
      this.list3=data
      console.log("List3 data ::"+this.list3)
    })


    let url=this.app.baseUrl+'admin/getAllDataFromCategoryTable'  
    this.http.get(url).subscribe((data:any)=>{
      this.list2=data;
      console.log("List2 data :: "+this.list2)
    })


  }

  name:String=''
  price:number=0
  quantity:number=0
  discount:number=0
  description:String=''
  catid:number=0


addNewProduct(){
  console.log("add new product")

  let obj=
  {
    "name": this.name,
    "userid": this.app.id,
    "price": this.price,
    "quantity": this.quantity,
    "discount": this.discount,
    "description": this.description,
    "categoryid":this.catid
  }
  let url=this.app.baseUrl+'seller/addNewProducts'+this.app.id
  this.http.post(url,obj).subscribe((data:any)=>{
    console.log(data)
    if(data==null)
      window.alert('something is worng')
    else{
      // this.list.push(data)
      this.list3.push(data);
      this.name = '';
      this.price = 0;
      this.quantity = 0;
      this.discount = 0;
      this.description = '';
      this.catid = 0;
    }
  })
}
}

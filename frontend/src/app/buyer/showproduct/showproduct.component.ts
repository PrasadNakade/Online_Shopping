
import { Component } from '@angular/core';
import { AppComponent } from '../../app.component';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-showproduct',
  templateUrl: './showproduct.component.html',
  styleUrls: ['./showproduct.component.css']
})
export class ShowproductComponent {

  cats: any;
  prods: any;
  catid: number = 0;
  minprice: number = 0;
  maxprice: number = 50000;
  minrating: number = 0;

  constructor(public app: AppComponent, public http: HttpClient) {
    let url = this.app.baseUrl + 'admin/getAllDataFromCategoryTable';
    this.http.get(url).subscribe((data: any) => {
      if (data == null) {
        window.alert('Something is wrong');
      } else {
        this.cats = data;
      }
    });
  }

  loadFilterData() {
    let a: number[] = [this.catid, this.minprice, this.maxprice, this.minrating];
    console.log("Array to send backend :: " + a);
    let url = this.app.baseUrl + 'buyer/allFilterProductDataSendToUi';
    
    this.http.post(url, a).subscribe((data: any) => {
      console.log("backend response :: ", data);
      if (data == null) {
        window.alert('Something is wrong');
      } else if (data.length == 0) {
        window.alert('No product available');
      } else {
        this.prods = data;
      }
    });
  }


  
  addRating(p:any) {
    
    let url = this.app.baseUrl + 'buyer/getRating' + p.id + 'and' + this.app.id +'and' + p.rating ;
    this.http.get(url).subscribe((data: any) => {
      
      if (data == null || data==0) {
        window.alert('Something is wrong');
      
      }
    });
  }
  addToCart(p:any){
    console.log(p.id)
    console.log(this.app.id)
    let url = this.app.baseUrl + 'buyer/addToCart' + p.id + 'and'+ this.app.id; 
    this.http.get(url).subscribe((data: any) => {
      if (data == null) {
        window.alert('Something is wrong');
        }
        else if(data>1){
          window.alert('Product already added to cart')
          }
          else if(data==-1){
            window.alert('Product added to cart sucessfully')
            }else
            {
              window.alert('something is wrong')
            }

  })
}
}

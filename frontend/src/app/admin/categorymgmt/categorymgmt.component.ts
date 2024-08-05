import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { AppComponent } from '../../app.component';

@Component({
  selector: 'app-categorymgmt',
  templateUrl: './categorymgmt.component.html',
  styleUrl: './categorymgmt.component.css'
})
export class CategorymgmtComponent {

  list: any[]=[];

  
  categoryName:String=''
    
  constructor(public http:HttpClient, public app:AppComponent){

    // let url=this.app.baseUrl+'admin/getAllCategories'+this.app.id
    // this.http.get(url).subscribe((data:any)=>{
    //   console.log("backend response::" +data)
    //     this.list=data;
    // })
    let url=this.app.baseUrl+'admin/getAllDataFromCategoryTable'
    this.http.get(url).subscribe((data:any)=>{
      console.log("backend response::" +data)
        this.list=data;
    })

  }

  name:string='';
  
  addCategory(){

   console.log(this.name);
   let url=this.app.baseUrl+'admin/addNewCategory'+this.app.id
    this.http.post(url,this.name).subscribe((data:any)=>{

      // for(let i=0;i<data;i++){
      //   this.list.push(data[i]);

      // }


      console.log(data)
      if(data==null)
        window.alert("something is wrong")
      else{
       this.list.push(data);   
       
      }     
      })
  }

  catid: number=0;
  // deleteById(info:any){

  //   this.catid=info.id;
  //   console.log(this.catid)
  //   let url=this.app.baseUrl+'admin/deleteCategoryData'+this.catid
  //   // let url = `${this.app.baseUrl}admin/deleteCategoryData/${this.catid}`;
  //   this.http.delete(url).subscribe((data:any)=>{
  //     this.list = this.list.filter(item => item.id !== this.catid);
  //   })
  // }

  deleteById(info:any){
    this.catid=info.id;
    let url=this.app.baseUrl+'admin/deleteCategoryData'+this.catid
    this.http.get(url).subscribe((data:any)=>{
      if(data==0){
        window.alert("something is wrong")
      }else
      {
        
        this.list.splice(this.list.indexOf(this.catid),1)
      } 
  })
  }
}
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'amazonclone';

  whatToShow:number=0;
  id:number=0;

  baseUrl="http://15.207.221.225:8080/OnlineShop/";

}

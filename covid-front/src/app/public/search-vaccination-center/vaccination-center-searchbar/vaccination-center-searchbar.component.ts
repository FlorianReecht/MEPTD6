import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-vaccination-center-searchbar',
  templateUrl: './vaccination-center-searchbar.component.html',
  styleUrls: ['./vaccination-center-searchbar.component.css']
})
export class VaccinationCenterSearchbarComponent implements OnInit {
  inputString:string;


  constructor() { 
    this.inputString="";
  }

  ngOnInit(): void {
  }

  /**
   * Fonction de recherche d'un centre en cas de clique sur le bouton de recherche
   */
  search()
  {
    //todo
  }

}

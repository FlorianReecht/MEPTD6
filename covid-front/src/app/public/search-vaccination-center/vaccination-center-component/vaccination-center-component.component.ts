import { Component, Input, OnInit } from '@angular/core';
import { VaccinationCenter } from 'src/app/VaccinationCenter';

@Component({
  selector: 'app-vaccination-center-component',
  templateUrl: './vaccination-center-component.component.html',
  styleUrls: ['./vaccination-center-component.component.css']
})
export class VaccinationCenterComponentComponent implements OnInit {
  @Input()
  center?:VaccinationCenter

  constructor() { 
    
  }

  ngOnInit(): void {
  }

}

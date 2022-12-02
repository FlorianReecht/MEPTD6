import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { VaccinationCenter } from 'src/app/VaccinationCenter';
import { VaccinationCenterServiceService } from '../../Services/vaccination-center-service.service';

@Component({
  selector: 'app-vaccination-center-list-component',
  templateUrl: './vaccination-center-list-component.component.html',
  styleUrls: ['./vaccination-center-list-component.component.css']
})
export class VaccinationCenterListComponentComponent implements OnInit {
  VaccinationCenterList: VaccinationCenter[]=[];

  constructor(private service : VaccinationCenterServiceService){ 

  

}  
ngOnInit(): void {
  this.service.getAllVaccinationCenter().subscribe(resultCenters=>{
    this.VaccinationCenterList = resultCenters;
  })
  }
}


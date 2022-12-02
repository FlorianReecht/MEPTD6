import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { VaccinationCenter } from 'src/app/VaccinationCenter';

@Injectable({
  providedIn: 'root'
})
export class VaccinationCenterServiceService {


  constructor(private httpClient:HttpClient) { }

  getAllVaccinationCenter() : Observable<VaccinationCenter[]>{
  
    return this.httpClient.get<VaccinationCenter[]>("api/public/centers");
  }
}

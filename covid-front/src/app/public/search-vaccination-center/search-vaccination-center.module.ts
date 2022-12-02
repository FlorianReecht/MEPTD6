import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SearchVaccinationCenterPageComponent } from './search-vaccination-center-page/search-vaccination-center-page.component';
import { FormsModule } from '@angular/forms';
import { VaccinationCenterSearchbarComponent } from './vaccination-center-searchbar/vaccination-center-searchbar.component';
import { VaccinationCenterListComponentComponent } from './vaccination-center-list-component/vaccination-center-list-component.component';
import { VaccinationCenterComponentComponent } from './vaccination-center-component/vaccination-center-component.component';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http'


@NgModule({
  declarations: [
    SearchVaccinationCenterPageComponent,
    VaccinationCenterSearchbarComponent,
    VaccinationCenterListComponentComponent,
    VaccinationCenterComponentComponent,
  ],
  imports: [
    CommonModule,
    FormsModule,
    BrowserModule,
    HttpClientModule
  ]
})
export class SearchVaccinationCenterModule { }

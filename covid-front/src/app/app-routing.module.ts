import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SearchVaccinationCenterPageComponent } from './public/search-vaccination-center/search-vaccination-center-page/search-vaccination-center-page.component';
import { SearchVaccinationCenterModule } from './public/search-vaccination-center/search-vaccination-center.module';

const routes: Routes = [
  { path: "centers", component: SearchVaccinationCenterPageComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { GoogleMapsModule } from '@angular/google-maps';
import { MapsPageComponent } from './maps-page/maps-page.component';
import { AddLocationComponent } from './add-location/add-location.component';


@NgModule({
  declarations: [
    AppComponent,
    MapsPageComponent,
    AddLocationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    GoogleMapsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

import { Component } from '@angular/core';
import { Observable } from 'rxjs';
//import { LocationService } from '../location-service';
import { Router } from '@angular/router';
import {Location} from '../location';

@Component({
  selector: 'app-maps-page',
  templateUrl: './maps-page.component.html',
  styleUrls: ['./maps-page.component.css']
})
export class MapsPageComponent {

  center!: google.maps.LatLngLiteral;

  locations!: Observable<Location[]>;

  /*constructor(private locationService: LocationService,
    private router: Router)
  {}
  


  ngOnInit()
  {
    this.reloadData();
  }
  reloadData()
  {
    //this.locations = this.locationService.getLocationsList();
  }*/

}

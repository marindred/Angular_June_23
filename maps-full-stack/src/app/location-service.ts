import { Injectable } from '@angular/core';
import { Observable} from 'rxjs';
import { HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LocationService {

  private baseUrl = 'localhost:8081/api/locations';


  constructor(private http: HttpClient) { }
  getLocation(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }
  createLocation(location: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, location);
  }
  updateLocation(id: number, value: any): Observable<Object> 
  {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteLocation(id: number): Observable<any>
  {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }
  getLocationsList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}


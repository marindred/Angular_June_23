package com.example.demo.service;
import com.example.demo.entity.Location;
import com.example.demo.repo.LocationRepo;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
@Service
public class LocationService {
   private final LocationRepo locationRepo;
   private final String googleMapsApiKey;
   public LocationService(LocationRepo locationRepo,
                          @Value("${google.maps.apikey}") String googleMapsApiKey) {
       this.locationRepo = locationRepo;
       this.googleMapsApiKey = googleMapsApiKey;
   }
   
   public Location geocodeAddress(@RequestBody String address) {
       try {
           // Initialize the GeoApiContext
           GeoApiContext context = new GeoApiContext.Builder()
                   .apiKey(googleMapsApiKey)
                   .build();
           // Geocode the provided address
           GeocodingResult[] results = GeocodingApi.geocode(context, address).await();
           if (results.length > 0) {
               // Retrieve the latitude and longitude of the first result
               double latitude = results[0].geometry.location.lat;
               double longitude = results[0].geometry.location.lng;
               // Create a new Location instance
               Location location = new Location(address, latitude, longitude, 0L);
               // Save the location in the database
               return locationRepo.save(location);
           } else {
               return null;
           }
       } catch (Exception e) {e.printStackTrace();}
       
       return null;
   }
   public Location createLocation(Location location)
   {
	   return locationRepo.save(location);
   }
   public List<Location> getAllLocations()
   {
	   return locationRepo.findAll();
   }
}
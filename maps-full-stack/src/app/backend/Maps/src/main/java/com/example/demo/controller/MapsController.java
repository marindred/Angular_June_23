package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Location;
import com.example.demo.service.LocationService;
@RestController
@RequestMapping("/api/locations")
public class MapsController {
    private final LocationService locationService;
    public MapsController(LocationService locationService) {
        this.locationService = locationService;
    }
    @PostMapping
    public ResponseEntity<Location> createLocation(@RequestBody Location location) {
    	
    	location = locationService.createLocation(location);
    	return ResponseEntity.ok(location);
    }
    @GetMapping
	public ResponseEntity<List<Location>> getAllEmployees()
	{
		return ResponseEntity.ok(locationService.getAllLocations());
	}
}

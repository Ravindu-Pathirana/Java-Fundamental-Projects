package edu.icet.demo.controller;

import edu.icet.demo.service.CityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {

    @GetMapping("/get-city/{postalCode}")
    public String getCity(@PathVariable String postalCode){
        System.out.println("Request Received");
        CityService service = new CityService();
        return service.getCityByPostalCode(postalCode);
    }
}
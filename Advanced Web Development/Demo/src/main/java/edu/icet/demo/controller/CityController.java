package edu.icet.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {

    @GetMapping("/get-city/{postalCode}")
    public void getCity(@PathVariable String postalCode){
        System.out.println("Request Received");
        System.out.println(postalCode);
    }
}

package edu.icet.crm.customer.controller;

import edu.icet.crm.customer.service.CityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController

public class CityController {

    @GetMapping("/city-by-name/{postalCode}")
    public Map<String, String> getCityNameByPostalCode(@PathVariable String postalCode){
        System.out.println(postalCode);
        CityService service = new CityService();
        return service.getCityByName(postalCode);
    }

}

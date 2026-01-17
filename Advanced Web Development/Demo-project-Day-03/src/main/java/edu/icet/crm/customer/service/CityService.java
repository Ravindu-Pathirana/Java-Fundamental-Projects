package edu.icet.crm.customer.service;

import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CityService {

    public Map<String,String> getCityByName(String postalcode){
        HashMap<String,String> cities = new HashMap<>();
        cities.put("10400","Moratuwa");
        cities.put("10500","Mount - Lavinia");
        cities.put("10800","Colpetty");

        String city = cities.get(postalcode);

        if (StringUtils.hasText(city)){
            return Collections.singletonMap("data",city) ;
        }

        return Collections.singletonMap("data","No city listed.");
    }

}

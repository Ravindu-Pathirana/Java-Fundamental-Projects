package edu.icet.demo.service;

import java.util.HashMap;

public class CityService {
    public String getCityByPostalCode(String postalCode){
        HashMap<String,String> cityList  = new HashMap<>();
        cityList.put("10400","Moratuwa");
        cityList.put("80300","Ambalangoda");
        cityList.put("20000","Angoda");

        return cityList.get(postalCode);

    }
}

package edu.icet.crm.customer.service;

import java.util.Map;

public interface CityService {
    public Map<String,String> getCityByName(String postalcode);
}

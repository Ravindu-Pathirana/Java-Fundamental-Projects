package edu.icet.demo.service.impl;

import edu.icet.demo.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;

@Service
@Slf4j
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ProductServiceImpl implements ProductService {

    ProductServiceImpl(){
        log.info("ProductServiceImpl object Loaded.");
    }

    public Map<String, String> getStudents(){
        return Collections.singletonMap("name","Ravindu");
    }
}

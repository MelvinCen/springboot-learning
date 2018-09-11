package cn.melvin.controller;

import cn.melvin.properties.MyProperties1;
import cn.melvin.properties.MyProperties2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/properties")
public class PropertiesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesController.class);

    private MyProperties1 myProperties1;
    private MyProperties2 myProperties2;

    @Autowired
    public PropertiesController(MyProperties1 myProperties,MyProperties2 myProperties2) {
        this.myProperties1 = myProperties;
        this.myProperties2 = myProperties2;
    }

    @GetMapping("/1")
    public MyProperties1 myProperties1() {
        LOGGER.info("=============================================================================");
        LOGGER.info(myProperties1.toString());
        LOGGER.info("=============================================================================");
        return myProperties1;
    }

    @GetMapping("/2")
    public MyProperties2 myProperties2() {
        LOGGER.info("=============================================================================");
        LOGGER.info(myProperties2.toString());
        LOGGER.info("=============================================================================");
        return myProperties2;
    }
}

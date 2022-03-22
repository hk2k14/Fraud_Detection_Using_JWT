package com.mycompany.app.customer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {

    @RequestMapping({ "/hi" })
    public String hello() {
        return "HI World";
    }
}

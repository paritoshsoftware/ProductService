package com.ecom.productservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//This controller support HTTP request
//This requests coming to endpoint /hello, transfer them to this controller
@RestController
@RequestMapping("/hello")
public class SampleController {

    @GetMapping("/sayHello/{name}/{clientId}")
    public String getHello(@PathVariable("name") String name, @PathVariable("clientId") String clientId)
    {
        return "Hello World" + " " + name + " Id 123 " + clientId;
    }


}

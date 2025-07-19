package com.devsenio.nmanja.demosb;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    
    @GetMapping("/saludo")
    public String sayHello() {
        return "Hello World";
    }

    //saludo/Nico

    @GetMapping("/saludo/{name}")

    public Map<String, String> getHelloPerson(@PathVariable(name = "name") String name) {

        return Map.of("message", "Hello " + name);

    }

    @GetMapping("/suma/{a}/{b}")

    public Map<String, Integer> sumar(@PathVariable(name="a") Integer a, @PathVariable(name = "b") Integer b){

        return Map.of("Resultado", a+b);
    }
}

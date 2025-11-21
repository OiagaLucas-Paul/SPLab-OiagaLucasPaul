package Laboratoare.controllers;

import Laboratoare.difexamples.ClientComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final ClientComponent clientComponent1;
    private final ClientComponent clientComponent2;

    @Autowired
    public HelloController(ClientComponent clientComponent) {
        this.clientComponent1 = clientComponent;
        this.clientComponent2 = clientComponent;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello from ClientComponent1 = " + clientComponent1
                + "\nHello from ClientComponent2 = " + clientComponent2;
    }
}

package fr.epsi.springHalloween.springHalloween.controller;

import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/api")
public class MainController {

        @GetMapping(path = "/test")
        public String order() {
            return ("Hello World");
        }

}
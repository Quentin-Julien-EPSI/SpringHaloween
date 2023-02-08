package fr.epsi.springHalloween.springHalloween.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class MainController {

        @GetMapping(path = "/test")
        public String order() {
            return ("Hello World");
        }

}
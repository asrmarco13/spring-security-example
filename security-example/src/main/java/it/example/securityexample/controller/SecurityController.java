package it.example.securityexample.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * *Author: Marco Orfei
 * *The Class SecurityController
 */
@RestController
@RequestMapping("/security")
public class SecurityController {

    @GetMapping("/welcome")
    public ResponseEntity<String> welcome() {
        return new ResponseEntity<String>("Welcome", HttpStatus.OK);
    }

}

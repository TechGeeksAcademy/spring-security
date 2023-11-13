package com.delighthomes.ams.security.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/superadmin")
public class SuperAdminController {
    @GetMapping("/all")
    public ResponseEntity<String> all(){
        return new ResponseEntity<>("Only Super Admins Can Access Me", HttpStatus.OK);
    }
}

package com.cng457.Project.controller;

import com.cng457.Project.entity.Phone;
import com.cng457.Project.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PhoneController {
    @Autowired
    PhoneService phoneService;

    @PostMapping("/addphone")
    public Phone savePhone(@RequestBody Phone p){
        return phoneService.savePhone(p);
    }

    @GetMapping("/getphone/{id}")
    public Phone getPhone(@PathVariable Integer id){
        return phoneService.getPhone(id);
    }
}

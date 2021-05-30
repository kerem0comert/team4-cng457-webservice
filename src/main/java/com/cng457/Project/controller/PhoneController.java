package com.cng457.Project.controller;

import com.cng457.Project.entity.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PhoneController {
    @Autowired
    PhoneController phoneController;

    @PostMapping("/addphone")
    public Phone savePhone(@RequestBody Phone p){
        return phoneController.savePhone(p);
    }

    @GetMapping("/getphone/{id}")
    public Phone getPhone(@PathVariable Integer id){
        return phoneController.getPhone(id);
    }
}

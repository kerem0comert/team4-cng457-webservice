package com.cng457.Project.controller;

import com.cng457.Project.entity.Brand;
import com.cng457.Project.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BrandController {
    @Autowired
    BrandService brandService;

    @PostMapping("/addBrand")
    public Brand saveBrand(@RequestBody Brand b){
        return brandService.saveBrand(b);
    }

    @GetMapping("/getbrand/{id}")
    public Brand getBrand(@PathVariable int id){
        return brandService.getBrand(id);
    }
}

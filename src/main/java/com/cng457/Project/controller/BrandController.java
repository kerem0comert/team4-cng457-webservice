package com.cng457.Project.controller;

import com.cng457.Project.entity.Brand;
import com.cng457.Project.entity.Computer;
import com.cng457.Project.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BrandController {
    @Autowired
    BrandService brandService;

    @PostMapping("/addBrand")
    public Brand saveBrand(@RequestBody Brand b) {
        return brandService.saveBrand(b);
    }

    @GetMapping("/getBrand/{id}")
    public Brand getBrand(@PathVariable int id) {
        return brandService.getBrand(id);
    }

    @GetMapping("/getAllBrands")
    public List<Brand> getAllBrands() {
        return brandService.getAllBrands();
    }
}

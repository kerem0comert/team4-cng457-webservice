package com.cng457.Project.service;

import com.cng457.Project.entity.Brand;
import com.cng457.Project.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService {
    @Autowired
    BrandRepository brandRepository;

    public Brand saveBrand(Brand b){
        return brandRepository.save(b);
    }

    public Brand getBrand(int id){
        return brandRepository.findById(id).orElse(null);
    }
}

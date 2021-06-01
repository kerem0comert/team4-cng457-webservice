package com.cng457.Project.service;

import com.cng457.Project.entity.Phone;
import com.cng457.Project.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneService {
    @Autowired
    PhoneRepository phoneRepository;

    public Phone savePhone(Phone p){
        return phoneRepository.save(p);
    }

    public Phone getPhone(int id){
        return phoneRepository.findById(id).orElse(null);
    }

    public List<Phone> getAllPhones(){
        return phoneRepository.getAllPhones();
    }
}

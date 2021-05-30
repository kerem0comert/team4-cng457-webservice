package com.cng457.Project.service;

import com.cng457.Project.entity.Computer;
import com.cng457.Project.repository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComputerService {
    @Autowired
    ComputerRepository computerRepository;

    public Computer saveComputer(Computer c){
        return computerRepository.save(c);
    }

    public Computer getComputer(int id){
        return computerRepository.findById(id).orElse(null);
    }
}

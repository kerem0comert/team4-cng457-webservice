package com.cng457.Project.controller;

import com.cng457.Project.entity.Computer;
import com.cng457.Project.entity.Phone;
import com.cng457.Project.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ComputerController {
    @Autowired
    ComputerService computerService;

    @PostMapping("/addcomputer")
    public Computer saveComputer(@RequestBody Computer c){
        return computerService.saveComputer(c);
    }

    @GetMapping("/getcomputer/{id}")
    public Computer getComputer(@PathVariable Integer id){
        return computerService.getComputer(id);
    }

    @GetMapping("/getallcomputers")
    public List<Computer> getAllComputers() {
        return computerService.getAllComputers();
    }

    @GetMapping("/getcomputerwithid/{id}")
    public List<Computer> getComputerWithId(@PathVariable int id) {
        return computerService.getComputerWithId(id);
    }

}

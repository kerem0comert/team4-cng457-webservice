package com.cng457.Project.controller;

import com.cng457.Project.entity.Computer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ComputerController {
    @Autowired
    ComputerController computerController;

    @PostMapping("/addcomputer")
    public Computer saveComputer(@RequestBody Computer c){
        return computerController.saveComputer(c);
    }

    @GetMapping("/getcomputer/{id}")
    public Computer getComputer(@PathVariable Integer id){
        return computerController.getComputer(id);
    }
}

package com.cng457.Project.controller;

import com.cng457.Project.entity.Computer;
import com.cng457.Project.entity.Phone;
import com.cng457.Project.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ComputerController {
    @Autowired
    ComputerService computerService;

    @PostMapping("/addcomputer")
    public Computer saveComputer(@RequestBody Computer c) {
        return computerService.saveComputer(c);
    }

    @GetMapping("/getcomputer/{id}")
    public Computer getComputer(@PathVariable Integer id) {
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

    @GetMapping("/getcomputer")
    public List<Computer> getComputerByPredicate(@RequestParam(required = false) String model,
                                                 @RequestParam(required = false) String batteryLife,
                                                 @RequestParam(required = false) String screenSize,
                                                 @RequestParam(required = false) String screenResolution,
                                                 @RequestParam(required = false) String processor,
                                                 @RequestParam(required = false) Integer memory,
                                                 @RequestParam(required = false) Integer storageCapacity,
                                                 @RequestParam(required = false) String extraFeatures,
                                                 @RequestParam(required = false) String brand) {
        List<Computer> computers = computerService.getAllComputers();
        if (model != null) {
            computers = computers.stream()
                    .filter(x -> x.getModel().equals(model))
                    .collect(Collectors.toList());
        }
        if (batteryLife != null) {
            computers = computers.stream()
                    .filter(x -> x.getBatteryLife().equals(batteryLife))
                    .collect(Collectors.toList());
        }
        if (screenSize != null) {
            computers = computers.stream()
                    .filter(x -> x.getScreenSize().equals(screenSize))
                    .collect(Collectors.toList());
        }
        if (screenResolution != null) {
            computers = computers.stream()
                    .filter(x -> x.getScreenResolution().equals(screenResolution))
                    .collect(Collectors.toList());
        }
        if (processor != null) {
            computers = computers.stream()
                    .filter(x -> x.getProcessor().equals(processor))
                    .collect(Collectors.toList());
        }
        if (memory != null) {
            computers = computers.stream()
                    .filter(x ->  memory.equals(x.getStorageCapacity()))
                    .collect(Collectors.toList());
        }
        if (storageCapacity != null) {
            computers = computers.stream()
                    .filter(x -> storageCapacity.equals(x.getStorageCapacity()))
                    .collect(Collectors.toList());
        }
        if (extraFeatures != null) {
            String[] extraFeaturesList = extraFeatures.split(",");

            for (String theExtraFeature: extraFeaturesList) {
                computers = computers.stream()
                        .filter(x -> x.getExtraFeaturesList().stream().anyMatch(t -> t.getFeatureName().equals(theExtraFeature)))
                        .collect(Collectors.toList());
            }
        }
        if (brand != null) {
            computers = computers.stream()
                    .filter(x -> x.getBrand().getBrandName().equals(brand))
                    .collect(Collectors.toList());
        }
        return computers;
    }
}

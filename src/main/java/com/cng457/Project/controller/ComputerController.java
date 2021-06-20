package com.cng457.Project.controller;

import com.cng457.Project.entity.Computer;
import com.cng457.Project.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ComputerController {
    @Autowired
    ComputerService computerService;

    @PostMapping("/addComputer")
    public Computer saveComputer(@RequestBody Computer c) {
        return computerService.saveComputer(c);
    }

    @GetMapping("/getComputer/{id}")
    public Computer getComputer(@PathVariable Integer id) {
        return computerService.getComputer(id);
    }

    @GetMapping("/getAllComputers")
    public List<Computer> getAllComputers() {
        return computerService.getAllComputers();
    }

    @GetMapping("/getAllScreenSizesForComputers")
    public List<String> getAllScreenSizesForComputers() {
        return computerService.getAllScreenSizesForComputers();
    }

    @GetMapping("/getAllScreenResolutionsForComputers")
    public List<String> getAllScreenResolutionsForComputers() {
        return computerService.getAllScreenResolutionsForComputers();
    }

    @GetMapping("/getAllProcessorsForComputers")
    public List<String> getAllProcessorsForComputers() {
        return computerService.getAllProcessorsForComputers();
    }

    @GetMapping("/getComputer")
    public List<Computer> getComputerByPredicate(@RequestParam(required = false) String model,
                                                 @RequestParam(required = false) Integer minPrice,
                                                 @RequestParam(required = false) Integer maxPrice,
                                                 @RequestParam(required = false) Integer minBatteryLife,
                                                 @RequestParam(required = false) Integer maxBatteryLife,
                                                 @RequestParam(required = false) String screenSize,
                                                 @RequestParam(required = false) String screenResolution,
                                                 @RequestParam(required = false) String processor,
                                                 @RequestParam(required = false) Integer minMemory,
                                                 @RequestParam(required = false) Integer maxMemory,
                                                 @RequestParam(required = false) Integer minStorageCapacity,
                                                 @RequestParam(required = false) Integer maxStorageCapacity,
                                                 @RequestParam(required = false) String extraFeatures,
                                                 @RequestParam(required = false) String brand) {
        List<Computer> computers = computerService.getAllComputers();
        if (model != null) {
            computers = computers.stream()
                    .filter(x -> x.getModel().equals(model))
                    .collect(Collectors.toList());
        }
        if (minPrice != null) {
            computers = computers.stream()
                    .filter(x -> minPrice.intValue() <= x.getPrice())
                    .collect(Collectors.toList());
        }
        if (maxPrice != null) {
            computers = computers.stream()
                    .filter(x -> maxPrice.intValue() >= x.getPrice())
                    .collect(Collectors.toList());
        }
        if (minBatteryLife != null) {
            computers = computers.stream()
                    .filter(x -> minBatteryLife.intValue() <= x.getBatteryLife())
                    .collect(Collectors.toList());
        }
        if (maxBatteryLife != null) {
            computers = computers.stream()
                    .filter(x -> maxBatteryLife.intValue() >= x.getBatteryLife())
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
        if (minMemory != null) {
            computers = computers.stream()
                    .filter(x -> minMemory.intValue() <= x.getMemory())
                    .collect(Collectors.toList());
        }
        if (maxMemory != null) {
            computers = computers.stream()
                    .filter(x -> maxMemory.intValue() >= x.getMemory())
                    .collect(Collectors.toList());
        }
        if (minStorageCapacity != null) {
            computers = computers.stream()
                    .filter(x -> minStorageCapacity.intValue() <= x.getStorageCapacity())
                    .collect(Collectors.toList());
        }
        if (maxStorageCapacity != null) {
            computers = computers.stream()
                    .filter(x -> maxStorageCapacity.intValue() >= x.getStorageCapacity())
                    .collect(Collectors.toList());
        }
        if (extraFeatures != null) {
            String[] extraFeaturesList = extraFeatures.split(",");

            for (String theExtraFeature : extraFeaturesList) {
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

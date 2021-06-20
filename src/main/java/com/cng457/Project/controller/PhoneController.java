package com.cng457.Project.controller;

import com.cng457.Project.entity.Phone;
import com.cng457.Project.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PhoneController {
    @Autowired
    PhoneService phoneService;

    @PostMapping("/addPhone")
    public Phone savePhone(@RequestBody Phone p) {
        return phoneService.savePhone(p);
    }

    @GetMapping("/getPhone/{id}")
    public Phone getPhone(@PathVariable Integer id) {
        return phoneService.getPhone(id);
    }

    @GetMapping("/getAllPhones")
    public List<Phone> getAllPhones() {
        return phoneService.getAllPhones();
    }

    @GetMapping("/getPhoneWithId/{id}")
    public List<Phone> getPhoneWithId(@PathVariable int id) {
        return phoneService.getPhoneWithId(id);
    }

    @GetMapping("/getPhoneWithBrandName/{brandName}")
    public List<Phone> getPhoneWithBrandName(@PathVariable String brandName) {
        return phoneService.getPhoneWithBrandName(brandName);
    }

    @GetMapping("/getAllScreenSizesForPhones")
    public List<String> getAllScreenSizesForPhones() {
        return phoneService.getAllScreenSizesForPhones();
    }

    @GetMapping("/getPhone")
    public List<Phone> getPhoneByPredicate(@RequestParam(required = false) String model,
                                           @RequestParam(required = false) Integer minPrice,
                                           @RequestParam(required = false) Integer maxPrice,
                                           @RequestParam(required = false) Integer minBatteryLife,
                                           @RequestParam(required = false) Integer maxBatteryLife,
                                           @RequestParam(required = false) String screenSize,
                                           @RequestParam(required = false) Integer minInternalMemory,
                                           @RequestParam(required = false) Integer maxInternalMemory,
                                           @RequestParam(required = false) String extraFeatures,
                                           @RequestParam(required = false) String brand) {
        List<Phone> phones = phoneService.getAllPhones();
        if (model != null) {
            phones = phones.stream()
                    .filter(x -> x.getModel().equals(model))
                    .collect(Collectors.toList());
        }
        if (minPrice != null) {
            phones = phones.stream()
                    .filter(x -> minPrice.intValue() <= x.getPrice())
                    .collect(Collectors.toList());
        }
        if (maxPrice != null) {
            phones = phones.stream()
                    .filter(x -> maxPrice.intValue() >= x.getPrice())
                    .collect(Collectors.toList());
        }
        if (minBatteryLife != null) {
            phones = phones.stream()
                    .filter(x -> minBatteryLife.intValue() <= x.getBatteryLife())
                    .collect(Collectors.toList());
        }
        if (maxBatteryLife != null) {
            phones = phones.stream()
                    .filter(x -> maxBatteryLife.intValue() >= x.getBatteryLife())
                    .collect(Collectors.toList());
        }
        if (screenSize != null) {
            phones = phones.stream()
                    .filter(x -> x.getScreenSize().equals(screenSize))
                    .collect(Collectors.toList());
        }
        if (minInternalMemory != null) {
            phones = phones.stream()
                    .filter(x -> minInternalMemory.intValue() <= x.getInternalMemory())
                    .collect(Collectors.toList());
        }
        if (maxInternalMemory != null) {
            phones = phones.stream()
                    .filter(x -> maxInternalMemory.intValue() >= x.getInternalMemory())
                    .collect(Collectors.toList());
        }
        if (extraFeatures != null) {
            String[] extraFeaturesList = extraFeatures.split(",");

            for (String theExtraFeature : extraFeaturesList) {
                phones = phones.stream()
                        .filter(x -> x.getExtraFeaturesList().stream().anyMatch(t -> t.getFeatureName().equals(theExtraFeature)))
                        .collect(Collectors.toList());
            }
        }
        if (brand != null) {
            phones = phones.stream()
                    .filter(x -> x.getBrand().getBrandName().equals(brand))
                    .collect(Collectors.toList());
        }
        return phones;
    }
}

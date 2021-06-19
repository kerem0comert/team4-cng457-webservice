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

    @PostMapping("/addphone")
    public Phone savePhone(@RequestBody Phone p) {
        return phoneService.savePhone(p);
    }

    @GetMapping("/getphone/{id}")
    public Phone getPhone(@PathVariable Integer id) {
        return phoneService.getPhone(id);
    }

    @GetMapping("/getallphones")
    public List<Phone> getAllPhones() {
        return phoneService.getAllPhones();
    }

    @GetMapping("/getphonewithid/{id}")
    public List<Phone> getPhoneWithId(@PathVariable int id) {
        return phoneService.getPhoneWithId(id);
    }

    @GetMapping("/getphonewithbrandname/{brandName}")
    public List<Phone> getPhoneWithBrandName(@PathVariable String brandName) {
        return phoneService.getPhoneWithBrandName(brandName);
    }

    @GetMapping("/getphone")
    public List<Phone> getPhoneByPredicate(@RequestParam(required = false) String model,
                                           @RequestParam(required = false) Integer batteryLife,
                                           @RequestParam(required = false) String screenSize,
                                           @RequestParam(required = false) Integer internalMemory,
                                           @RequestParam(required = false) String extraFeatures,
                                           @RequestParam(required = false) String brand) {
        List<Phone> phones = phoneService.getAllPhones();
        if (model != null) {
            phones = phones.stream()
                    .filter(x -> x.getModel().equals(model))
                    .collect(Collectors.toList());
        }
        if (batteryLife != null) {
            phones = phones.stream()
                    .filter(x -> batteryLife.equals(x.getBatteryLife()))
                    .collect(Collectors.toList());
        }
        if (screenSize != null) {
            phones = phones.stream()
                    .filter(x -> x.getScreenSize().equals(screenSize))
                    .collect(Collectors.toList());
        }
        if (screenSize != null) {
            phones = phones.stream()
                    .filter(x -> x.getScreenSize().equals(screenSize))
                    .collect(Collectors.toList());
        }
        if (internalMemory != null) {
            phones = phones.stream()
                    .filter(x -> internalMemory.equals(x.getInternalMemory()))
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

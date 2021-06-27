package com.cng457.Project.controller;

import com.cng457.Project.entity.Brand;
import com.cng457.Project.entity.Phone;
import com.cng457.Project.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Did not generate JavaDoc for all the getters to each URL endpoint, as they are self-explanatory.
 */
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

    @GetMapping("/getAllScreenSizesForPhones")
    public List<String> getAllScreenSizesForPhones() {
        return phoneService.getAllScreenSizesForPhones();
    }

    /**
     * First, we get all phones from the service.
     * There are certain predicates, all of them specified as parameters below. For each of them,
     * we made use of Java 8's Stream functionality to filter out the ones as specified in the attributes
     * when the method call gets made. Of course, none of the field is mandatory, so if we get null for any
     * of them we simply pass the filtering for that attribute.
     * @param model
     * @param minPrice
     * @param maxPrice
     * @param minBatteryLife
     * @param maxBatteryLife
     * @param screenSize
     * @param minInternalMemory
     * @param maxInternalMemory
     * @param extraFeatures
     * @param brand
     * @return a list of {@link Phone} objects, that pass the applied filter.
     */
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
            List<String> brandList = Arrays.asList(brand.split(","));
            phones = phones.stream()
                    .filter(x -> brandList.contains(x.getBrand().getBrandName()))
                    .collect(Collectors.toList());
        }
        return phones;
    }
}

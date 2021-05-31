package com.cng457.Project.Controller;

import com.cng457.Project.entity.ExtraFeatures;
import com.cng457.Project.service.ExtraFeaturesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ExtraFeaturesController {
    @Autowired
    ExtraFeaturesService extraFeaturesService;

    @PostMapping("/addExtraFeatures")
    public ExtraFeatures saveExtraFeatures(@RequestBody ExtraFeatures ef) {
        return extraFeaturesService.saveExtraFeatures(ef);
    }

    @GetMapping("/getExtraFeatures/{efId}")
    public ExtraFeatures getExtraFeatures(@PathVariable int efId) {
        return extraFeaturesService.getExtraFeatures(efId);
    }

}

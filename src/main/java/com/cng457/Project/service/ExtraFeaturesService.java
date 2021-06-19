package com.cng457.Project.service;

import com.cng457.Project.entity.ExtraFeatures;
import com.cng457.Project.repository.ExtraFeaturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExtraFeaturesService {
    @Autowired
    ExtraFeaturesRepository extraFeaturesRepository;

    public ExtraFeatures saveExtraFeatures(ExtraFeatures ef) {
        return extraFeaturesRepository.save(ef);
    }

    public ExtraFeatures getExtraFeatures(int efId) {
        return extraFeaturesRepository.findById(efId).orElse(null);
    }
}

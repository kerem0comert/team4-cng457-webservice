package com.cng457.Project.service;

import com.cng457.Project.entity.ExtraFeatures;
import com.cng457.Project.repository.ExtraFeaturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.locks.ReentrantReadWriteLock;

@Service
public class ExtraFeaturesService {
    @Autowired
    ExtraFeaturesRepository extraFeaturesRepository;

    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public ExtraFeatures saveExtraFeatures(ExtraFeatures ef) {
        lock.writeLock().lock();
        try {
            return extraFeaturesRepository.save(ef);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public ExtraFeatures getExtraFeatures(int efId) {
        lock.readLock().lock();
        try {
            return extraFeaturesRepository.findById(efId).orElse(null);
        } finally {
            lock.readLock().unlock();
        }
    }
}

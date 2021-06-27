package com.cng457.Project.service;

import com.cng457.Project.entity.Brand;
import com.cng457.Project.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Service
public class BrandService {
    @Autowired
    BrandRepository brandRepository;

    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public Brand saveBrand(Brand b) {
        lock.writeLock().lock();
        try {
            return brandRepository.save(b);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public Brand getBrand(int id) {
        lock.readLock().lock();
        try {
            return brandRepository.findById(id).orElse(null);
        } finally {
            lock.readLock().unlock();
        }
    }

    public List<Brand> getAllBrands() {
        lock.readLock().lock();
        try {
            return brandRepository.getAllBrands();
        } finally {
            lock.readLock().unlock();
        }
    }
}

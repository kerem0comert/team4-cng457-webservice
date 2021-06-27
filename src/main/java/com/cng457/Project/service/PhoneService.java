package com.cng457.Project.service;

import com.cng457.Project.entity.Phone;
import com.cng457.Project.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Service
public class PhoneService {
    @Autowired
    PhoneRepository phoneRepository;

    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public Phone savePhone(Phone p) {
        lock.writeLock().lock();
        try {
            return phoneRepository.save(p);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public Phone getPhone(int id) {
        lock.readLock().lock();
        try {
            return phoneRepository.findById(id).orElse(null);
        } finally {
            lock.readLock().unlock();
        }
    }

    public List<Phone> getAllPhones() {
        lock.readLock().lock();
        try {
            return phoneRepository.getAllPhones();
        } finally {
            lock.readLock().unlock();
        }
    }

    public List<String> getAllScreenSizesForPhones() {
        lock.readLock().lock();
        try {
            return phoneRepository.getAllScreenSizesForPhones();
        } finally {
            lock.readLock().unlock();
        }
    }

    public List<Phone> getPhoneByPredicate(List<Phone> phone) {
        lock.readLock().lock();
        try {
            return phone;
        } finally {
            lock.readLock().unlock();
        }
    }
}

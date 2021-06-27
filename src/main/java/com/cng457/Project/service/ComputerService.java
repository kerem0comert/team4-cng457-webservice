package com.cng457.Project.service;

import com.cng457.Project.entity.Computer;
import com.cng457.Project.repository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Service
public class ComputerService {
    @Autowired
    ComputerRepository computerRepository;

    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public Computer saveComputer(Computer c) {
        lock.writeLock().lock();
        try {
            return computerRepository.save(c);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public Computer getComputer(int id) {
        lock.readLock().lock();
        try {
            return computerRepository.findById(id).orElse(null);
        } finally {
            lock.readLock().unlock();
        }
    }

    public List<Computer> getAllComputers() {
        lock.readLock().lock();
        try {
            return computerRepository.getAllComputers();
        } finally {
            lock.readLock().unlock();
        }
    }

    public List<String> getAllScreenSizesForComputers() {
        lock.readLock().lock();
        try {
            return computerRepository.getAllScreenSizesForComputers();
        } finally {
            lock.readLock().unlock();
        }
    }

    public List<String> getAllScreenResolutionsForComputers() {
        lock.readLock().lock();
        try {
            return computerRepository.getAllScreenResolutionsForComputers();
        } finally {
            lock.readLock().unlock();
        }
    }

    public List<String> getAllProcessorsForComputers() {
        lock.readLock().lock();
        try {
            return computerRepository.getAllProcessorsForComputers();
        } finally {
            lock.readLock().unlock();
        }
    }

    public List<Computer> getComputerByPredicate(List<Computer> computers) {
        lock.readLock().lock();
        try {
            return computers;
        } finally {
            lock.readLock().unlock();
        }
    }
}

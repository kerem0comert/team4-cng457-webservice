package com.cng457.Project.service;

import com.cng457.Project.entity.Computer;
import com.cng457.Project.repository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComputerService {
    @Autowired
    ComputerRepository computerRepository;

    public Computer saveComputer(Computer c) {
        return computerRepository.save(c);
    }

    public Computer getComputer(int id) {
        return computerRepository.findById(id).orElse(null);
    }

    public List<Computer> getAllComputers() {
        return computerRepository.getAllComputers();
    }

    public List<Computer> getComputerWithId(int id) {
        return computerRepository.getComputerWithId(id);
    }

    public List<Computer> getComputerWithBrandName(String brandName) {
        return computerRepository.getComputerWithBrandName(brandName);
    }

    public List<String> getAllScreenSizesForComputers() {
        return computerRepository.getAllScreenSizesForComputers();
    }

    public List<String> getAllScreenResolutionsForComputers() {
        return computerRepository.getAllScreenResolutionsForComputers();
    }

    public List<String> getAllProcessorsForComputers() {
        return computerRepository.getAllProcessorsForComputers();
    }

    public List<Computer> getComputerByPredicate(List<Computer> computers) {
        return computers;

    }
}

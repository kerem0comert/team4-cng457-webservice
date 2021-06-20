package com.cng457.Project.repository;

import com.cng457.Project.entity.Brand;
import com.cng457.Project.entity.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
    @Query(value = "SELECT * FROM brand p", nativeQuery = true)
    public List<Brand> getAllBrands();
}

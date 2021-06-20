package com.cng457.Project.repository;

import com.cng457.Project.entity.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComputerRepository extends JpaRepository<Computer, Integer> {

    @Query(value = "SELECT * FROM computer c INNER JOIN product p USING(product_id)", nativeQuery = true)
    public List<Computer> getAllComputers();

    //@Query(value = "SELECT DISTINCT(b.brand_name) FROM brand b INNER JOIN product pr USING(brand_id) INNER JOIN computer ph USING(product_id)", nativeQuery = true)
    @Query(value = "SELECT DISTINCT(screen_size) FROM product pr INNER JOIN computer ph USING(product_id)", nativeQuery = true)
    public List<String> getAllScreenSizesForComputers();

    @Query(value = "SELECT DISTINCT(screen_resolution) FROM product pr INNER JOIN computer ph USING(product_id)", nativeQuery = true)
    public List<String> getAllScreenResolutionsForComputers();

    @Query(value = "SELECT DISTINCT(processor) FROM product pr INNER JOIN computer ph USING(product_id)", nativeQuery = true)
    public List<String> getAllProcessorsForComputers();
}

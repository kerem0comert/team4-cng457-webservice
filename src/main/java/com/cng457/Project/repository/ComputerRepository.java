package com.cng457.Project.repository;

import com.cng457.Project.entity.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComputerRepository extends JpaRepository<Computer, Integer> {

    @Query(value = "SELECT * FROM computer c, product p WHERE c.product_id=p.product_id ", nativeQuery = true)
    public List<Computer> getAllComputers();

    @Query(value = "SELECT * FROM computer c, product p WHERE c.product_id=p.product_id AND c.product_id LIKE %?1% ", nativeQuery = true)
    public List<Computer> getComputerWithId(int id);

    @Query(value = "SELECT * FROM computer c, product p WHERE c.product_id=p.product_id AND p.brand_brand_id IN (SELECT brand_id FROM brand b WHERE b.brand_name LIKE %:brandName%)", nativeQuery = true)
    public List<Computer> getComputerWithBrandName(String brandName);

    //@Query(value = "SELECT DISTINCT(b.brand_name) FROM brand b INNER JOIN product pr USING(brand_id) INNER JOIN computer ph USING(product_id)", nativeQuery = true)
    @Query(value = "SELECT DISTINCT(screen_size) FROM product pr INNER JOIN computer ph USING(product_id)", nativeQuery = true)
    public List<String> getAllScreenSizesForComputers();
}

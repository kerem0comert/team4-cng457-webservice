package com.cng457.Project.repository;

import com.cng457.Project.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PhoneRepository extends JpaRepository<Phone, Integer> {

    @Query(value = "SELECT * FROM phone ph INNER JOIN product p USING(product_id)", nativeQuery = true)
    public List<Phone> getAllPhones();

    @Query(value = "SELECT DISTINCT(screen_size) FROM product pr INNER JOIN phone ph USING(product_id)", nativeQuery = true)
    public List<String> getAllScreenSizesForPhones();
}

package com.cng457.Project.repository;

import com.cng457.Project.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PhoneRepository extends JpaRepository<Phone, Integer> {

    @Query(value = "SELECT * FROM phone ph INNER JOIN product p USING(product_id)", nativeQuery = true)
    public List<Phone> getAllPhones();

    @Query(value = "SELECT * FROM phone ph, product p WHERE ph.product_id=p.product_id AND ph.product_id LIKE %?1% ", nativeQuery = true)
    public List<Phone> getPhoneWithId(int id);

    @Query(value = "SELECT * FROM phone ph, product p WHERE ph.product_id=p.product_id AND p.brand_brand_id IN (SELECT brand_id FROM brand b WHERE b.brand_name LIKE %:brandName%)", nativeQuery = true)
    public List<Phone> getPhoneWithBrandName(String brandName);
}

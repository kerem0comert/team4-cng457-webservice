package com.cng457.Project.repository;

import com.cng457.Project.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PhoneRepository extends JpaRepository<Phone, Integer> {

    @Query(value = "SELECT * FROM phone ph, product p WHERE ph.product_id=p.product_id ", nativeQuery = true)
     public List<Phone> getAllPhones();

}

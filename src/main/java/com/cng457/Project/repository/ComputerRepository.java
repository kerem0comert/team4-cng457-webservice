package com.cng457.Project.repository;

import com.cng457.Project.entity.Computer;
import com.cng457.Project.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComputerRepository extends JpaRepository<Computer, Integer> {

    @Query(value = "SELECT * FROM computer c, product p WHERE c.product_id=p.product_id ", nativeQuery = true)
    public List<Computer> getAllComputers();

    @Query(value = "SELECT * FROM computer c, product p WHERE c.product_id=p.product_id AND c.product_id LIKE %?1% ", nativeQuery = true)
    public List<Computer> getComputerWithId(int id);

 //   public List<Computer> findByproductIdContains(int id);
}

package com.lab4_fp_grupo7.repository;

import com.lab4_fp_grupo7.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeesRepository extends JpaRepository<Employees,Integer> {


}

package com.lab4_fp_grupo7.repository;

import com.lab4_fp_grupo7.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeesRepository extends JpaRepository<Employees,Integer> {
    @Query(value = "select * from employees order by salary desc", nativeQuery = true)
    List<Employees> obtenerEmpleadosMayorSueldo();


}

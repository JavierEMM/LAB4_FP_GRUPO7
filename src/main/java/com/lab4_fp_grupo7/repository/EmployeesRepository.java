package com.lab4_fp_grupo7.repository;

import com.lab4_fp_grupo7.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeesRepository extends JpaRepository<Employees,Integer> {
    @Query(value = "SELECT e.* FROM hr.employees e inner join hr.departments d on e.employee_id =d.manager_id;", nativeQuery = true)
    List<Employees> listaManagers();

}

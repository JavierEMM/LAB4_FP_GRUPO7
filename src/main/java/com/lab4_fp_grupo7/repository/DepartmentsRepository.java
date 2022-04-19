package com.lab4_fp_grupo7.repository;

import com.lab4_fp_grupo7.entity.Departments;
import com.lab4_fp_grupo7.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentsRepository extends JpaRepository<Departments,Integer> {

    @Query(value = "select d.department_id, d.department_name, avg(e.salary) as salary from hr.departments d\n" +
            "left join hr.employees e on d.department_id = e.department_id \n" +
            "group by d.department_id, d.department_name\n" +
            "order by d.department_id ;", nativeQuery = true)
    List<Departments> obtenerPromedioSueldoPorDepartamento();


}

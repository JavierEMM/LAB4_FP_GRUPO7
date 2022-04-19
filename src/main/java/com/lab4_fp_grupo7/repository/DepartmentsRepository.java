package com.lab4_fp_grupo7.repository;

import com.lab4_fp_grupo7.dto.DepartmentsDTO;
import com.lab4_fp_grupo7.entity.Departments;
import com.lab4_fp_grupo7.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentsRepository extends JpaRepository<Departments,Integer> {

    @Query(value = "SELECT d.department_id as 'iddepartment',d.department_name as 'departmentname',truncate(avg(e.salary),0) as 'promedio' FROM employees e INNER JOIN departments d ON d.department_id = e.department_id group by d.department_id", nativeQuery = true)
    List<DepartmentsDTO> obtenerPromedioSueldoPorDepartamento();


}

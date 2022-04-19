package com.lab4_fp_grupo7.repository;

import com.lab4_fp_grupo7.dto.EmployeeJobDto;
import com.lab4_fp_grupo7.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface EmployeesRepository extends JpaRepository<Employees,Integer> {
    @Query(value = "select e.first_name, e.last_name, h.start_date, h.end_date, j.job_title from hr.employees e \n" +
            "left join hr.jobs j on e.job_id = j.job_id \n" +
            "left join hr.job_history h on j.job_id = h.job_id and h.employee_id = e.employee_id\n" +
            "order by e.salary desc;\n", nativeQuery = true)
    List<EmployeeJobDto> obtenerEmpleadosMayorSueldo();

    @Query(nativeQuery = true, value = "SELECT e.* FROM employees e INNER JOIN jobs j  ON j.job_id = e.job_id WHERE e.first_name LIKE %?1%")
    List<Employees> buscadorEmployee(String buscar);

    @Query(value = "select e.employee_id, e.first_name, e.last_name, j.job_title, e.salary from hr.employees e \n" +
            "left join hr.jobs j on e.job_id = j.job_id \n" +
            "left join hr.job_history h on j.job_id = h.job_id and h.employee_id = e.employee_id\n" +
            "order by e.employee_id asc;", nativeQuery = true)
    List<EmployeeJobDto> obtenerEmpleadosPorDepartamento();
}

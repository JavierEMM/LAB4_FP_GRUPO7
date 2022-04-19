package com.lab4_fp_grupo7.repository;

import com.lab4_fp_grupo7.dto.EmployeeSalarioDTO;
import com.lab4_fp_grupo7.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;


@Repository
public interface EmployeesRepository extends JpaRepository<Employees,Integer> {
    List<Employees> findByDepartmentId(Integer id);
    @Query(nativeQuery = true, value = "SELECT e.first_name as 'nombre',e.last_name as 'apellido',e.hire_date as'inicio',j.end_date as 'final',js.job_title as 'titulo' FROM employees e INNER JOIN job_history j ON j.employee_id = e.employee_id INNER JOIN jobs js ON js.job_id = j.job_id WHERE e.salary = ?1 order by e.salary DESC")
    List<EmployeeSalarioDTO> buscadorEmpleadoSalario(Integer salario);
    @Query(nativeQuery = true,value = "SELECT * FROM employees e where e.first_name LIKE %?1%")
    List<Employees> buscadorEmployee(String search);
    @Query(nativeQuery = true, value = "SELECT e.first_name as 'nombre',e.last_name as 'apellido',e.hire_date as'inicio',j.end_date as 'final',js.job_title as 'titulo' FROM employees e INNER JOIN job_history j ON j.employee_id = e.employee_id INNER JOIN jobs js ON js.job_id = j.job_id order by e.salary DESC")
    List<EmployeeSalarioDTO> obtenerEmployeeSalario();
}

package com.lab4_fp_grupo7.dto;

import com.lab4_fp_grupo7.entity.Employees;
import com.lab4_fp_grupo7.entity.Jobs;
import org.springframework.boot.autoconfigure.batch.BatchProperties;

import java.math.BigDecimal;
import java.util.Date;

public interface EmployeeJobDto {

    Integer getEmployeeId();
    String getFirstName();
    String getLastName();
    Date getHireDate();
    Date getEnddate();
    String getJobtitle();
    BigDecimal getSalary();


}

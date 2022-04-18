package com.lab4_fp_grupo7.repository;


import com.lab4_fp_grupo7.entity.Departments;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentsRepository extends JpaRepository<Departments,Integer> {


}

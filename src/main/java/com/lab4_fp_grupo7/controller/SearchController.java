package com.lab4_fp_grupo7.controller;


import com.lab4_fp_grupo7.repository.DepartmentsRepository;
import com.lab4_fp_grupo7.repository.EmployeesRepository;
import com.lab4_fp_grupo7.repository.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import javax.persistence.criteria.CriteriaBuilder;

@Controller
@RequestMapping("/search")
public class SearchController{

    @Autowired
    EmployeesRepository employeesRepository;

    @Autowired
    JobsRepository jobsRepository;
    @Autowired
    DepartmentsRepository departmentsRepository;


    @GetMapping(value = {"","/"})
    public String indice(){
        return "Search/indice";
    }

    @GetMapping(value = {"/salario"})
    public String listaEmpleadosMayorSalario (Model model){
        model.addAttribute("listaEmpleadosMayorsueldo",employeesRepository.obtenerEmployeeSalario());

      //COMPLETAR
        return "Search/lista2";
    }

    @PostMapping("/busqueda")
    public String buscar (@RequestParam("searchField") String busqueda, Model model){
        try{
            Integer numero=Integer.parseInt(busqueda);
            model.addAttribute("listaEmpleadosMayorsueldo",employeesRepository.buscadorEmpleadoSalario(numero));
        }catch (NumberFormatException e){
            model.addAttribute("listaEmpleadosMayorsueldo",employeesRepository.obtenerEmployeeSalario());
            model.addAttribute("msg","Se deben ingresar un numero");
        }
        return "/Search/lista2";
        //COMPLETAR
    }
    @GetMapping(value = {"/departamentos"})
    public String listaDepartamentos (Model model){
        model.addAttribute("listaDepartamentos",departmentsRepository.obtenerPromedioSueldoPorDepartamento());
        return "/Search/salario";
    }
    @GetMapping(value = {"/departamentos/info"})
    public String infoDepartments (Model model,@RequestParam("id") Integer id){
        model.addAttribute("listaEmployees",employeesRepository.findByDepartmentId(id));
        return "/Search/lista3";
    }
    @GetMapping(value = "/Filtro2")
    public String cantidadEmpleadosPorPais (Model model){

        return "/Search/salario";
    }

    @GetMapping("/listar")
    public String listarEmpleadoDep(Model model) {
        return "/Search/lista3";

    }


}

package com.lab4_fp_grupo7.controller;


import com.lab4_fp_grupo7.repository.DepartmentsRepository;
import com.lab4_fp_grupo7.repository.EmployeesRepository;
import com.lab4_fp_grupo7.repository.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/Search")
public class SearchController {

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

    @GetMapping(value = {"/Salario"})
    public String listaEmpleadosMayorSalario (Model model){
        model.addAttribute("listaEmpleadosMayorsueldo",employeesRepository.obtenerEmpleadosMayorSueldo());

      //COMPLETAR
        return "Search/lista2";
    }

    @PostMapping("/busqueda")
    public String buscar (){
        return "/Search/salario";
        //COMPLETAR
    }

    @GetMapping(value = "/Filtro2")
    public String cantidadEmpleadosPorPais (Model model){
        model.addAttribute("listaSalarioPorDepartamento",departmentsRepository.obtenerPromedioSueldoPorDepartamento());

        //COMPLETAR
        return "/Search/salario";
    }

    @GetMapping("/listar")
    public String listarEmpleadoDep(Model model) {

        model.addAttribute("listaEmpleadosPorDepartamento",employeesRepository.obtenerEmpleadosPorDepartamento());
        //COMPLETAR
        return "/Search/lista3";

    }


}

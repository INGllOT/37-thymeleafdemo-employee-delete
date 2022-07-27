package com.inglot.springboot.thymeleafdemo.controller;

import com.inglot.springboot.thymeleafdemo.entity.Employee;
import com.inglot.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;


    public EmployeeController  (EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }


     @GetMapping("/list")
    public String listEmployees(Model model) {

        List<Employee> employees = employeeService.findAll();

         model.addAttribute("employees", employees);

         return "employees/list-employees";
     }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {

        Employee employee = new Employee();

        model.addAttribute("employees", employee);

        return "employees/showFormForAdd";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {

        employeeService.save(employee);

        return  "redirect:/employees/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId, Model model) {

        Optional <Employee> employee = employeeService.findById(theId);

        Employee employee1 = employee.get();

        model.addAttribute("employees",employee1);

        return  "employees/showFormForAdd";
    }

    @GetMapping("/delete")
    public String showFormForUpdate(@RequestParam("employeeId") int theId) {

        employeeService.deleteById(theId);

        return  "redirect:/employees/list";
    }
}

package com.newhomework.homeworktask.employeecontroller;
;
import com.newhomework.homeworktask.database.Employee;
import com.newhomework.homeworktask.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    public final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public List<Employee> all() {
        return employeeService.getAll();
    }

    @GetMapping("/add")
    public Employee add(String firstName, String lastName) {
        return employeeService.add(new Employee(firstName, lastName));
    }
    @GetMapping("/remove")
    public Employee remove(String firstName, String lastName) {
        return employeeService.remove(firstName, lastName);
    }
    @GetMapping("/find")
    public Employee find(String firstName, String lastName) {
        return employeeService.find(firstName, lastName);
    }
}

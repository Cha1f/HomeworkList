package com.newhomework.homeworktask.service;

import com.newhomework.homeworktask.database.Employee;
import com.newhomework.homeworktask.exceptions.EmployeeAlreadyAddedException;
import com.newhomework.homeworktask.exceptions.EmployeeNotFoundException;
import com.newhomework.homeworktask.exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService {
    private static final int sizeLimit = 10;
    private final List<Employee> employees = new ArrayList<>(sizeLimit);

    public List<Employee> getAll() {
        return Collections.unmodifiableList(employees);
    }

    public Employee add(Employee employee) {
        if (employees.size() >= sizeLimit) {
            throw new EmployeeStorageIsFullException();
        }
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        return employee;
    }

    public Employee find(String firstName, String lastName) {
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
             return employee;
            }
        }
        throw new EmployeeNotFoundException();
    }

    public Employee remove(String firstName, String lastName) {
        Employee employee = find(firstName, lastName);
        employees.remove(employee);
        return employee;
    }

}

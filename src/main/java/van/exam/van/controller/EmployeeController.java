package van.exam.van.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import van.exam.van.repository.EmployeeRepository;
import van.exam.van.model.Employee;
import van.exam.van.exception.EmployeeNotFoundException;

@RestController
@RequestMapping("/employees")
class EmployeeController {

  private final EmployeeRepository repository;

  EmployeeController(EmployeeRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  List<Employee> all() {
    return repository.findAll();
  }

  @PostMapping
  Employee newEmployee(@RequestBody Employee newEmployee) {
    return repository.save(newEmployee);
  }

  @GetMapping("/{id}")
  Employee one(@PathVariable Long id) {

    return repository.findById(id)
      .orElseThrow(() -> new EmployeeNotFoundException(id));
  }

  @PatchMapping("/{id}")
  Employee updateEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
    return repository.findById(id)
      .map(employee -> {
        if (newEmployee.getName() != null)
            employee.setName(newEmployee.getName());
        if (newEmployee.getContactNo() != null)
            employee.setContactNo(newEmployee.getContactNo());
        if (newEmployee.getRole() != null)
            employee.setRole(newEmployee.getRole());
    
        return repository.save(employee);
      })
      .orElseGet(() -> {
        newEmployee.setId(id);
        return repository.save(newEmployee);
      });
  }

  @DeleteMapping("/{id}")
  void deleteEmployee(@PathVariable Long id) {
    repository.deleteById(id);
  }
}

package van.exam.van.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import van.exam.van.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    
}

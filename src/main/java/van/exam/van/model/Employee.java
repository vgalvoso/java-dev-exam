package van.exam.van.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"contactNo"})})
public class Employee {
    
    private @Id @GeneratedValue Long id;
    private String name;
    private String contactNo;
    private String role;

    Employee() {}

    public Employee(String name, String role, String contactNo){
        this.name = name;
        this.role = role;
        this.contactNo = contactNo;
    }

    //Getters
    public Long getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getContactNo(){
        return this.contactNo;
    }

    public String getRole(){
        return this.role;
    }

    //Setters
    public void setId(Long id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setContactNo(String contactNo){
        this.contactNo = contactNo;
    }

    public void setRole(String role){
        this.role = role;
    }

    public String toString(){
        return "Employee{" + "id=" + this.id + ", name='" + this.name + "', contactNo='" + this.contactNo + 
            "', role='" + this.role + "'}";
    }
}

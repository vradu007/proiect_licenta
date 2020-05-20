
package controller;

import dao.EmployeeDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Department;
import model.Employee;

public class EmployeeController {
    
    private EmployeeDao employeeDao;
    
    private EmployeeController() {
        String url = "jdbc:mysql://localhost/hr_management_database";
        
        try {
            Connection con = DriverManager.getConnection(url,"root","");
            employeeDao = new EmployeeDao(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public static EmployeeController getInstance() {
        return EmployeeControllerHolder.INSTANCE;
    }
    
    private static class EmployeeControllerHolder {

        private static final EmployeeController INSTANCE = new EmployeeController();
    }
    
    public boolean addEmployee(Employee employee){
        return employeeDao.insert(employee);
    }
    
    public boolean deleteEmployee(Employee employee){
        return employeeDao.delete(employee);
    }
    
    public List<Employee> getAllEmployees(){
        return employeeDao.getAllEmployees();
    }
    
    public List<Integer> getAllEmployeeId(){
        List<Employee> employees = employeeDao.getAllEmployees();
        List<Integer> idList = new ArrayList<Integer>();
        
        for(Employee employee : employees){
            idList.add(employee.getId());
        }
        
        return idList;
    }
    
    
    public List<String> toStringList(Employee employee){
        List<String> list = new ArrayList<>();
        list.add("ID: " + employee.getId());
        list.add("Nume: " + employee.getLastName());
        list.add("Prenume: " + employee.getFirstName());
        list.add("Data angajarii: " + employee.getEmploymentDate());
        list.add("Salariu brut: " + employee.getSalary());
        list.add("Salariu net: " + applyTaxes(employee));
        list.add("Schema bonus: " + employee.getBonusScheme());
        list.add("Adresa: " + employee.getAddress());
        list.add("Email: " + employee.getEmail());
        list.add("CNP: " + employee.getCNP());
        list.add("Telefon: " + employee.getPhoneNumber());
        list.add("Functie: " + employee.getJobTitle());
        list.add("Indice de productivitate: " + employee.getProductivityIndex());
        return list;
    }
    
    public Employee getEmployeeById(int id){
        return employeeDao.getEmployeeById(id);
    }
    
    private double applyTaxes(Employee employee){
        double salary = employee.getSalary();
        System.out.println(salary);
        Department department = DepartmentController.getInstance().getDepartmentById(employee.getDepartmentId());
        System.out.println(department);
        double taxesPercentage = department.getTaxesPercentage();
        return salary - salary * taxesPercentage / 100;
    }
    
    public boolean updateSalaryAccordingly(Employee employee){
        double newSalary = employee.getSalary();
        if(employee.getProductivityIndex() >= 50){
            newSalary = newSalary + employee.getBonusScheme() * employee.getSalary() / 100;
        }
        return employeeDao.updateSalary(employee, newSalary);
    }
    
}

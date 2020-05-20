package controller;

import dao.DepartmentDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Department;
import model.Employee;

public class DepartmentController {
    
    private DepartmentDao departmentDao;
    
    private DepartmentController() {
        String url = "jdbc:mysql://localhost/hr_management_database";
        
        try {
            Connection con = DriverManager.getConnection(url,"root","");
            departmentDao = new DepartmentDao(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public static DepartmentController getInstance() {
        return DepartmentControllerHolder.INSTANCE;
    }
    
    private static class DepartmentControllerHolder {

        private static final DepartmentController INSTANCE = new DepartmentController();
    }
    
    public boolean addDepartment(Department department){
        return departmentDao.insert(department);
    }
    
    public List<Department> getAllDepartments(){
        return departmentDao.getAllDepartments();
    }
    
    public boolean deleteDepartment(Department department){
        return departmentDao.delete(department);
    }
    
    public Department getDepartmentById(int departmentId){
        return departmentDao.getDepartmentById(departmentId);
    }
    
    public List<String> toStringList(Department department){
        List<String> list = new ArrayList<>();
        
        list.add("Id: " + department.getId());
        list.add("Nume departament: " + department.getName());
        list.add("Capacitate maxima: " + department.getMaximumCapacity());
        list.add("Locatie: " + department.getLocation());
        list.add("Procentaj taxe: " + department.getTaxesPercentage());
        list.add("Id manager: " + department.getManagerId());
        
        return list;
    }
    
    public int getCurrentCapacity(Department department){
        List<Employee> employees = EmployeeController.getInstance().getAllEmployees();
        int count = 0;
        for(Employee employee : employees){
            if(employee.getDepartmentId() == department.getId()){
                count++;
            }
        }
        return count;
    }
}   

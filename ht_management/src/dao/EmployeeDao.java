package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Employee;

public class EmployeeDao {

    private Connection con;
    private PreparedStatement selectAllStatement;
    private PreparedStatement insertStatement;
    private PreparedStatement deleteStatement;
    private PreparedStatement selectByIdStatement;
    private PreparedStatement updateSalaryStatement;
    
    public EmployeeDao(Connection con) { 
        this.con = con;
        try {
            selectAllStatement = con.prepareStatement("SELECT * FROM Employee");
            insertStatement = con.prepareStatement("INSERT INTO Employee VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
            deleteStatement = con.prepareStatement("DELETE FROM Employee WHERE id = ?");
            selectByIdStatement = con.prepareStatement("SELECT * FROM Employee WHERE id = ?");
            updateSalaryStatement = con.prepareStatement("UPDATE Employee SET salary = ? WHERE id = ?");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public List<Employee> getAllEmployees(){
        try(ResultSet rs = selectAllStatement.executeQuery()){
            
            List<Employee> list = new ArrayList<>();
            while(rs.next()){
                Employee employee = new Employee(
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getDate("employment_date"),
                        rs.getDouble("salary"),
                        rs.getDouble("bonus_scheme"),
                        rs.getString("address"),
                        rs.getString("email"),
                        rs.getString("CNP"),
                        rs.getString("phone_number"),
                        rs.getString("job_title"),
                        rs.getDouble("productivity_index"),
                        rs.getInt("department_id")
                );
                employee.setId(rs.getInt("id"));
                list.add(employee);
            }
            return list;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
        return Collections.emptyList();
    }
    
    public boolean insert(Employee employee){
        try {
            insertStatement.setInt(1, employee.getId());
            insertStatement.setString(2, employee.getFirstName());
            insertStatement.setString(3, employee.getLastName());
            insertStatement.setDate(4, (Date)employee.getEmploymentDate());
            insertStatement.setDouble(5, employee.getSalary());
            insertStatement.setDouble(6, employee.getBonusScheme());
            insertStatement.setString(7, employee.getAddress());
            insertStatement.setString(8, employee.getAddress());
            insertStatement.setString(9, employee.getCNP());
            insertStatement.setString(10, employee.getPhoneNumber());
            insertStatement.setString(11, employee.getJobTitle());
            insertStatement.setDouble(12, employee.getProductivityIndex());
            insertStatement.setInt(13, employee.getDepartmentId());
            
            return insertStatement.executeUpdate() != 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public boolean delete(Employee employee){
        
        try {
            deleteStatement.setInt(1, employee.getId());
            System.out.println(employee.getId());
            return deleteStatement.executeUpdate() != 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }
    
    public Employee getEmployeeById(int id){
        try {
            selectByIdStatement.setInt(1, id);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        try(ResultSet rs = selectByIdStatement.executeQuery()){
            while(rs.next()){
                Employee employee = new Employee(
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getDate("employment_date"),
                        rs.getDouble("salary"),
                        rs.getDouble("bonus_scheme"),
                        rs.getString("address"),
                        rs.getString("email"),
                        rs.getString("CNP"),
                        rs.getString("phone_number"),
                        rs.getString("job_title"),
                        rs.getDouble("productivity_index"),
                        rs.getInt("department_id")
                );
                employee.setId(rs.getInt("id"));
                return employee;
            }
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    public boolean updateSalary(Employee employee, double newSalary){
        try {
            updateSalaryStatement.setDouble(1, newSalary);
            updateSalaryStatement.setInt(2, employee.getId());
            return updateSalaryStatement.executeUpdate() != 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
}

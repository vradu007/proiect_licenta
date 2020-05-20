package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.Department;

public class DepartmentDao {

    private Connection con;
    private PreparedStatement selectAllStatement;
    private PreparedStatement insertStatement;
    private PreparedStatement deleteStatement;
    private PreparedStatement selectByIdStatement;

    public DepartmentDao(Connection con) {
        this.con = con;
        try {
            selectAllStatement = con.prepareStatement("SELECT * FROM Department");
            insertStatement = con.prepareStatement("INSERT INTO Department VALUES (?,?,?,?,?,?)");
            deleteStatement = con.prepareStatement("DELETE FROM Department WHERE id = ?");
            selectByIdStatement = con.prepareStatement("SELECT * FROM Department WHERE id = ?");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public List<Department> getAllDepartments(){
        try(ResultSet rs = selectAllStatement.executeQuery()){
            
            List<Department> list = new ArrayList<>();
            while(rs.next()){
                Department department = new Department(
                        rs.getString("department_name"),
                        rs.getInt("maximum_capacity"),
                        rs.getString("location"),
                        rs.getDouble("taxes_percentage"),
                        rs.getInt("manager_id")
                );
                department.setId(rs.getInt("id"));
                list.add(department);
            }
            return list;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
        return Collections.emptyList();
    }
    
    public boolean insert(Department department){
        try {
            insertStatement.setInt(1, department.getId());
            insertStatement.setString(2, department.getName());
            insertStatement.setInt(3, department.getMaximumCapacity());
            insertStatement.setString(4, department.getLocation());
            insertStatement.setDouble(5, department.getTaxesPercentage());
            insertStatement.setInt(6, department.getManagerId());
            return insertStatement.executeUpdate() != 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }
    
    public boolean delete(Department department){
        try {
            deleteStatement.setInt(1, department.getId());
            return deleteStatement.executeUpdate() != 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }
    
    public Department getDepartmentById(int id){
        try {
            selectByIdStatement.setInt(1, id);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        try(ResultSet rs = selectByIdStatement.executeQuery()){
            if(rs.next()){
                Department department = new Department(
                        rs.getString("department_name"),
                        rs.getInt("maximum_capacity"),
                        rs.getString("location"),
                        rs.getDouble("taxes_percentage"),
                        rs.getInt("manager_id")
                );
                department.setId(rs.getInt("id"));
                return department;
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    
}

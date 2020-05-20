package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.Account;
import model.Employee;
import model.enums.AccessRights;
import model.enums.EditRights;

public class AccountDao {

    private Connection con;
    private PreparedStatement selectAllStatement;
    private PreparedStatement insertStatement;
    private PreparedStatement deleteStatement;
    private PreparedStatement selectAccountStatement;
    
    public AccountDao(Connection con) {
        this.con = con;
        try {
            selectAllStatement = con.prepareStatement("SELECT * FROM Account");
            insertStatement = con.prepareStatement("INSERT INTO Account VALUES (?,?,?,?,?,?,?)");
            deleteStatement = con.prepareStatement("DELETE FROM Account WHERE id = ?");
            selectAccountStatement = con.prepareStatement("SELECT * FROM Account WHERE id = ?");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    public List<Account> getAllAccounts(){
        try(ResultSet rs = selectAllStatement.executeQuery()){
            
            List<Account> list = new ArrayList<>();
            while(rs.next()){
                Account account = new Account(
                        rs.getString("username"),
                        rs.getString("password"),
                        AccessRights.valueOf(rs.getString("access_rights")),
                        EditRights.valueOf(rs.getString("edit_rights")),
                        rs.getString("nickname"),
                        rs.getInt("employee_id")
                );
                account.setId(rs.getInt("id"));
                list.add(account);
            }
            return list;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
        return Collections.emptyList();
    }
    
    public boolean insert(Account account){
        try {
            insertStatement.setInt(1, account.getId());
            insertStatement.setString(2, account.getUsername());
            insertStatement.setString(3, account.getPassword());
            insertStatement.setString(4, account.getAccessRights().toString());
            insertStatement.setString(5, account.getEditRights().toString());
            insertStatement.setString(6, account.getNickname());
            insertStatement.setInt(7, account.getEmployeeId());
            return insertStatement.executeUpdate() != 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }
    
    public boolean delete(Account account){
        try {
            deleteStatement.setInt(1, account.getId());
            return deleteStatement.executeUpdate() != 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }
    
    public Account getAccountByIndex(int id){
        try {
            selectAccountStatement.setInt(1, id);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        try (ResultSet rs = selectAccountStatement.executeQuery()) {
            while(rs.next()){
                Account account = new Account(
                        rs.getString("username"),
                        rs.getString("password"),
                        AccessRights.valueOf(rs.getString("access_rights")),
                        EditRights.valueOf(rs.getString("edit_rights")),
                        rs.getString("nickname"),
                        rs.getInt("employee_id")
                );
                account.setId(rs.getInt("id"));
                return account;
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }
    
    
    
}

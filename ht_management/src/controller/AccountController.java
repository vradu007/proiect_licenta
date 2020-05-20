package controller;

import dao.AccountDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Account;

public class AccountController {
    
    private AccountDao accountDao;
    
    private AccountController() {
        String url = "jdbc:mysql://localhost/hr_management_database";
        
        try {
            Connection con = DriverManager.getConnection(url,"root","");
            accountDao = new AccountDao(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public static AccountController getInstance() {
        return AccountControllerHolder.INSTANCE;
    }
    
    private static class AccountControllerHolder {

        private static final AccountController INSTANCE = new AccountController();
    }
    
    public boolean addAccount(Account account){
        return accountDao.insert(account);
    }
    
    public boolean deleteAccount(Account account){
        return accountDao.delete(account);
    }
    
    public List<Account> getAllAccounts(){
        return accountDao.getAllAccounts();
    }
    
    public Account getAccountByIndex(int id){
        return accountDao.getAccountByIndex(id);
    }
    
    public List<Integer> getAllAccountEmployeeId(){
        List<Account> list = accountDao.getAllAccounts();
        List<Integer> idList = new ArrayList<Integer>();
        
        for(Account account : list){
            idList.add(account.getEmployeeId());
        }
        
        return idList;
        
    }
    
    public List<Integer> getAllAccountId(){
        List<Account> list = accountDao.getAllAccounts();
        List<Integer> idList = new ArrayList<>();
        
        for(Account account : list){
            idList.add(account.getId());
        }
        
        return idList;
    }
    
    public List<Account> getAllAcountsByEmployeeId(int employeeId){
        List<Account> list = accountDao.getAllAccounts();
        List<Account> returnList = new ArrayList<>();
        for(Account account : list){
            if(account.getEmployeeId() == employeeId){
                returnList.add(account);
            }
        }
        return returnList;
    }
}

package utils;

public class IdManager {

    private static int accountId = 0;
    private static int departmentId = 0;
    private static int employeeId = 0;
    
    private IdManager(){
        
    }
    
    public int getAccountId(){
        return ++accountId;
    }
    
    public int getDepartmentId(){
        return ++departmentId;
    }
    
    public int getEmployeeId(){
        return ++employeeId;
    }
    
    public static IdManager getInstance(){
        return IdManagerHandler.INSTANCE;
    }
    
    private static class IdManagerHandler {

        private static final IdManager INSTANCE = new IdManager();
    }
}

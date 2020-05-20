package model;

import model.enums.AccessRights;
import model.enums.EditRights;
import utils.IdManager;

public class Account {

    private int id;
    private String username;
    private String password;
    private AccessRights accessRights;
    private EditRights editRights;
    private String nickname;
    private int employeeId;

    public Account(String username, String password, AccessRights accessRights, EditRights editRights, String nickname, int employeeId) {
        this.id = IdManager.getInstance().getAccountId();
        this.username = username;
        this.password = password;
        this.accessRights = accessRights;
        this.editRights = editRights;
        this.nickname = nickname;
        this.employeeId = employeeId;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AccessRights getAccessRights() {
        return accessRights;
    }

    public void setAccessRights(AccessRights accessRights) {
        this.accessRights = accessRights;
    }

    public EditRights getEditRights() {
        return editRights;
    }

    public void setEditRights(EditRights editRights) {
        this.editRights = editRights;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", username=" + username + ", password=" + password + ", accessRights=" + accessRights + ", editRights=" + editRights + ", nickname=" + nickname + ", employeeId=" + employeeId + '}';
    }
    
    
}

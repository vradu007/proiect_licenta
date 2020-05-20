package model;

import java.io.Serializable;
import java.util.Date;
import utils.IdManager;

public class Employee implements Serializable{

    private int id;
    private String firstName;
    private String lastName;
    private Date employmentDate;    
    private double salary;
    private double bonusScheme;
    private String address;
    private String email;
    private String CNP;
    private String phoneNumber;
    private String jobTitle;
    private double productivityIndex;
    private int departmentId;
    
    public Employee(String firstName, String lastName, Date employmentDate, double salary, double bonus_scheme, String address, String email, String CNP, String phoneNumber, String jobDescription, double productivityIndex, int departmentId) {
        this.id = IdManager.getInstance().getEmployeeId();
        this.firstName = firstName;
        this.lastName = lastName;
        this.employmentDate = employmentDate;
        this.salary = salary;
        this.bonusScheme = bonus_scheme;
        this.address = address;
        this.email = email;
        this.CNP = CNP;
        this.phoneNumber = phoneNumber;
        this.jobTitle = jobDescription;
        this.productivityIndex = productivityIndex;
        this.departmentId = departmentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(Date employmentDate) {
        this.employmentDate = employmentDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getBonusScheme() {
        return bonusScheme;
    }

    public void setBonusScheme(double bonusScheme) {
        this.bonusScheme = bonusScheme;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public double getProductivityIndex() {
        return productivityIndex;
    }

    public void setProductivityIndex(double productivityIndex) {
        this.productivityIndex = productivityIndex;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }

    
}

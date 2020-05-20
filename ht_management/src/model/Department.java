package model;

import java.io.Serializable;
import utils.IdManager;

public class Department implements Serializable{

    private int id;
    private String name;
    private int maximumCapacity;
    private String location;
    private double taxesPercentage;
    private int managerId;

    public Department(String name, int maximumCapacity, String location, double taxesPercentage, int managerId) {
        this.id = IdManager.getInstance().getDepartmentId();
        this.name = name;
        this.maximumCapacity = maximumCapacity;
        this.location = location;
        this.taxesPercentage = taxesPercentage;
        this.managerId = managerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaximumCapacity() {
        return maximumCapacity;
    }

    public void setMaximumCapacity(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public double getTaxesPercentage() {
        return taxesPercentage;
    }

    public void setTaxesPercentage(double taxesPercentage) {
        this.taxesPercentage = taxesPercentage;
    }

    @Override
    public String toString() {
        return this.name + " " + this.location;
    }
    
}

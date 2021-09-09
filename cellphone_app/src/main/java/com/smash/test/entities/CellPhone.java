package com.smash.test.entities;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Entity class to map CellPhone table structure
 */
@Entity
@Table(name = "CellPhone")
public class CellPhone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmployeeId")
    private Long employeeId;

    @Column(name = "EmployeeName")
    private String employeeName;

    @Column(name = "PurchaseDate")
    private LocalDate purchaseDate;

    @Column(name = "Model")
    private String model;

    /**
     * Default constructor
     */
    public CellPhone(){
    }

    /*
    Getters and setters for the attributes
     */

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Overwrite the equals method to make sure comparisons and other operations like distinct work as expected
     * @param other The object to compare
     * @return True if both objects are identical
     */
    @Override
    public boolean equals(Object other){
        if(other != null && other instanceof CellPhone){
            if(this == other){
                return true;
            }
            CellPhone cellPhone = (CellPhone)other;
            if(this.getEmployeeId().equals(cellPhone.getEmployeeId()))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Overwrite default hashCode implementation to be able to use operations like distinct
     * @return The object hash
     */
    @Override
    public int hashCode(){
        // there are multiple ways of returning a hash, this is one suggestion
        return this.getEmployeeId().intValue() + this.getEmployeeName().hashCode() * 33;
    }
}
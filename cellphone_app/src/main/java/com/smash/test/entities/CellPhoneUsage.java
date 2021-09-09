package com.smash.test.entities;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Entity class to map CellPhoneUsage table structure
 */
@Entity
@Table(name = "CellPhoneUsage")
public class CellPhoneUsage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Long id;

    /**
     * Using EAGER intentionally since we will need the CellPhone reference for some stream operations
     * Ideally we should use LAZY to avoid performance issues when entities are huge or not neded, but for this test EAGER will make things easier.
     */
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "EmployeeId")
    private CellPhone cellPhone;

    @Column(name = "Date")
    private LocalDate date;

    @Column(name = "TotalMinutes")
    private Long totalMinutes;

    @Column(name = "TotalData")
    private double totalData;

    /**
     * Default constructor
     */
    public CellPhoneUsage(){

    }

    /*
    Getters and setters for the attributes
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CellPhone getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(CellPhone cellPhone) {
        this.cellPhone = cellPhone;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getTotalMinutes() {
        return totalMinutes;
    }

    public void setTotalMinutes(Long totalMinutes) {
        this.totalMinutes = totalMinutes;
    }

    public double getTotalData() {
        return totalData;
    }

    public void setTotalData(double totalData) {
        this.totalData = totalData;
    }

    /**
     * Overwrite the equals method to make sure comparisons and other operations like distinct work as expected
     * @param other The object to compare
     * @return True if both objects are identical
     */
    @Override
    public boolean equals(Object other){
        if(other != null && other instanceof CellPhoneUsage){
            if(this == other){
                return true;
            }
            CellPhoneUsage cellPhoneUsage = (CellPhoneUsage)other;
            if(this.getId().equals(cellPhoneUsage.getId()))
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
        return this.getId().intValue() + this.getCellPhone().hashCode() * 33;
    }
}

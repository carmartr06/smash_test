package com.smash.test.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "CellPhoneUsage")
public class CellPhoneUsage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Long id;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeId")
    private CellPhone cellPhone;

    @Column(name = "Date")
    private LocalDate date;

    @Column(name = "TotalMinutes")
    private Long totalMinutes;

    @Column(name = "TotalData")
    private double totalData;

    public CellPhoneUsage(){

    }

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

    @Override
    public int hashCode(){
        return this.getId().intValue() + this.getCellPhone().hashCode() * 33;
    }
}

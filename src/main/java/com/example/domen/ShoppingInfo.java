package com.example.domen;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class ShoppingInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private Long custId;
    @NotNull
    private Date date;
    @NotNull
    private Long debt;
    @NotNull
    private boolean status;

    public ShoppingInfo() {
    }

    public ShoppingInfo(Long custId, Date date, Long debt,boolean status) {
        this.custId = custId;
        this.date = date;
        this.debt = debt;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Customer cust) {
        this.custId = cust.getId();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getDebt() {
        return debt;
    }

    public void setDebt(Long debt) {
        this.debt = debt;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

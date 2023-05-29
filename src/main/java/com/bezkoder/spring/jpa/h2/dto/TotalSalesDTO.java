package com.bezkoder.spring.jpa.h2.dto;

public class TotalSalesDTO {
    private int month;
    private Double totalRevenue;

    public TotalSalesDTO(int month, Double totalRevenue) {
        this.month = month;
        this.totalRevenue = totalRevenue;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public Double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(Double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}

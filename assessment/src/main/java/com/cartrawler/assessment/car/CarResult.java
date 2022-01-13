package com.cartrawler.assessment.car;

public class CarResult {

    private final String description;
    private final String supplierName;
    private final String sippCode;
    private final double rentalCost;
    private final FuelPolicy fuelPolicy;

    public enum FuelPolicy {
        FULLFULL,
        FULLEMPTY
    };

    public CarResult(String description, String supplierName, String sipp, double cost, FuelPolicy fuelPolicy) {
        this.description = description;
        this.supplierName = supplierName;
        this.sippCode = sipp;
        this.rentalCost = cost;
        this.fuelPolicy = fuelPolicy;
    }

    public String getDescription() {
        return this.description;
    }

    public String getSupplierName() {
        return this.supplierName;
    }

    public String getSippCode() {
        return this.sippCode;
    }

    public double getRentalCost() {
        return this.rentalCost;
    }

    public FuelPolicy getFuelPolicy() {
        return this.fuelPolicy;
    }

    @Override
    public String toString() {
        return this.supplierName + " : "
                + this.description + " : "
                + this.sippCode + " : "
                + this.rentalCost + " : "
                + this.fuelPolicy;
    }

    //I did override hashCode and equals methos so the Set will remove the 
    // dupuplications whithout the need of extra logic to do it.
    @Override
    public int hashCode() {
        return (this.supplierName.hashCode()
                + this.description.hashCode()
                + this.fuelPolicy.hashCode()
                + this.sippCode.hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CarResult) {
            CarResult carCompared = (CarResult) obj;
            if (this.supplierName.equals(carCompared.getSupplierName())
                    && this.description.equals(carCompared.getDescription())
                    && this.fuelPolicy.equals(carCompared.getFuelPolicy())
                    && this.sippCode.equals(carCompared.getSippCode())) {
                return true;
            }
        }
        return false;
    }
}

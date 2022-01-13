package com.cartrawler.assessment.car;

import java.util.List;
import java.util.stream.Collectors;

public class CarService {

    public static double findMedianByFuelPolicy(List<CarResult> carsList,
            CarResult.FuelPolicy fuelPolicy, List<String> suppliers) {
        List<CarResult> resultList = carsList.stream()
                .filter(car -> suppliers.contains(car.getSupplierName()))
                .filter(car -> car.getFuelPolicy().equals(fuelPolicy))
                .collect(Collectors.toList());

        return resultList.stream()
                .mapToDouble(car -> car.getRentalCost())
                .sorted()
                .skip((resultList.size() - 1) / 2)
                .limit(2 - resultList.size() % 2)
                .average()
                .orElse(Double.NaN);
    }

    public static void removeCarAboveMedianByFuelPolicy(List<CarResult> carsList,
            CarResult.FuelPolicy fuelPolicy, double median, List<String> suppliers) {
        carsList.removeAll(carsList.stream()
                .filter(car -> suppliers.contains(car.getSupplierName()))
                .filter(car -> car.getFuelPolicy().equals(fuelPolicy))
                .filter(car -> car.getRentalCost() > median)
                .collect(Collectors.toList()));
    }
}

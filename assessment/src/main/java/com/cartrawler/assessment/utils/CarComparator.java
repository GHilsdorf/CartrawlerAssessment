package com.cartrawler.assessment.utils;

import com.cartrawler.assessment.car.CarResult;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CarComparator implements Comparator<CarResult> {

    public static List<String> CORPORATE_CARS = Arrays.asList("AVIS", "BUDGET", "ENTERPRISE",
            "FIREFLY", "HERTZ", "SIXT", "THRIFTY");
    public static List<String> NON_CORPORATE_CARS = Arrays.asList("FLIZZR", "RHODIUM", "DELPASO",
            "RECORD", "MARBESOL", "GOLDCAR", "CENTAURO", "NIZA");
    public static List<String> SIPP_CODES = Arrays.asList("M", "E", "C");

    @Override
    public int compare(CarResult c1, CarResult c2) {

        //Both cars are corporate.
        if (CORPORATE_CARS.contains(c1.getSupplierName())
                && CORPORATE_CARS.contains(c2.getSupplierName())) {

            //Order defined by sipp code between corporate cars.
            if (0 == compareBySipp(c1.getSippCode(), c2.getSippCode())) {
                //Order by price if sipp value is the same.
                return Double.compare(c1.getRentalCost(), c2.getRentalCost());
            } else {
                return compareBySipp(c1.getSippCode(), c2.getSippCode());
            }

        } else if (CORPORATE_CARS.contains(c1.getSupplierName())
                && !CORPORATE_CARS.contains(c2.getSupplierName())) {
            //Only first Car is corporate.
            return -1;
        } else if (!CORPORATE_CARS.contains(c1.getSupplierName())
                && CORPORATE_CARS.contains(c2.getSupplierName())) {
            //Only second car is corporate.
            return 1;
        } else {
            //Order defined by sipp code between no corporate cars.
            if (0 == compareBySipp(c1.getSippCode(), c2.getSippCode())) {
                //Order by price if sipp value is the same.
                return Double.compare(c1.getRentalCost(), c2.getRentalCost());
            } else {
                return compareBySipp(c1.getSippCode(), c2.getSippCode());
            }

        }
    }

    private int compareBySipp(String sipp1, String sipp2) {
        //Both sippCodes starts with M,E or C.
        if (SIPP_CODES.contains(sipp1.substring(0, 1)) && SIPP_CODES.contains(sipp2.substring(0, 1))) {
            return Integer.valueOf(SIPP_CODES.indexOf(sipp1.substring(0, 1)))
                    .compareTo(SIPP_CODES.indexOf(sipp2.substring(0, 1)));
        } else if (SIPP_CODES.contains(sipp1.substring(0, 1)) && !SIPP_CODES.contains(sipp2.substring(0, 1))) {
            //First sippCode starts with M,E or C.
            return -1;
        } else if (!SIPP_CODES.contains(sipp1.substring(0, 1)) && SIPP_CODES.contains(sipp2.substring(0, 1))) {
            //Second sippCode starts with M,E or C.
            return 1;
        } else {
            //No sippCode starts with M,E or C. I ordered they by alphabetical order,
            // but if they should not be ordered this return needs to be 0.
            return sipp1.compareTo(sipp2);
        }
    }
}

package com.cartrawler.assessment.car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

public class CarServiceTest {

    List<String> allTestSuppliers = Arrays.asList("NIZA", "CENTAURO", "MARBESOL");
    List<String> singleTestSupplier = Arrays.asList("NIZA");
    List<String> mixedTestSuppliers = Arrays.asList("CENTAURO", "MARBESOL");

    @Test
    public void testFindMedianByFuelPolicyEven() {

        // <editor-fold defaultstate="collapsed" desc=" Scenario preparation. ">
        List<CarResult> testList = new ArrayList<>();
        testList.add(new CarResult("Volkswagen Polo", "NIZA", "EDMR", 12.81d, CarResult.FuelPolicy.FULLEMPTY));
        testList.add(new CarResult("Ford C-Max Diesel", "NIZA", "CMMD", 22.04d, CarResult.FuelPolicy.FULLEMPTY));
        testList.add(new CarResult("BMW 2 Series Gran Tourer Diesel", "NIZA", "JVAD", 146.62d, CarResult.FuelPolicy.FULLFULL));
        testList.add(new CarResult("Volkswagen Golf", "CENTAURO", "CDMR", 58.77d, CarResult.FuelPolicy.FULLFULL));
        testList.add(new CarResult("Ford C-Max Diesel", "CENTAURO", "CMMD", 102.27d, CarResult.FuelPolicy.FULLFULL));
        testList.add(new CarResult("Ford Galaxy", "MARBESOL", "FVMR", 45.07d, CarResult.FuelPolicy.FULLEMPTY));
        testList.add(new CarResult("Citroen Berlingo", "MARBESOL", "CMMV", 78.06d, CarResult.FuelPolicy.FULLFULL));
        //</editor-fold>

        assertEquals(90.165, CarService.findMedianByFuelPolicy(testList, CarResult.FuelPolicy.FULLFULL, allTestSuppliers), 0.01);
    }

    @Test
    public void testFindMedianByFuelPolicyOdd() {

        // <editor-fold defaultstate="collapsed" desc=" Scenario preparation. ">
        List<CarResult> testList = new ArrayList<>();
        testList.add(new CarResult("Volkswagen Polo", "NIZA", "EDMR", 12.81d, CarResult.FuelPolicy.FULLEMPTY));
        testList.add(new CarResult("Ford C-Max Diesel", "NIZA", "CMMD", 22.04d, CarResult.FuelPolicy.FULLEMPTY));
        testList.add(new CarResult("Volkswagen Golf", "CENTAURO", "CDMR", 58.77d, CarResult.FuelPolicy.FULLFULL));
        testList.add(new CarResult("Ford C-Max Diesel", "CENTAURO", "CMMD", 102.27d, CarResult.FuelPolicy.FULLFULL));
        testList.add(new CarResult("Ford Galaxy", "MARBESOL", "FVMR", 45.07d, CarResult.FuelPolicy.FULLEMPTY));
        testList.add(new CarResult("Citroen Berlingo", "MARBESOL", "CMMV", 78.06d, CarResult.FuelPolicy.FULLFULL));
        //</editor-fold>

        assertEquals(78.06, CarService.findMedianByFuelPolicy(testList, CarResult.FuelPolicy.FULLFULL, allTestSuppliers), 0.01);
    }

    @Test
    public void testRemoveCarAboveMedianByFuelPolicy() {

        // <editor-fold defaultstate="collapsed" desc=" Scenario preparation. ">
        List<CarResult> testList = new ArrayList<>();
        testList.add(new CarResult("Volkswagen Polo", "NIZA", "EDMR", 12.81d, CarResult.FuelPolicy.FULLEMPTY));
        testList.add(new CarResult("Ford C-Max Diesel", "NIZA", "CMMD", 22.04d, CarResult.FuelPolicy.FULLEMPTY));
        testList.add(new CarResult("Volkswagen Golf", "CENTAURO", "CDMR", 58.77d, CarResult.FuelPolicy.FULLFULL));
        testList.add(new CarResult("Ford C-Max Diesel", "CENTAURO", "CMMD", 102.27d, CarResult.FuelPolicy.FULLFULL));
        testList.add(new CarResult("Ford Galaxy", "MARBESOL", "FVMR", 45.07d, CarResult.FuelPolicy.FULLEMPTY));
        testList.add(new CarResult("Citroen Berlingo", "MARBESOL", "CMMV", 78.06d, CarResult.FuelPolicy.FULLFULL));
        //</editor-fold>

        // <editor-fold defaultstate="collapsed" desc=" Expected results. ">
        List<CarResult> expectedList = new ArrayList<>();
        expectedList.add(new CarResult("Volkswagen Polo", "NIZA", "EDMR", 12.81d, CarResult.FuelPolicy.FULLEMPTY));
        expectedList.add(new CarResult("Ford C-Max Diesel", "NIZA", "CMMD", 22.04d, CarResult.FuelPolicy.FULLEMPTY));
        expectedList.add(new CarResult("Volkswagen Golf", "CENTAURO", "CDMR", 58.77d, CarResult.FuelPolicy.FULLFULL));
        expectedList.add(new CarResult("Ford Galaxy", "MARBESOL", "FVMR", 45.07d, CarResult.FuelPolicy.FULLEMPTY));
        expectedList.add(new CarResult("Citroen Berlingo", "MARBESOL", "CMMV", 78.06d, CarResult.FuelPolicy.FULLFULL));
        //</editor-fold>

        double median = CarService.findMedianByFuelPolicy(testList, CarResult.FuelPolicy.FULLFULL, allTestSuppliers);
        CarService.removeCarAboveMedianByFuelPolicy(testList, CarResult.FuelPolicy.FULLFULL, median, allTestSuppliers);

        assertThat(expectedList, is(testList));
    }

    @Test
    public void testRemoveCarAboveMedianBySupplier() {

        // <editor-fold defaultstate="collapsed" desc=" Scenario preparation. ">
        List<CarResult> testList = new ArrayList<>();
        testList.add(new CarResult("Volkswagen Polo", "NIZA", "EDMR", 12.81d, CarResult.FuelPolicy.FULLFULL));
        testList.add(new CarResult("Ford C-Max Diesel", "NIZA", "CMMD", 22.04d, CarResult.FuelPolicy.FULLFULL));
        testList.add(new CarResult("Volkswagen Touran Diesel", "NIZA", "IVMD", 77.41d, CarResult.FuelPolicy.FULLFULL));
        testList.add(new CarResult("Volkswagen Golf", "CENTAURO", "CDMR", 58.77d, CarResult.FuelPolicy.FULLFULL));
        testList.add(new CarResult("Ford C-Max Diesel", "CENTAURO", "CMMD", 102.27d, CarResult.FuelPolicy.FULLFULL));
        testList.add(new CarResult("Ford Galaxy", "MARBESOL", "FVMR", 45.07d, CarResult.FuelPolicy.FULLFULL));
        //</editor-fold>

        // <editor-fold defaultstate="collapsed" desc=" Expected results. ">
        List<CarResult> expectedList = new ArrayList<>();
        expectedList.add(new CarResult("Volkswagen Polo", "NIZA", "EDMR", 12.81d, CarResult.FuelPolicy.FULLFULL));
        expectedList.add(new CarResult("Ford C-Max Diesel", "NIZA", "CMMD", 22.04d, CarResult.FuelPolicy.FULLFULL));
        expectedList.add(new CarResult("Volkswagen Golf", "CENTAURO", "CDMR", 58.77d, CarResult.FuelPolicy.FULLFULL));
        expectedList.add(new CarResult("Ford Galaxy", "MARBESOL", "FVMR", 45.07d, CarResult.FuelPolicy.FULLFULL));
        //</editor-fold>

        double medianSingleSupplier = CarService.findMedianByFuelPolicy(testList, CarResult.FuelPolicy.FULLFULL, singleTestSupplier);
        CarService.removeCarAboveMedianByFuelPolicy(testList, CarResult.FuelPolicy.FULLFULL, medianSingleSupplier, singleTestSupplier);

        double medianMixedSuppliers = CarService.findMedianByFuelPolicy(testList, CarResult.FuelPolicy.FULLFULL, mixedTestSuppliers);
        CarService.removeCarAboveMedianByFuelPolicy(testList, CarResult.FuelPolicy.FULLFULL, medianMixedSuppliers, mixedTestSuppliers);

        assertThat(expectedList, is(testList));
    }
}

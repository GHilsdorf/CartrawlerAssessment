package com.cartrawler.assessment.utils;

import com.cartrawler.assessment.car.CarResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

public class CarComparatorTest {

    @Test
    public void testSortUsingCompare() {

        // <editor-fold defaultstate="collapsed" desc=" Scenario preparation. ">
        List<CarResult> testList = new ArrayList<>();
        testList.add(new CarResult("Ford C-Max Diesel", "CENTAURO", "CMMD", 102.27d, CarResult.FuelPolicy.FULLFULL));
        testList.add(new CarResult("Citroen Berlingo", "MARBESOL", "CMMV", 78.06d, CarResult.FuelPolicy.FULLFULL));
        testList.add(new CarResult("Mercedes Viano", "AVIS", "OVAR", 572.44d, CarResult.FuelPolicy.FULLFULL));
        testList.add(new CarResult("Ford Focus Estate", "AVIS", "CWMR", 291.28d, CarResult.FuelPolicy.FULLFULL));
        testList.add(new CarResult("Volkswagen Golf", "BUDGET", "CDMR", 268.97d, CarResult.FuelPolicy.FULLFULL));
        //</editor-fold>

        // <editor-fold defaultstate="collapsed" desc=" Expected results. ">
        List<CarResult> expectedList = new ArrayList<>();
        expectedList.add(new CarResult("Volkswagen Golf", "BUDGET", "CDMR", 268.97d, CarResult.FuelPolicy.FULLFULL));
        expectedList.add(new CarResult("Ford Focus Estate", "AVIS", "CWMR", 291.28d, CarResult.FuelPolicy.FULLFULL));
        expectedList.add(new CarResult("Mercedes Viano", "AVIS", "OVAR", 572.44d, CarResult.FuelPolicy.FULLFULL));
        expectedList.add(new CarResult("Citroen Berlingo", "MARBESOL", "CMMV", 78.06d, CarResult.FuelPolicy.FULLFULL));
        expectedList.add(new CarResult("Ford C-Max Diesel", "CENTAURO", "CMMD", 102.27d, CarResult.FuelPolicy.FULLFULL));
        //</editor-fold>

        Collections.sort(testList, new CarComparator());

        assertThat(expectedList, is(testList));
    }
}

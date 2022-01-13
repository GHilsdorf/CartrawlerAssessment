package com.cartrawler.assessment.view;

import com.cartrawler.assessment.car.CarResult;
import java.util.List;

public class Display {

    //I changed the Set to List because Set does not keep the elements sequence.
    public void render(List<CarResult> cars) {
        cars.forEach((car) -> {
            System.out.println(car);
        });
    }
}

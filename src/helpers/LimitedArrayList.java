package helpers;

import java.util.ArrayList;

public class LimitedArrayList<Car> extends ArrayList<Car>  {
    @Override
    public boolean add(Car e) {
        if (this.size() < 10) {
            return super.add(e);
        }
throw new IllegalArgumentException(
        "Es dürfen sich maximal 10 Autos in der Warteschlange befinden");    }
}
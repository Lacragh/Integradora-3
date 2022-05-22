import model.*;
import model.Controller;

public class init {

    public init(Controller controller) {

        Electric vehicle1 = new Electric(2, 2, "2021", "Tesla", 21, 1, 1, "9XL9043", 1, true, 1, 1, 21);

        controller.vehicle.add(vehicle1);
        controller.garage.addVehicle(vehicle1);

        Fuel vehicle2 = new Fuel(10000, 0.02, "2003", "Mazda", 200, 100, 1, "SEX980", true, 1, 2, 100, 2);

        controller.vehicle.add(vehicle2);
        controller.garage.addVehicle(vehicle2);

        Motocycle vehicle3 = new Motocycle(200, 1, "2008", "Kawasaki Ninja", 200, 21, 2, "LXS2", 2, 100);
        controller.vehicle.add(vehicle3);
        controller.garage.addVehicle(vehicle3);
    }

}
package model;

public abstract class Automobile extends Vehicles {
    private boolean windowsblack;
    private int numDoors;
    private TypeCar type;

    public Automobile(double basePrice, double discount, String model, String brand, double cylinder, double mileage,
            int gradeQuality, String licensePlate, boolean windowsblack,
            int numDoors, int type) {
        super(basePrice, discount, model, brand, cylinder, mileage, gradeQuality, licensePlate);
        this.setWindowsblack(windowsblack);
        this.setNumDoors(numDoors);
        switch (type) {
            case 1:
                this.setType(TypeCar.SEDAN);
                break;
            case 2:
                this.setType(TypeCar.PICK_UP_TRUCK);
                break;
        }
    }

    public TypeCar getType() {
        return type;
    }

    public void setType(TypeCar type) {
        this.type = type;
    }

    public int getNumDoors() {
        return numDoors;
    }

    public void setNumDoors(int numDoors) {
        this.numDoors = numDoors;
    }

    public boolean isWindowsblack() {
        return windowsblack;
    }

    public void setWindowsblack(boolean windowsblack) {
        this.windowsblack = windowsblack;
    }

}

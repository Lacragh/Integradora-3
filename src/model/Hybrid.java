package model;

public class Hybrid extends Automobile implements ConsumptionFuel, CalculateConsumptionElectric {

    private double capacityTank;
    private TYPEFUEL typefuel;

    private TYPELECTRIC typelectric;
    private double batteryDuration;

    public Hybrid(double basePrice, double discount, String model, String brand, double cylinder, double mileage,
            int gradeQuality, String licensePlate, boolean windowsblack,
            int numDoors, int type, double capacityTank, int typefuel, int typelectric, double batteryDuration) {
        super(basePrice, discount, model, brand, cylinder, mileage, gradeQuality, licensePlate, windowsblack,
                numDoors, type);

        this.capacityTank = capacityTank;
        switch (typefuel) {
            case 1:
                this.setTypefuel(TYPEFUEL.EXTRA);
                break;
            case 2:
                this.setTypefuel(TYPEFUEL.CORRIENTE);
                break;
            case 3:
                this.setTypefuel(TYPEFUEL.DIESEL);
                break;
        }
        switch (typelectric) {
            case 1:
                this.setTypelectric(TYPELECTRIC.FAST);
                break;
            case 2:
                this.setTypelectric(TYPELECTRIC.NORMAL);
                break;
        }
        this.batteryDuration = batteryDuration;

    }

    public double getBatteryDuration() {
        return batteryDuration;
    }

    public void setBatteryDuration(double batteryDuration) {
        this.batteryDuration = batteryDuration;
    }

    public TYPELECTRIC getTypelectric() {
        return typelectric;
    }

    public void setTypelectric(TYPELECTRIC typelectric) {
        this.typelectric = typelectric;
    }

    public TYPEFUEL getTypefuel() {
        return typefuel;
    }

    public void setTypefuel(TYPEFUEL typefuel) {
        this.typefuel = typefuel;
    }

    public double getCapacityTank() {
        return capacityTank;
    }

    public void setCapacityTank(double capacityTank) {
        this.capacityTank = capacityTank;
    }

    @Override
    public double calculateConsumptionFuel() {
        double consumption = 0;

        if (typelectric.equals(TYPELECTRIC.FAST)) {
            consumption = batteryDuration * (getCylinder() / 200);
        }

        if (typelectric.equals(TYPELECTRIC.NORMAL)) {
            consumption = (batteryDuration + 7) * (getCylinder() / 200);
        }

        return consumption;
    }

     /**
	 * <pre>
	 * <strong>Descripción del metodo </strong> El metodo calculateConsumptionElectric  me calcula el consumo de la bateria.
     * 
	 * 
	 * <strong>Inputs:</strong><strong>
	 * Outputs:</strong> me retorna un double
	 * </pre>
	 */

    @Override
    public double calculateConsumptionElectric() {

        double consumption = 0;
        if (typelectric.equals(TYPELECTRIC.FAST)) {
            consumption = (batteryDuration * (getCylinder() / 200));
        }

        if (typelectric.equals(TYPELECTRIC.NORMAL)) {
            consumption = (batteryDuration * (getCylinder() / 200));
        }

        return consumption;
    }

     /**
	 * <pre>
	 * <strong>Descripción del metodo </strong> El metodo calculateprice me calcula el precio de venta del vehiculo
     * 
	 * 
	 * <strong>Inputs:</strong> <strong>
	 * Outputs:</strong> me retorna un double.
	 * </pre>
	 */

    @Override
    public double calculatePrice() {
        double price = getBasePrice();
        boolean stopFlag = true;
        if (getDocuments().isEmpty()) {
            price += aditional;
        } else {
            for (int i = 0; i < this.getDocuments().size() | !stopFlag; i++) {
                if (this.getDocuments().get(i).getDate() < 2022) {
                    price += aditional;
                    stopFlag = true;
                }

            }
        }

        if (getGradeQuality().equals(State.USED)) {
            price -= (getBasePrice() * 0.1);
        }

        price += (getBasePrice() * 0.15);
        price -= (getBasePrice() * getDiscount());

        return price;

    }

    @Override
    public String toString() {
        return "\nBrand : " + getBrand() + "\nModel: " + getModel() + "\n State: " + getGradeQuality() + "\nPlate: "
                + getLicensePlate() + "\nSelling Price: " + calculatePrice() + "\nConsumption Fuel: "
                + calculateConsumptionFuel() + "\n Consumption Battery: " + calculateConsumptionElectric();
    }

}

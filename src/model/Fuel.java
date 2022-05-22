package model;

public class Fuel extends Automobile implements ConsumptionFuel {
    private double capacityTank;
    private TYPEFUEL typefuel;

    public Fuel(double basePrice, double discount, String model, String brand, double cylinder, double mileage,
            int gradeQuality, String licensePlate, boolean windowsblack,
            int numDoors, int type, double capacityTank, int typefuel) {
        super(basePrice, discount, model, brand, cylinder, mileage, gradeQuality, licensePlate, windowsblack, numDoors,
                type);
        this.setCapacityTank(capacityTank);
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

    }

    public TYPEFUEL getTypefuel() {
        return this.typefuel;
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

        consumption = getCapacityTank() * (getCylinder() / 150);

        return consumption;
    }

     /**
	 * <pre>
	 * <strong>Descripción del metodo </strong> El metodo calculatePrice me calcula el precio del vehiculo 
     * 
	 * 
	 * <strong>Inputs:</strong> <strong>
	 * Outputs:</strong> me retorna un double
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

        price -= (price * getDiscount());

        return price;
    }

    @Override
    public String toString() {
        return "\nBrand : " + getBrand() + "\nModel: " + getModel() + "\n State: " + getGradeQuality() + "\nPlate: "
                + getLicensePlate() + "\nSelling Price: " + calculatePrice() + "\nConsumption Fuel: "
                + calculateConsumptionFuel();
    }

}

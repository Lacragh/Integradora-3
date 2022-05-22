package model;

public class Electric extends Automobile implements CalculateConsumptionElectric {
    private TYPELECTRIC typelectric;
    private double batteryDuration;

    public Electric(double basePrice, double discount, String model, String brand, double cylinder, double mileage,
            int gradeQuality, String licensePlate, int type, boolean windowsblack, int numDoors, int typelectric,
            double batteryDuration) {
        super(basePrice, discount, model, brand, cylinder, mileage, gradeQuality, licensePlate, windowsblack, numDoors,
                type);

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

    @Override
    public double calculateConsumptionElectric() {

        double consumption = 0;
        if (typelectric.equals(TYPELECTRIC.FAST)) {
            consumption = (batteryDuration + 13) * (getCylinder() / 100);
        }

        if (typelectric.equals(TYPELECTRIC.NORMAL)) {
            consumption = (batteryDuration + 18) * (getCylinder() / 100);
        }

        return consumption;
    }

     /**
	 * <pre>
	 * <strong>Descripción del metodo </strong> El metodo calculatePrice me permite calcular el precio de venta del vehiculo
     * 
	 * 
	 * <strong>Inputs:</strong> <strong>
	 * Outputs:</strong> me retorna un double
	 * </pre>
	 */

    @Override
    public double calculatePrice() {
        double price = getBasePrice();
        boolean stopFlag = false;
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

        price += (getBasePrice() * 0.20);
        if (getGradeQuality().equals(State.USED)) {
            price -= (getBasePrice() * 0.1);
        }

        price -= (price * getDiscount());

        return price;
    }

    @Override
    public String toString() {
        return "\nBrand : " + getBrand() + "\nModel: " + getModel() + "\n State: " + getGradeQuality() + "\nPlate: "
                + getLicensePlate() + "\nSelling Price: " + calculatePrice() + "\nConsumption Battery: "
                + calculateConsumptionElectric();
    }

}

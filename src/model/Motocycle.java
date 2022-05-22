package model;

public class Motocycle extends Vehicles implements ConsumptionFuel,CalculatePrice {
    private TYPEMOTO typemoto;
    private double capacityTank;

    public Motocycle(double basePrice, double discount, String model, String brand, double cylinder, double mileage,
            int gradeQuality, String licensePlate, int typemoto, double capacityTank) {
        super(basePrice, discount, model, brand, cylinder, mileage, gradeQuality, licensePlate);
        switch (typemoto) {
            case 1:
                this.setTypemoto(TYPEMOTO.STANDAR);
                break;
            case 2:
                this.setTypemoto(TYPEMOTO.SPORT);
                break;
            case 3:
                this.setTypemoto(TYPEMOTO.SCOOTER);
                break;
            case 4:
                this.setTypemoto(TYPEMOTO.CROSS);
                break;
        }
        this.capacityTank = capacityTank;
    }

    public double getCapacityTank() {
        return capacityTank;
    }

    public void setCapacityTank(double capacityTank) {
        this.capacityTank = capacityTank;
    }

    public TYPEMOTO getTypemoto() {
        return typemoto;
    }

    public void setTypemoto(TYPEMOTO typemoto) {
        this.typemoto = typemoto;
    }

     /**
	 * <pre>
	 * <strong>Descripción del metodo </strong> El metodo calculate consumptionFuel me calcula el consumo de gasolina
     * 
	 * 
	 * <strong>Inputs:</strong><strong>
	 * Outputs:</strong> me retorna un double
	 * </pre>
	 */

    @Override
    public double calculateConsumptionFuel() {
        double consumption = 0;

        consumption = getCapacityTank() * (getCylinder() / 75);

        return consumption;
    }

    @Override
    public double calculatePrice(){
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
            price -= (getBasePrice() * 0.02);
        }
        price += getBasePrice()*0.04;
        price += (price * getDiscount());

        return price;
    }

    @Override
    public String toString() {
        return "\nBrand : " + getBrand() + "\nModel: " + getModel() + "\nState: " + getGradeQuality() + "\nPlate: "
                + getLicensePlate() + "\nSelling Price: " + calculatePrice() + "\nConsumption Fuel: "
                + calculateConsumptionFuel();
    }
}

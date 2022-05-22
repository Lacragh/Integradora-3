package model;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.text.Position;

public class Controller {

    public ArrayList<Vehicles> vehicle;
    public Garage garage;

    public Controller() {
        vehicle = new ArrayList<>();
        garage = new Garage();
    }

     /**
	 * <pre>
	 * <strong>Descripción del metodo </strong> El metodo registerFuel me permite crear un vehiculo de tipo fuel
     * 
	 * 
	 * <strong>Inputs:</strong>double basePrice, double discount, String model, String brand, double cylinder,
            double mileage, int gradeQuality, String licensePlate, boolean windowsblack, int numDoors, int type,
            double capacityTank, int typefuel <strong>
	 * Outputs:</strong> me retorna un booleano que puede ser verdadero o falso dependiendo si me dejo crear el Vehiculo.
	 * </pre>
	 */

    public boolean registerFuel(double basePrice, double discount, String model, String brand, double cylinder,
            double mileage, int gradeQuality, String licensePlate, boolean windowsblack, int numDoors, int type,
            double capacityTank, int typefuel) {
        Fuel fuel = new Fuel(basePrice, discount, model, brand, cylinder, mileage, gradeQuality, licensePlate,
                windowsblack, numDoors, type, capacityTank, typefuel);
        garage.addVehicle(fuel);
        return vehicle.add(new Fuel(basePrice, discount, model, brand, cylinder, mileage, gradeQuality, licensePlate,
                windowsblack, numDoors, type, capacityTank, typefuel));
    }

    /**
	 * <pre>
	 * <strong>Descripción del metodo </strong> El metodo registerElectric me permite crear un vehiculo de tipo Electrico
     * 
	 * 
	 * <strong>Inputs:</strong>double basePrice, double discount, String model, String brand, double cylinder, double mileage,
            int gradeQuality, String licensePlate, boolean windowsblack,
            int numDoors, int type, int typelectric, double batteryDuration <strong>
	 * Outputs:</strong> me retorna un booleano que puede ser verdadero o falso dependiendo si me dejo crear el Vehiculo.
	 * </pre>
	 */
    
    public boolean registerElectric(double basePrice, double discount, String model, String brand, double cylinder,
            double mileage,
            int gradeQuality, String licensePlate, boolean windowsblack,
            int numDoors, int type, int typelectric, double batteryDuration) {
        Electric electric = new Electric(basePrice, discount, model, brand, cylinder, mileage, gradeQuality,
                licensePlate, type, windowsblack, numDoors, typelectric, batteryDuration);
        garage.addVehicle(electric);
        return vehicle.add(new Electric(basePrice, discount, model, brand, cylinder, mileage, gradeQuality,
                licensePlate, type, windowsblack, numDoors, typelectric, batteryDuration));
    }

    /**
	 * <pre>
	 * <strong>Descripción del metodo </strong> El metodo registerHybrid me permite crear un vehiculo de tipo Hibrido
     * 
	 * 
	 * <strong>Inputs:</strong>double basePrice, double discount, String model, String brand, double cylinder,
            double mileage,
            int gradeQuality, String licensePlate, boolean windowsblack,
            int numDoors, int type, double capacityTank, int typefuel, int typelectric, double batteryDuration <strong>
	 * Outputs:</strong> me retorna un booleano que puede ser verdadero o falso dependiendo si me dejo crear el Vehiculo.
	 * </pre>
	 */

    public boolean registerHybrid(double basePrice, double discount, String model, String brand, double cylinder,
            double mileage,
            int gradeQuality, String licensePlate, boolean windowsblack,
            int numDoors, int type, double capacityTank, int typefuel, int typelectric, double batteryDuration) {

        Hybrid hybrid = new Hybrid(basePrice, discount, model, brand, cylinder, mileage, gradeQuality, licensePlate,
                windowsblack, numDoors, type, capacityTank, typefuel, typelectric, batteryDuration);
        garage.addVehicle(hybrid);
        return vehicle.add(new Hybrid(basePrice, discount, model, brand, cylinder, mileage, gradeQuality, licensePlate,
                windowsblack, numDoors, type, capacityTank, typefuel, typelectric,
                batteryDuration));

    }

      /**
	 * <pre>
	 * <strong>Descripción del metodo </strong> El metodo registerMoto me permite crear un objeto Motocycle
     * 
	 * 
	 * <strong>Inputs:</strong>ouble basePrice, double discount, String model, String brand, double cylinder,
            double mileage,
            int gradeQuality, String licensePlate, int typemoto, double capacityTank <strong>
	 * Outputs:</strong> me retorna un booleano que puede ser verdadero o falso dependiendo si me dejo crear el Vehiculo.
	 * </pre>
	 */

    public boolean registerMoto(double basePrice, double discount, String model, String brand, double cylinder,
            double mileage,
            int gradeQuality, String licensePlate, int typemoto, double capacityTank) {

        Motocycle motocycle = new Motocycle(basePrice, discount, model, brand, cylinder, mileage, gradeQuality,
                licensePlate, typemoto, capacityTank);
        garage.addVehicle(motocycle);
        return vehicle.add(motocycle);
    }

       /**
	 * <pre>
	 * <strong>Descripción del metodo </strong> El metodo showVehiclesList me permite mostrar la lista de vehiculos creados
     * 
	 * 
	 * <strong>Inputs:</strong> <strong>
	 * Outputs:</strong> me retorna un String
	 * </pre>
	 */
    public String showVehiclesList() {

        String msg = "";

        for (int i = 0; i < vehicle.size(); i++) {

            msg += ("\n" + (i + 1) + ". ") + vehicle.get(i).getBrand() + " " + vehicle.get(i).getModel();
        }
        return msg;
    }

     /**
	 * <pre>
	 * <strong>Descripción del metodo </strong> El metodo showParking me permite mostrar el garage
     * 
	 * 
	 * <strong>Inputs:</strong> <strong>
	 * Outputs:</strong> me retorna un String.
	 * </pre>
	 */

    public String showParking() {

        return garage.showParking();
    }

     /**
	 * <pre>
	 * <strong>Descripción del metodo </strong> El metodo addVehiclesGarage me permite agregar carros al garaje
     * 
	 * 
	 * <strong>Inputs:</strong> <strong>
	 * Outputs:</strong> me retorna nada
	 * </pre>
	 */
    public void addVehiclesGarage() {
        for (int i = 0; i < vehicle.size(); i++) {
            garage.addVehicle(vehicle.get(i));

        }
    }

     /**
	 * <pre>
	 * <strong>Descripción del metodo </strong> El metodo registerDocument me permite agregarle los documentos a un vehiculo
     * 
	 * 
	 * <strong>Inputs:</strong>int position, int type, double price, int date, double mountAccidents,
            double levelsGas <strong>
	 * Outputs:</strong> me retorna un booleano que puede ser verdadero o falso dependiendo si me dejo crear el Documento.
	 * </pre>
	 */
    public boolean registerDocument(int position, int type, double price, int date, double mountAccidents,
            double levelsGas) {

        return vehicle.get(position - 1).registerDocument(type, price, date, mountAccidents, levelsGas);
    }

     /**
	 * <pre>
	 * <strong>Descripción del metodo </strong> El metodo showDocumentsInfo me permite ver todos los documentos de un vehiculo
     * 
	 * 
	 * <strong>Inputs:</strong>int position <strong>
	 * Outputs:</strong> me retorna un String
	 * </pre>
	 */
    public String showDocumentsInfo(int position) {
        String msg = "";

        if (vehicle.get(position - 1).showDocumentsInfo().equals("")) {

            msg += "The vehicle does not have any document";
        } else {
            msg += vehicle.get(position - 1).showDocumentsInfo();
        }

        return msg;
    }

     /**
	 * <pre>
	 * <strong>Descripción del metodo </strong> El metodo showDocumentsList me retorna la lista de los documentos de un vehiculo
     * 
	 * 
	 * <strong>Inputs:</strong>int position <strong>
	 * Outputs:</strong> me retorna un String
	 * </pre>
	 */
    public String showDocumentList(int position) {
        return vehicle.get(position - 1).showDocumentList();
    }

     /**
	 * <pre>
	 * <strong>Descripción del metodo </strong> El metodo 
     * 
	 * 
	 * <strong>Inputs:</strong> <strong>
	 * Outputs:</strong> me retorna nada
	 * </pre>
	 */
    public String showSellingPrice(int position) {

        return "The vehicle " + vehicle.get(position - 1).getBrand() + "-" + vehicle.get(position - 1).getModel()
                + ", selling price is " + vehicle.get(position - 1).calculatePrice();
    }

     /**
	 * <pre>
	 * <strong>Descripción del metodo </strong> El metodo imageCar simplemente es para tener una imagen de un carro
     * 
	 * 
	 * <strong>Inputs:</strong> <strong>
	 * Outputs:</strong> me retorna un String :)
	 * </pre>
	 */
    public String imageCar() {
        String msg = "\n";
        msg += "       _______";
        msg += "\n      //  ||\\ \\";
        msg += "\n_____//___||_\\ \\___";
        msg += "\n)  _          _    \\";
        msg += "\n|_/ \\________/ \\___|";
        msg += "\n__\\_/________\\_/_____";

        return msg;
    }

     /**
	 * <pre>
	 * <strong>Descripción del metodo </strong> El metodo imageMoto me permite tener una imagen de una moto 
     * 
	 * 
	 * <strong>Inputs:</strong> <strong>
	 * Outputs:</strong> me retorna un String
	 * </pre>
	 */
    public String imageMoto() {
        String msg = "\n";
        msg += "    )/___";
        msg += "\n __/(___)-----D";
        msg += "\n/ /\\|| \\  /  \\";
        msg += "\n\\__/ ---- \\__/~~~~~";
        msg += "\n- - - - - - - - - - - -";
        return msg;
    }

     /**
	 * <pre>
	 * <strong>Descripción del metodo </strong> El metodo dataVehiclesOld me permite saber cual es el vehiculo mas viejo y nuevo
     * 
	 * 
	 * <strong>Inputs:</strong> <strong>
	 * Outputs:</strong> me retorna un String
	 * </pre>
	 */
    public String dataVehiclesOld() {
        String msg = "";
        Vehicles old = null;
        Vehicles new1 = null;
        int min = 100000000;
        int max = 0;
        for (int i = 0; i < vehicle.size(); i++) {

            if (Integer.parseInt(vehicle.get(i).getModel()) < min) {
                old = vehicle.get(i);
                min = Integer.parseInt(vehicle.get(i).getModel());
            }

            if (Integer.parseInt(vehicle.get(i).getModel()) > max) {
                new1 = vehicle.get(i);
                max = Integer.parseInt(vehicle.get(i).getModel());
            }

            msg = "The older vehicle is:\n" + old.toString() + "\n\nThe newer vehicle is:\n" + new1.toString();

        }

        return msg;
    }

     /**
	 * <pre>
	 * <strong>Descripción del metodo </strong> El metodo garageReportYears me permite saber que carros
     * 
	 * 
	 * <strong>Inputs:</strong> <strong>
	 * Outputs:</strong> me retorna nada
	 * </pre>
	 */
    public String garageReportYears(int old, int new1) {

        String msg = "";
        for (int i = 0; i < vehicle.size(); i++) {
            if (Integer.parseInt(vehicle.get(i).getModel()) >= old
                    && Integer.parseInt(vehicle.get(i).getModel()) <= new1) {
                msg += "\n" + vehicle.get(i).toString();
            }
        }

        return msg;
    }

    public String showOcuppation() {

        return "The percentage of occupancy of the garage is: " + garage.percentage();
    }

     /**
     * <pre>
     * <strong>Descripción del metodo </strong> El metodo allInformationType me muestra la informacion de todos los vehiculos segun su tipo ya sea moto o carro
     * 
     * 
     * <strong>Inputs:</strong> <strong>
     * Outputs:</strong> me retorna un String
     * </pre>
     */

    public String allInformationType() {
        String msg = "";

        for (int i = 0; i < vehicle.size(); i++) {

            if (vehicle.get(i) instanceof Fuel || vehicle.get(i) instanceof Electric
                    || vehicle.get(i) instanceof Hybrid) {
                msg += "\n" + imageCar();
                msg += ("\n" + (i + 1) + ". ") + vehicle.get(i).toString();

            } else if (vehicle.get(i) instanceof Motocycle) {
                msg += "\n" + imageMoto();
                msg += ("\n" + (i + 1) + ". ") + vehicle.get(i).toString();
            }

        }
        return msg;
    }


     /**
     * <pre>
     * <strong>Descripción del metodo </strong> El metodo allInformationState me permite filtrar por calidad de documento y mostrar  
     * 
     * 
     * <strong>Inputs:</strong>nt typeDocoument, double price, int date, double mountAccidents, double levelsGas <strong>
     * Outputs:</strong> me retorna un String
     * </pre>
     */
    public String allInformationState(int state) {
        String msg = "";
        switch (state) {

            case 1:
                for (int i = 0; i < vehicle.size(); i++) {

                    if (vehicle.get(i).getGradeQuality().equals(State.NEW)) {
                        if (vehicle.get(i) instanceof Fuel || vehicle.get(i) instanceof Electric
                                || vehicle.get(i) instanceof Hybrid) {
                            msg += imageCar();
                            msg += vehicle.get(i).toString();
                        } else if (vehicle.get(i) instanceof Motocycle) {
                            msg += imageMoto();
                            msg += vehicle.get(i).toString();
                        }

                    }
                }
                break;

            case 2:
                for (int i = 0; i < vehicle.size(); i++) {
                    if (vehicle.get(i).getGradeQuality().equals(State.USED)) {
                        if (vehicle.get(i) instanceof Fuel || vehicle.get(i) instanceof Electric
                                || vehicle.get(i) instanceof Hybrid) {
                            msg += imageCar();
                            msg += vehicle.get(i).toString();
                        } else if (vehicle.get(i) instanceof Motocycle) {
                            msg += imageMoto();
                            msg += vehicle.get(i).toString();
                        }

                    }
                }
                break;

        }
        return msg;
    }

     /**
     * <pre>
     * <strong>Descripción del metodo </strong> El metodo allInformationFuel me ayuda a filtrar vehiculos por tipo de combustible y mostrarlos 
     * 
     * 
     * <strong>Inputs:</strong>int type <strong>
     * Outputs:</strong> me retorna un String.
     * </pre>
     */
    public String allInformationFuel(int type) {
        String msg = "";
        switch (type) {
            case 1:
                for (int i = 0; i < vehicle.size(); i++) {
                    if (vehicle.get(i) instanceof Fuel) {
                        if (vehicle.get(i).getTypefuel().equals(TYPEFUEL.EXTRA)) {
                            msg += "\n" + imageCar();
                            msg += ("\n" + (i + 1) + ". ") + vehicle.get(i).toString();
                        }
                    }
                }
                break;

            case 2:
                for (int i = 0; i < vehicle.size(); i++) {
                    if (vehicle.get(i) instanceof Fuel) {
                        if (vehicle.get(i).getTypefuel().equals(TYPEFUEL.CORRIENTE)) {
                            msg += "\n" + imageCar();
                            msg += ("\n" + (i + 1) + ". ") + vehicle.get(i).toString();
                        }
                    }
                }

                break;

            case 3:
                for (int i = 0; i < vehicle.size(); i++) {
                    if (vehicle.get(i) instanceof Fuel) {
                        if (vehicle.get(i).getTypefuel().equals(TYPEFUEL.DIESEL)) {
                            msg += "\n" + imageCar();
                            msg += ("\n" + (i + 1) + ". ") + vehicle.get(i).toString();
                        }
                    }
                }
                break;
        }

        return msg;
    }

}

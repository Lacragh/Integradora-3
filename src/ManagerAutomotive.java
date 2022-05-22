import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import javax.xml.stream.events.StartElement;

import model.Controller;

public class ManagerAutomotive {

    private static Scanner reader;
    private static Controller controller;
    private static init examples;

    public static void main(String[] args) throws Exception {

        init();
        menu();
    }

    public static void init() {
        reader = new Scanner(System.in);
        controller = new Controller();
        examples = new init(controller);
    }

    public static void menu() {
        boolean stopMenu = false;
        while (stopMenu == false) {
            System.out.println("|----------------------------------------|");
            System.out.println("|    1. Register a vehicle               |");
            System.out.println("|    2. Register a Vehicle's Document    |");
            System.out.println("|    3. Show a Vehicle's selling price   |");
            System.out.println("|    4. Generate All vehicle's report    |");
            System.out.println("|    5. Show vehicles document status    |");
            System.out.println("|    6. Show Parking Garage's map        |");
            System.out.println("|    7. Generate Parking Garage's report |");
            System.out.println("|    0. Exit                             |");
            System.out.println("|----------------------------------------|");
            System.out.print("Type here---->");
            int menu = reader.nextInt();

            switch (menu) {

                case 1:
                    System.out.println("Type the new vehicle's brand:");
                    reader.nextLine();
                    String brand = reader.nextLine();

                    System.out.println("Type the new vehicle's model");
                    String model = reader.next();

                    System.out.println("Type the new vehicle's base price");
                    double price = reader.nextDouble();

                    System.out.println("Type the new vehicle's additional porcentage discount (i.e.0,2");
                    double discount = reader.nextDouble();

                    System.out.println("Type the new vehicle's cylinders");
                    double cylinder = reader.nextDouble();

                    System.out.println("Type the new vehicle's state\n1. New \n2. Used");
                    int state = reader.nextInt();

                    double kilometerDriven = 0;
                    String plate = "";

                    if (state == 2) {
                        System.out.println("Type the new Vehicle's kilometers driven");
                        kilometerDriven = reader.nextDouble();

                        System.out.println("Type the new Vehicle's plate");
                        plate = reader.next();
                    } else if (state == 1) {
                        kilometerDriven = 0;
                        plate = null;
                    }

                    System.out.println("Type the new vehicle's type\n1. Car\n2. Motorcycle");
                    int typeVehicle = reader.nextInt();

                    if (typeVehicle == 1) {
                        System.out.println("Type the new car's type\n1. Sedan\n2. Pick-up- Truck");
                        int typeCar = reader.nextInt(); // hacer if

                        System.out.println("Type the new car's number of doors");
                        int numDoor = reader.nextInt();

                        System.out.println("Does the new car have tinted windows\n1. Yes\n2. No");
                        int tintedWindows = reader.nextInt();
                        boolean tinted = false;
                        if (tintedWindows == 1) {
                            tinted = true;
                        }

                        System.out
                                .println("Type the new Car's subtype\n1. Electric Car\n2. Hybrid car\n3 Gasoline car");
                        int subtype = reader.nextInt();

                        if (subtype == 1) {

                            System.out.println("Type the new Car's charger type\n1. Fast\n2. Regular");
                            int chargertype = reader.nextInt();

                            System.out.println("Type the new Electric Car's battery duration (watts)");
                            double watts = reader.nextDouble();

                            if (controller.registerElectric(price, discount, model, brand, cylinder, kilometerDriven,
                                    state, plate, tinted, typeCar, numDoor, chargertype, watts)) {
                                System.out.println("The electric car is registered sucessfully");
                            } else {
                                System.out.println("The electric car isn't registered");
                            }
                        }

                        if (subtype == 2) {

                            System.out.println("Type the new Car's charger type\n1. Fast\n2. Regular");
                            int chargertype = reader.nextInt();

                            System.out.println("Type the new Electric Car's battery duration (watts)");
                            double watts = reader.nextDouble();

                            System.out
                                    .println(
                                            "Type the new Gasoline car's gasoline type\n1. Extra\n2. Regular\n3. Diesel");
                            int typeGasoline = reader.nextInt();

                            System.out.println("Type the new Gasoline car's tank capacity (gallons)");
                            double tankCapacity = reader.nextDouble();
                            if (controller.registerHybrid(price, discount, model, brand, cylinder, kilometerDriven,
                                    state, plate, tinted, numDoor, typeCar, tankCapacity, typeGasoline, chargertype,
                                    watts)) {
                                System.out.println("The Hibrid car is registered sucessfully");
                            } else {
                                System.out.println("The Hibrid car isn't registered");
                            }
                        }

                        if (subtype == 3) {

                            System.out
                                    .println(
                                            "Type the new Gasoline car's gasoline type\n1. Extra\n2. Regular\n3. Diesel");
                            int typeGasolineGasoline = reader.nextInt();

                            System.out.println("Type the new Gasoline car's tank capacity (gallons)");
                            double tankCapacityGasoline = reader.nextDouble();

                            if (controller.registerFuel(price, discount, model, brand, cylinder, kilometerDriven, state,
                                    plate, tinted, numDoor, typeCar, tankCapacityGasoline, typeGasolineGasoline)) {
                                System.out.println("The Fuel car is registered sucessfully");
                            } else {
                                System.out.println("The Fuel car isn't registered");
                            }

                        }

                    }
                    if (typeVehicle == 2) {
                        System.out
                                .println("Type the new kind of Motocycle\n1. Standar\n2. Sport\n3. Scooter\n4. Cross");
                        int type = reader.nextInt();

                        System.out.println("Type the new Motocycle tank capacity (gallons)");
                        double capacityTank = reader.nextDouble();
                        if (controller.registerMoto(price, discount, model, brand, cylinder, kilometerDriven, state,
                                plate, type, capacityTank)) {
                            System.out.println("The Motocycle is registered sucessfully");
                        } else {
                            System.out.println("The Motocycle isn't registered");
                        }
                    }

                    break;
                case 2:
                    double levelsGas = 0;
                    double insuranceCover = 0;
                    System.out.println(controller.showVehiclesList());
                    System.out.println("Select the vehicle to register a document");
                    int position = reader.nextInt();
                    System.out.println("Type the new Document's year");
                    int year = reader.nextInt();

                    System.out.println("Type the new Document's price");
                    double priceDoc = reader.nextDouble();

                    System.out
                            .println("Select the document to register\n1. Soat\n2.Mechanical tecnic\n3. Property Card");
                    int document = reader.nextInt();

                    if (document == 1) {
                        System.out.println("Type the new SOAT's insurance cover");
                        insuranceCover = reader.nextDouble();

                        if (controller.registerDocument(position, document, priceDoc, year, insuranceCover,
                                levelsGas)) {
                            System.out.println("Document registered successfully");
                        } else {
                            System.out.println("Document not registerd successfully");
                        }
                    }

                    if (document == 2) {
                        System.out.println("Type the new Mechanical Tecnic gas level");
                        levelsGas = reader.nextDouble();
                        if (controller.registerDocument(position, document, priceDoc, year, insuranceCover,
                                levelsGas)) {
                            System.out.println("Document registered successfully");
                        } else {
                            System.out.println("Document not registerd successfully");
                        }
                    }

                    if (document == 3) {
                        if (controller.registerDocument(position, document, priceDoc, year, insuranceCover,
                                levelsGas)) {
                            System.out.println("Document registered successfully");
                        } else {
                            System.out.println("Document not registerd successfully");
                        }
                    }

                    break;
                case 3:
                    System.out.println(controller.showVehiclesList());
                    System.out.println("Select the vehicle to know the selling price");
                    position = reader.nextInt();

                    System.out.println(controller.showSellingPrice(position));
                    break;
                case 4:

                    System.out.println("Generate report by\n1. Vehicle type\n2.Fuel type\n3. New/Used cars");
                    int report = reader.nextInt();

                    switch (report) {
                        case 1:

                            System.out.println(controller.allInformationType());

                            break;
                        case 2:
                            System.out.println("Show cars they use\n1.EXTRA\n2.CORRIENTE\n3. DIESEL ");
                            int fuel = reader.nextInt();
                            System.out.println(controller.allInformationFuel(fuel));
                            break;
                        case 3:
                            System.out.println("Show cars\1n. New\n2. Used");
                            state = reader.nextInt();
                            System.out.println(controller.allInformationState(state));
                            break;
                    }

                    break;
                case 5:
                    System.out.println(controller.showVehiclesList());
                    System.out.println("Select the vehicle to show document's information");
                    position = reader.nextInt();
                    System.out.println(controller.showDocumentsInfo(position));
                    break;
                case 6:
                    System.out.println(controller.showParking());
                    break;
                case 7:
                    System.out.println(
                            "Generate Report garage by \n1. Vehicle status (and information) given a range of years.\n2. Data of the oldest and newest vehicle.\n3. Percentage of occupation of the parking lot.");
                    int garageReport = reader.nextInt();

                    switch (garageReport) {
                        case 1:
                            System.out.println("Type the range of years(1990-2000)");
                            String year1 = reader.next();
                            int min = Integer.parseInt(year1.split("-")[0]);
                            int max = Integer.parseInt(year1.split("-")[1]);
                            System.out.println(controller.garageReportYears(min, max));
                            break;
                        case 2:
                            System.out.println(controller.dataVehiclesOld());
                            break;
                        case 3:
                            System.out.println(controller.showOcuppation());
                            break;
                    }

                    break;
                case 0:
                    stopMenu = true;
                    break;

                default:
            }

        }

    }
}

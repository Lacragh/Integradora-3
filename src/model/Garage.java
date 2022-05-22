package model;

public class Garage {

    private String[][] garage;

    public Garage() {
        setGarage(new String[10][5]);
        this.garage = generateParking();
    }

    public String[][] getGarage() {
        return garage;
    }

    public void setGarage(String[][] garage) {
        this.garage = garage;
    }

     /**
	 * <pre>
	 * <strong>Descripción del metodo </strong> El metodo generateParking me llena la matrix del parqueadero con vacios.
     * 
	 * 
	 * <strong>Inputs:</strong> <strong>
	 * Outputs:</strong> me retorna una matrix tipo String
	 * </pre>
	 */


    public String[][] generateParking() {

        for (int i = 0; i < garage.length; i++) {
            for (int j = 0; j < garage[0].length; j++) {
                garage[i][j] = "[   -      -   ]";
            }
        }

        return garage;

    }

     /**
	 * <pre>
	 * <strong>Descripción del metodo </strong> El metodo percentage me calcula el porcentage de llenado del parqueadero 
     * 
	 * 
	 * <strong>Inputs:</strong> <strong>
	 * Outputs:</strong> me retorna un double
	 * </pre>
	 */


    public double percentage() {
        double percentage = 1;
        int con = 0;
        for (int i = 0; i < getGarage().length; i++) {
            for (int j = 0; j < getGarage()[0].length; j++) {
                if (getGarage()[i][j].equals("[   -      -   ]")) {

                } else {
                    con = con + 1;
                    percentage = (con * 100) / 50;
                }
            }
        }

        return percentage;
    }


     /**
	 * <pre>
	 * <strong>Descripción del metodo </strong> El metodo showParking me permite imprimir el parqueadero.
     * 
	 * 
	 * <strong>Inputs:</strong><strong>
	 * Outputs:</strong> me retorna un String
	 * </pre>
	 */

    public String showParking() {
        String msg = "";

        for (int i = 0; i < garage.length; i++) {
            for (int j = 0; j < garage[0].length; j++) {
                msg += garage[i][j];
            }
            msg += "\n";
        }
        return msg;
    }


     /**
	 * <pre>
	 * <strong>Descripción del metodo </strong> El metodo addVehicle me permite agregar el carro a la matrix del garaje 
     * 
	 * 
	 * <strong>Inputs:</strong>Vehicles vehicles<strong>
	 * Outputs:</strong> me retorna nada
	 * </pre>
	 */

    public void addVehicle(Vehicles vehicles) {
        boolean stopFlag = true;

        if (vehicles.getModel().equals("2014")) {
            for (int i = 0; i < this.garage.length; i++) {
                if (garage[i][0].equals("[   -      -   ]")) {
                    if (stopFlag == true) {
                        garage[i][0] = garage[i][0].replaceFirst("-", vehicles.getBrand()); // STORAGE CARS 2014
                        garage[i][0] = garage[i][0].replaceFirst("-", vehicles.getModel());
                        stopFlag = false;
                    }

                }

            }
        }

        if (vehicles.getModel().equals("2013")) {
            for (int i = 0; i < this.garage.length; i++) {
                if (garage[i][1].equals("[   -      -   ]")) {
                    if (stopFlag == true) {
                        garage[i][1] = garage[i][1].replaceFirst("-", vehicles.getBrand()); // STORAGE CARS 2013
                        garage[i][1] = garage[i][1].replaceFirst("-", vehicles.getModel());
                        stopFlag = false;
                    }

                }

            }
        }

        if (vehicles.getModel().equals("2012")) {
            for (int i = 0; i < this.garage.length; i++) {
                if (garage[i][0].equals("[   -      -   ]")) {
                    if (stopFlag == true) {
                        garage[i][2] = garage[i][2].replaceFirst("-", vehicles.getBrand()); // STORAGE CARS 2012
                        garage[i][2] = garage[i][2].replaceFirst("-", vehicles.getModel());
                        stopFlag = false;
                    }

                }

            }
        }

        if (Integer.parseInt(vehicles.getModel()) <= 2011) {
            for (int i = 0; i < this.garage.length; i++) {
                if (garage[i][3].equals("[   -      -   ]")) {
                    if (stopFlag == true) {
                        garage[i][3] = garage[i][3].replaceFirst("-", vehicles.getBrand()); // STORAGE CARS 2011
                        garage[i][3] = garage[i][3].replaceFirst("-", vehicles.getModel());
                        stopFlag = false;
                    }

                }

            }
        }

        if (Integer.parseInt(vehicles.getModel()) >= 2015) {
            for (int i = 0; i < this.garage.length; i++) {
                if (garage[i][0].equals("[   -      -   ]")) {
                    if (stopFlag == true) {
                        garage[i][4] = garage[i][4].replaceFirst("-", vehicles.getBrand()); // STORAGE CARS 2012
                        garage[i][4] = garage[i][4].replaceFirst("-", vehicles.getModel());
                        stopFlag = false;
                    }

                }

            }
        }

    }

}

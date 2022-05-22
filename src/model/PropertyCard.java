package model;

import java.util.Random;

public class PropertyCard extends Document {

    public PropertyCard(int typeDocoument, double price, int date) {
        super(typeDocoument, price, date);
        this.setImage(generateMatrix());
        this.setCode(showMatrixPar());
    }

     /**
	 * <pre>
	 * <strong>Descripción del metodo </strong> El metodo showMatrixPar me ayuda a encontrat el codigo del documento
     * 
	 * 
	 * <strong>Inputs:</strong>Profe lo quiero mucho<strong>
	 * Outputs:</strong> me retorna un String.
	 * </pre>
	 */

    public String showMatrixPar() {
        String msg = "";

        for (int i = getImage().length - 1; i >= 0; i--) {

            for (int j = getImage()[0].length - 1; j >= 0; j--) {
                if ((i + j) != 0 && (i + j) % 2 == 0) {
                    msg += getImage()[i][j] + " ";
                }
            }
        }
        return msg;
    }

    @Override
    public String toString() {
        String msg = "";
        msg += "\nProperty Card Data:\nCode Matrix:\n" + printImage(getImage()) + "\nCode: " + showMatrixPar()
                + "\nYear: " + getDate() + "\nPrice: " + getPrice();
        return msg;
    }

    public String status() {
        return "The vehicule has a Property Card";
    }

}

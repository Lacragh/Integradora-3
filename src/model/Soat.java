package model;

import java.util.Random;

public class Soat extends Document {
    private double mountAccidents;
    private String code = "";

    public Soat(int typeDocoument, double price, int date, double mountAccidents) {
        super(typeDocoument, price, date);
        this.setMountAccidents(mountAccidents);
        this.setImage(generateMatrix());
        setCode(showMatrixL());
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getMountAccidents() {
        return mountAccidents;
    }

    public void setMountAccidents(double mountAccidents) {
        this.mountAccidents = mountAccidents;
    }

     /**
	 * <pre>
	 * <strong>Descripción del metodo </strong> El metodo showMatrixL me permite crear una matrix
     * 
	 * 
	 * <strong>Inputs:</strong>Profe lo quiero mucho<strong>
	 * Outputs:</strong> me retorna un String
	 * </pre>
	 */


    public String showMatrixL() {
        String msg = "";

        for (int i = 0; i < getImage().length; i++) { // filas
            msg += getImage()[i][0] + " ";
            if (i == getImage().length - 1) {
                for (int j = 1; j < getImage().length; j++) {
                    msg += getImage()[getImage().length - 1][j] + " ";
                }
            }

        }

        return msg;
    }

    @Override
    public String toString() {
        String msg = "";

        msg += "\nSOAT Data:\nCode Matrix:\n" + printImage(this.getImage()) + "\nCode: " + showMatrixL() + "\nYear: "
                + getDate() + "\nPrice: " + getPrice();

        return msg;
    }

     /**
	 * <pre>
	 * <strong>Descripción del metodo </strong> El metodo status me permite ver si esta activo los documentos
     * 
	 * 
	 * <strong>Inputs:</strong>Profe lo quiero mucho <3 <strong>
	 * Outputs:</strong> me retorna un String.
	 * </pre>
	 */

    @Override
    public String status() {
        String msg = "";
        if (getDate() < 2022) {
            msg += "\nSOAT isn't active and isn't for the current year\n";
        } else if (getDate() == 2022) {
            msg += "\nSOAT is active and is valid for the current year\n";
        }

        return msg;
    }

}

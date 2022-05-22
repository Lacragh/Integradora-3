package model;

import java.util.Random;

public class Mechanical extends Document {
    private double levelsGas;

    public Mechanical(int typeDocoument, double levelsGas, double price, int date) {
        super(typeDocoument, price, date);
        this.setLevelsGas(levelsGas);
        setImage(generateMatrix());
        this.setCode(showMatrixZ());
    }

    public double getLevelsGas() {
        return levelsGas;
    }

    public void setLevelsGas(double levelsGas) {
        this.levelsGas = levelsGas;
    }

     /**
	 * <pre>
	 * <strong>Descripción del metodo </strong> El metodo showMatrixZ me permite encontrar el codigo en forma z del documento
     * 
	 * 
	 * <strong>Inputs:</strong><strong>
	 * Outputs:</strong> me retorna un String
	 * </pre>
	 */

    public String showMatrixZ() {
        String msg = "";

        for (int i = 0; i < getImage()[0].length; i++) {
            msg += getImage()[0][i] + " ";
        }
        boolean stopflag = false;
        int position = getImage()[0].length - 1;
        for (int i = 1; i < getImage().length; i++) {
            stopflag = false;
            position--;
            for (int j = position; j > -1 && !stopflag; j--) {
                msg += getImage()[i][j] + " ";
                stopflag = true;
            }

        }
        for (int i = 1; i < getImage()[0].length; i++) {
            msg += getImage()[getImage().length - 1][i] + " ";
        }

        return msg;
    }

    @Override
    public String toString() {
        String msg = "";

        msg += "\nTechnoMechanic Data:\nCode Matrix:\n" + printImage(getImage()) + "\nCode: " + showMatrixZ()
                + "\nYear: " + getDate() + "\nPrice: " + getPrice();
        ;

        return msg;
    }

     /**
	 * <pre>
	 * <strong>Descripción del metodo </strong> El metodo status me permite saber si vencio o no el documento
     * 
	 * 
	 * <strong>Inputs:</strong><strong>
	 * Outputs:</strong> me retorna un String
	 * </pre>
	 */

    @Override
    public String status() {
        String msg = "";
        if (getDate() < 2022) {
            msg += "\nTechnoMechanic isn't active and isn't for the current year\n";
        } else if (getDate() == 2022) {
            msg += "\nTechnoMechanic is active and is valid for the current year\n";
        }

        return msg;
    }

}

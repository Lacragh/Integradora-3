package model;

import java.util.Random;

public abstract class Document {
    private double price;
    private int date;
    private TypeDocoument typeDocoument;
    private int[][] image;
    private String code;

    public Document(int typeDocoument, double price, int date) {
        setImage(new int[4][4]);
        this.setPrice(price);
        this.setDate(date);

        switch (typeDocoument) {
            case 1:
                this.setTypeDocoument(TypeDocoument.SOAT);
                break;

            case 2:
                this.setTypeDocoument(TypeDocoument.MECHANICAL);
                break;

            case 3:
                this.setTypeDocoument(TypeDocoument.PROPERTYCARD);
                break;
        }
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int[][] getImage() {
        return image;
    }

    public void setImage(int[][] image) {
        this.image = image;
    }

    public TypeDocoument getTypeDocoument() {
        return typeDocoument;
    }

    public void setTypeDocoument(TypeDocoument typeDocoument) {
        this.typeDocoument = typeDocoument;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String printImage(int[][] image) {

        String print = "";
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                print += image[i][j] + " ";
            }
            print += "\n";
        }
        return print;
    }

     /**
	 * <pre>
	 * <strong>Descripción del metodo </strong> El metodo generateMatrix me permite crear la matrix del documento aleatoriamente
     * 
	 * 
	 * <strong>Inputs:</strong><strong>
	 * Outputs:</strong> me retorna un double.
	 * </pre>
	 */

    public int[][] generateMatrix() {
        Random r = new Random();
        int[][] random = new int[4][4];
        for (int i = 0; i < random.length; i++) {

            for (int j = 0; j < random[0].length; j++) {
                random[i][j] = r.nextInt(10);
            }
        }

        return random;

    }

    public String status() {
        return "";
    }

}

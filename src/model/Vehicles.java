package model;

import java.util.ArrayList;

public abstract class Vehicles implements CalculatePrice {
    private double basePrice;
    private double sellPrice;
    private String model;
    private double cylinder;
    private double mileage;
    private State gradeQuality;
    private String licensePlate;
    private double discount;
    private String brand;
    private ArrayList<Document> documents;

    public Vehicles(double basePrice, double discount, String model, String brand, double cylinder, double mileage,
            int gradeQuality, String licensePlate) {
        documents = new ArrayList<>();
        this.discount = discount;
        this.brand = brand;
        this.setBasePrice(basePrice);
        this.setModel(model);
        this.setCylinder(cylinder);
        this.setMileage(mileage);
        switch (gradeQuality) {
            case 1:
                this.setGradeQuality(State.NEW);
                break;

            case 2:
                this.setGradeQuality(State.USED);
                break;
        }
        this.setLicensePlate(licensePlate);

    }

    /**
     * <pre>
     * <strong>Descripción del metodo </strong> El metodo registerDocuments me permite registrar un documento. 
     * 
     * 
     * <strong>Inputs:</strong>nt typeDocoument, double price, int date, double mountAccidents, double levelsGas <strong>
     * Outputs:</strong> me retorna un booleano que puede ser verdadero o falso dependiendo si me dejo crear el documento.
     * </pre>
     */

    public boolean registerDocument(int typeDocoument, double price, int date, double mountAccidents,
            double levelsGas) {

        if (typeDocoument == 1) {
            return documents.add(new Soat(typeDocoument, price, date, mountAccidents));
        }

        if (typeDocoument == 2) {
            return documents.add(new Mechanical(typeDocoument, levelsGas, price, date));
        }

        if (typeDocoument == 3) {
            return documents.add(new PropertyCard(typeDocoument, price, date));
        }

        return false;
    }
     /**
     * <pre>
     * <strong>Descripción del metodo </strong> El metodo showDocumentsInfo me permite saber el estado de los documentos.
     * 
     * 
     * <strong>Inputs:</strong> <strong>
     * Outputs:</strong> me retorna un String.
     * </pre>
     */
    public String showDocumentsInfo() {
        String msg = "";

        for (int i = 0; i < getDocuments().size(); i++) {
            msg += documents.get(i).toString();

        }
        for (int i = 0; i < getDocuments().size(); i++) {
            if (documents.get(i) instanceof Soat) {
                msg += documents.get(i).status();
            } 
            
            if (documents.get(i) instanceof PropertyCard) {
                msg += documents.get(i).status();
            } 
            if (documents.get(i) instanceof Mechanical) {
                msg += documents.get(i).status();
            } 

        }
        if (msg.contains("SOAT")){

        }else{
            msg+= "\nThe vehicle does not have a soat";
        }

        if (msg.contains("TechnoMechanic ")){

        }else{
            msg+= "\nThe vehicle does not have a TechnoMechanic ";
        }
        if (msg.contains("Property Card")){

        }else{
            msg+= "\nThe vehicle does not have a Property Card";
        }
        return msg;
    }

     /**
     * <pre>
     * <strong>Descripción del metodo </strong> El metodo showDocumentList me muestra una lista de los documentos
     * 
     * 
     * <strong>Inputs:</strong>nt typeDocoument, double price, int date, double mountAccidents, double levelsGas <strong>
     * Outputs:</strong> me retorna un booleano que puede ser verdadero o falso dependiendo si me dejo crear el documento.
     * </pre>
     */
    public String showDocumentList() {

        String msg = "";

        for (int i = 0; i < documents.size(); i++) {

            msg += ("\n" + (i + 1) + ". ") + documents.get(i).getPrice() + " " + documents.get(i).getDate();
        }
        return msg;
    }

    public ArrayList<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(ArrayList<Document> documents) {
        this.documents = documents;
    }

    public State getGradeQuality() {
        return gradeQuality;
    }

    public void setGradeQuality(State gradeQuality) {
        this.gradeQuality = gradeQuality;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public double getCylinder() {
        return cylinder;
    }

    public void setCylinder(double cylinder) {
        this.cylinder = cylinder;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public double calculatePrice() {
        return 0;
    }

    public String toString() {
        return "";
    }

    public TYPEFUEL getTypefuel() {
        return getTypefuel();

    }
}

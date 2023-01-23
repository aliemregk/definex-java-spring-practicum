package entities.concretes;

import entities.abstracts.AbstractPropertyBase;

public class SummerHouse extends AbstractPropertyBase {

    private boolean isFurnished;

    public SummerHouse(int id, Double price, Double squareMeters, int roomNumber, int salonNumber,
            boolean isFurnished) {
        super(id, price, squareMeters, roomNumber, salonNumber);
        this.isFurnished = isFurnished;
    }

    public boolean isFurnished() {
        return isFurnished;
    }

    public void setFurnished(boolean isFurnished) {
        this.isFurnished = isFurnished;
    }

    @Override
    public String toString() {
        return "ID: " + getId() + " - "
                + "Price: " + getPrice() + " - "
                + "Square Meters: " + getSquareMeters() + " - "
                + "Rooms: " + getRoomNumber() + " - "
                + "Salon(s): " + getSalonNumber() + " - "
                + "Furniture: " + (isFurnished() ? "Yes" : "No");
    }
}

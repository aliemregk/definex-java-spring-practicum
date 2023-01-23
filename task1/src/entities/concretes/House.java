package entities.concretes;

import entities.abstracts.AbstractPropertyBase;

public class House extends AbstractPropertyBase {

    private boolean isDetached;

    public House(int id, Double price, Double squareMeters, int roomCount, int salonCount, boolean isDetached) {
        super(id, price, squareMeters, roomCount, salonCount);
        this.isDetached = isDetached;
    }

    public boolean isDetached() {
        return isDetached;
    }

    public void setDetached(boolean isDetached) {
        this.isDetached = isDetached;
    }

    @Override
    public String toString() {
        return "ID: " + getId() + " - "
                + "Price: " + getPrice() + " - "
                + "Square Meters: " + getSquareMeters() + " - "
                + "Rooms: " + getRoomNumber() + " - "
                + "Salon(s): " + getSalonNumber() + " - "
                + "Detached: " + (isDetached() ? "Yes" : "No");
    }

}

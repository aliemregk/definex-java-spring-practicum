package entities.concretes;

import entities.abstracts.AbstractPropertyBase;

public class Villa extends AbstractPropertyBase {

    private boolean hasPool;

    public Villa(int id, Double price, Double squareMeters, int roomNumber, int salonNumber, boolean hasPool) {
        super(id, price, squareMeters, roomNumber, salonNumber);
        this.hasPool = hasPool;
    }

    public boolean hasPool() {
        return hasPool;
    }

    public void setHasPool(boolean hasPool) {
        this.hasPool = hasPool;
    }

    @Override
    public String toString() {
        return "ID: " + getId() + " - "
                + "Price: " + getPrice() + " - "
                + "Square Meters: " + getSquareMeters() + " - "
                + "Rooms: " + getRoomNumber() + " - "
                + "Salon(s): " + getSalonNumber() + " - "
                + "Pool: " + (hasPool() ? "Yes" : "No");
    }
}

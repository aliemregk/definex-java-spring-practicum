package entities.concretes;

import entities.abstracts.AbstractPropertyBase;

public class Villa extends AbstractPropertyBase {

    private boolean hasPool;

    public Villa(int id, Double price, Double squareMeters, int roomCount, int salonCount, boolean hasPool) {
        super(id, price, squareMeters, roomCount, salonCount);
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
                + "Rooms: " + getRoomCount() + " - "
                + "Salon(s): " + getSalonCount() + " - "
                + "Pool: " + (hasPool() ? "Yes" : "No");
    }
}

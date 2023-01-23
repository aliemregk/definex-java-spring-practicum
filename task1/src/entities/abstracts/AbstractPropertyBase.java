package entities.abstracts;

public abstract class AbstractPropertyBase {

    private int id;
    private Double price;
    private Double squareMeters;
    private int roomCount;
    private int salonCount;

    protected AbstractPropertyBase(int id, Double price, Double squareMeters, int roomCount, int salonCount) {
        this.id = id;
        this.price = price;
        this.squareMeters = squareMeters;
        this.roomCount = roomCount;
        this.salonCount = salonCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSquareMeters() {
        return squareMeters;
    }

    public void setSquareMeters(Double squareMeters) {
        this.squareMeters = squareMeters;
    }

    public int getRoomNumber() {
        return roomCount;
    }

    public void setRoomNumber(int roomCount) {
        this.roomCount = roomCount;
    }

    public int getSalonNumber() {
        return salonCount;
    }

    public void setSalonNumber(int salonCount) {
        this.salonCount = salonCount;
    }

    public abstract String toString();
}

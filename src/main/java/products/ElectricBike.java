package products;

public final class ElectricBike extends ElectricVehicle{
    private int gears;

    public ElectricBike(String brand, String model, int year, double price, double drivingRange
            , double maxSpeed, double wheelInch, double batteryCapacity, double peakPower, double voltage, double weight,
                        boolean suspension, boolean solidTire, int maxLoad, int gears, int code, int inStock) {
        super(brand, model, year, price, drivingRange, maxSpeed, wheelInch,
                batteryCapacity, peakPower, voltage, weight, suspension, solidTire, maxLoad, code, inStock);
        this.gears = gears;
    }

    public ElectricBike() {
    }

    public int getGears() {
        return gears;
    }

    public void setGears(int gears) {
        this.gears = gears;
    }

    @Override
    public String toString() {
        return new StringBuilder(super.toString())
                .append(" Liczba biegów: ")
                .append(this.getGears())
                .toString();
    }
}

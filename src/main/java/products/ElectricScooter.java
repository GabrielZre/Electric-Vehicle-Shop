package products;

public final class ElectricScooter extends ElectricVehicle {
    private String wheelDrive;

    public ElectricScooter(String brand, String model, int year, double price,
                           double drivingRange, double maxSpeed, double wheelInch,
                           double batteryCapacity, double peakPower, double voltage, double weight, boolean suspension,
                           boolean solidTire, int maxLoad, String wheelDrive, int code, int inStock) {
        super(brand, model, year, price, drivingRange, maxSpeed,
                wheelInch, batteryCapacity, peakPower, voltage, weight, suspension, solidTire, maxLoad, code, inStock);
        this.wheelDrive = wheelDrive;
    }

    public ElectricScooter() {
    }

    public String getWheelDrive() {
        return wheelDrive;
    }

    public void setWheelDrive(String wheelDrive) {
        this.wheelDrive = wheelDrive;
    }

    @Override
    public String toString() {
        return new StringBuilder(super.toString())
                .append(" Wheel drive: ")
                .append(this.getWheelDrive())
                .toString();
    }
}

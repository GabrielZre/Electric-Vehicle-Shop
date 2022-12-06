package products;

public class ElectricSkateboard extends ElectricVehicle{

    public ElectricSkateboard(String brand, String model, int year, double price, double drivingRange
            , double maxSpeed, double wheelInch, double batteryCapacity, double peakPower, double voltage, double weight
            , boolean suspension, boolean solidTire, int maxLoad, int code, int inStock) {
        super(brand, model, year, price, drivingRange, maxSpeed, wheelInch, batteryCapacity
                , peakPower, voltage, weight, suspension, solidTire, maxLoad, code, inStock);
    }

    public ElectricSkateboard() {
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

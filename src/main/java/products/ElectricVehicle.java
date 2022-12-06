package products;

public class ElectricVehicle {
    private String brand;
    private String model;
    private int year;
    private double price;
    private double drivingRange;
    private double maxSpeed;
    private double wheelInch;
    private double batteryCapacity;
    private double peakPower;
    private double voltage;
    private double weight;
    private boolean suspension;
    private boolean solidTire;
    private int maxLoad;
    private int code;
    private int inStock;

    public ElectricVehicle() {
    }

    public ElectricVehicle(String brand, String model, int year,
                           double price, double drivingRange, double maxSpeed,
                           double wheelInch, double batteryCapacity, double peakPower, double voltage,
                           double weight, boolean suspension, boolean solidTire, int maxLoad, int code, int inStock) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.drivingRange = drivingRange;
        this.maxSpeed = maxSpeed;
        this.wheelInch = wheelInch;
        this.batteryCapacity = batteryCapacity;
        this.peakPower = peakPower;
        this.voltage = voltage;
        this.weight = weight;
        this.suspension = suspension;
        this.solidTire = solidTire;
        this.maxLoad = maxLoad;
        this.code = code;
        this.inStock = inStock;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDrivingRange() {
        return drivingRange;
    }

    public void setDrivingRange(double drivingRange) {
        this.drivingRange = drivingRange;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getWheelInch() {
        return wheelInch;
    }

    public void setWheelInch(double wheelInch) {
        this.wheelInch = wheelInch;
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public double getPeakPower() {
        return peakPower;
    }

    public void setPeakPower(double peakPower) {
        this.peakPower = peakPower;
    }

    public double getVoltage() { return voltage; }

    public void setVoltage(double voltage) { this.voltage = voltage; }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isSuspension() {
        return suspension;
    }

    public void setSuspension(boolean suspension) {
        this.suspension = suspension;
    }

    public boolean isSolidTire() {
        return solidTire;
    }

    public void setSolidTire(boolean solidTire) {
        this.solidTire = solidTire;
    }

    public int getMaxLoad() { return maxLoad; }

    public void setMaxLoad(int maxLoad) { this.maxLoad = maxLoad; }

    public int getCode() { return code; }

    public void setCode(int code) { this.code = code; }

    public int getInStock() { return inStock; }

    public void setInStock(int inStock) { this.inStock = inStock; }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(this.getBrand())
                .append(" ")
                .append(this.getModel())
                .append(" Year:")
                .append(this.getYear())
                .append(" Price:")
                .append(this.getPrice())
                .append(" Driving range:")
                .append(this.getDrivingRange())
                .append(" Max speed:")
                .append(this.getMaxSpeed())
                .append(" Wheel inch:")
                .append(this.getWheelInch())
                .append(" Battery capacity:")
                .append(this.getBatteryCapacity())
                .append(" Peak power:")
                .append(this.getPeakPower())
                .append(" Weight:")
                .append(this.getWeight())
                .append(" Suspension:")
                .append(this.isSuspension() ? "Nie" : "Tak")
                .append(" Solid tire:")
                .append(this.isSolidTire() ? "Nie" : "Tak")
                .append(" Max load:")
                .append(this.getMaxLoad())
                .append(" Code:")
                .append(this.getCode())
                .append(" In Stock:")
                .append(this.getInStock())
                .toString();
    }
}


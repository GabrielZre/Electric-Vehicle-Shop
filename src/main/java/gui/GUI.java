package gui;

import core.Authenticator;
import database.ElectricVehicleDB;
import database.UserDB;
import org.apache.commons.codec.digest.DigestUtils;
import products.*;

import java.util.Scanner;

public class GUI {
    private final Scanner scanner = new Scanner(System.in);
    final Authenticator authenticator = Authenticator.getInstance();
    final ElectricVehicleDB electricVehicleDB = ElectricVehicleDB.getInstance();
    final UserDB userDB = UserDB.getInstance();
    private static final GUI instance = new GUI();

    private GUI() {
    }

    public String showMenu(){
        System.out.println("1. List electric vehicles");
        System.out.println("2. Buy electric vehicle");
        System.out.println("3. Exit");
        if (this.authenticator.getLoggedUser() != null &&
                this.authenticator.getLoggedUser().getRole() == User.Role.ADMIN) {
            System.out.println("4. Add electric vehicle");
            System.out.println("5. Change user's role");
            System.out.println("6. Fill up stock");
        }
        return scanner.nextLine();
    }

    public String showLoginMenu(){
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        return scanner.nextLine();
    }

    public void listUsers() {
        for (User user : this.userDB.getUsers()) {
            System.out.println(user);
        }
    }

    public void listElectricVehicles() {
        for (ElectricVehicle electricVehicle : this.electricVehicleDB.getElectricVehicles()) {
            System.out.println(electricVehicle);
        }
    }

    public int readCode() {
        System.out.println("Code:");
        return Integer.parseInt(this.scanner.nextLine());
    }

    public String readUser() {
        System.out.println("User:");
        return this.scanner.nextLine();
    }

    public String readRole() {
        System.out.println("Role:");

        return this.scanner.nextLine();
    }

    public int readAmount() {
        System.out.println("Amount:");
        return Integer.parseInt(this.scanner.nextLine());
    }

    public void showBuyResult(boolean result) {
        if(result) {
            System.out.println("Product bought successful");
        } else {
            System.out.println("Product is not available yet");
        }
    }

    public void showChangeRoleResult(boolean result) {
        if(result) {
            System.out.println("Role changed successful");
        } else {
            System.out.println("Bad login or role!");
        }
    }

    public void showAddStockResult(boolean result) {
        if(result) {
            System.out.println("Successfully filled up stock");
        } else {
            System.out.println("Incorrect code or amount!");
        }
    }

    public User register() {
        System.out.println("Login:");
        String login = this.scanner.nextLine();
        System.out.println("Password:");
        String password = this.scanner.nextLine();
        return new User(login, DigestUtils.md5Hex(password + core.Authenticator.getSeed()), User.Role.USER);
        }

    public User readLoginAndPassword() {
        User user = new User();
        System.out.println("Login:");
        user.setLogin(this.scanner.nextLine());
        System.out.println("Password:");
        user.setPassword(this.scanner.nextLine());
        return user;
    }

    public ElectricVehicle readNewElectricVehicleData() {
        System.out.println("1. Electric Scooter");
        System.out.println("2. Electric Bike");
        System.out.println("3. Electric Skateboard");
        System.out.println("4. Electric Wheelchair");
        System.out.println("5. Electric Unicycle");
        String choose = this.scanner.nextLine();
        System.out.println("Brand:");
        String brand = this.scanner.nextLine();
        System.out.println("Model:");
        String model = this.scanner.nextLine();
        System.out.println("Year:");
        int year = Integer.parseInt(this.scanner.nextLine());
        System.out.println("Price:");
        double price = Double.parseDouble(this.scanner.nextLine());
        System.out.println("Driving range:");
        double drivingRange = Double.parseDouble(this.scanner.nextLine());
        System.out.println("Max speed:");
        double maxSpeed = Double.parseDouble(this.scanner.nextLine());
        System.out.println("Wheel inch:");
        double wheelInch = Double.parseDouble(this.scanner.nextLine());
        System.out.println("Battery capacity:");
        double batteryCapacity = Double.parseDouble(this.scanner.nextLine());
        System.out.println("Peak power:");
        double peakPower = Double.parseDouble(this.scanner.nextLine());
        System.out.println("Voltage:");
        double voltage = Double.parseDouble(this.scanner.nextLine());
        System.out.println("Weight:");
        double weight = Double.parseDouble(this.scanner.nextLine());
        System.out.println("Suspension: (Y/N)");
        boolean suspension = Boolean.parseBoolean(this.scanner.nextLine());
        System.out.println("Solid tire: (Y/N)");
        boolean solidTire = Boolean.parseBoolean(this.scanner.nextLine());
        System.out.println("Max Load:");
        int maxLoad = Integer.parseInt(this.scanner.nextLine());
        System.out.println("Code:");
        int code = Integer.parseInt(this.scanner.nextLine());
        System.out.println("In stock:");
        int inStock = Integer.parseInt(this.scanner.nextLine());
        switch (choose) {
            case "1":
                System.out.println("Wheel drive: (Front/Rear/AWD)");
                return new ElectricScooter(brand, model, year, price, drivingRange, maxSpeed
                        , wheelInch, batteryCapacity, peakPower, voltage, weight, suspension
                        , solidTire, maxLoad,
                        this.scanner.nextLine(), code, inStock);
            case "2":
                System.out.println("Gears:");
                return new ElectricBike(brand, model, year, price, drivingRange, maxSpeed
                        , wheelInch, batteryCapacity, peakPower, voltage, weight, suspension
                        , solidTire, maxLoad,
                        Integer.parseInt(this.scanner.nextLine()), code, inStock);
            case "3":
                return new ElectricSkateboard(brand, model, year, price, drivingRange, maxSpeed
                        , wheelInch, batteryCapacity, peakPower, voltage, weight, suspension
                        , solidTire, maxLoad, code, inStock);
            case "4":
                return new ElectricWheelchair(brand, model, year, price, drivingRange, maxSpeed
                        , wheelInch, batteryCapacity, peakPower, voltage, weight, suspension
                        , solidTire, maxLoad, code, inStock);
            case "5":
                return new ElectricUnicycle(brand, model, year, price, drivingRange, maxSpeed
                        , wheelInch, batteryCapacity, peakPower, voltage, weight, suspension
                        , solidTire, maxLoad, code, inStock);
        }

        return null;
    }

    public static GUI getInstance() {
        return instance;
    }
}

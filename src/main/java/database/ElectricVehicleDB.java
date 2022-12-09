package database;

import products.*;

import java.util.Arrays;

public class ElectricVehicleDB {
    private ElectricVehicle[] electricVehicles = new ElectricVehicle[8];
    private static final ElectricVehicleDB instance = new ElectricVehicleDB();

    public ElectricVehicleDB() {
        this.electricVehicles[0] = new ElectricScooter("Speedway", "Mini 4 Pro", 2020, 3200, 50.0, 50.0, 8.0, 16.0, 1200.0
            , 48.0, 17.0, true, true, 120,"REAR", 1118372, 5);
        this.electricVehicles[1] = new ElectricScooter("Xiaomi", "Mi 2 pro", 2022, 2800, 30.0, 20.0, 8.5, 13.0, 600.0
                , 36.0, 14.2, false, false, 120,"Front", 1114323, 7);
        this.electricVehicles[2] = new ElectricScooter("Ninebot", "MAX G30", 2021, 3700, 65.0, 30.0, 10.0, 14.5, 800
                , 36, 19.0, false, true, 120,"Rear", 1112967, 4);
        this.electricVehicles[3] = new ElectricBike("ADO", "A26+", 2022, 3550, 35.0, 25.0, 26.0, 12.5, 250.0
                , 36.0, 29.0, true, false, 120, 5,2110493, 3);
        this.electricVehicles[4] = new ElectricUnicycle("InMotion", "V12 HS", 2021, 12899, 160.0, 70.0, 16.0, 17.5, 5000.0
                , 100.8, 29.0, true, false, 120, 3110492, 7);
        this.electricVehicles[5] = new ElectricSkateboard("Spokey", "E-Longbay 2.5", 2022, 2699, 20.0, 20.0, 2.5, 6.0, 700.0
                , 36.0, 12.0, false, true, 100, 4119482, 5);
        this.electricVehicles[6] = new ElectricWheelchair("ElectricTIM ", "I", 2019, 14260, 20.0, 6.0, 22.0, 18.0, 130.0
                , 24.0, 29.0, true, true, 115, 5110592, 4);
        this.electricVehicles[7] = new ElectricWheelchair("VegaXS ", "TI152", 20122, 16305, 30.0, 15.0, 21.0, 22.0, 500.0
                , 36.0, 32.0, true, true, 120, 5110218, 6);
    }

    public ElectricVehicle[] getElectricVehicles() {
        return electricVehicles;
    }

    public boolean buyVehicle(int code, int amount) {
        for(ElectricVehicle electricVehicle : this.electricVehicles) {
            if(electricVehicle.getCode() == code ){
                if(electricVehicle.getInStock() >= amount) {
                    electricVehicle.setInStock(electricVehicle.getInStock() - amount);
                    return true;
                } else {
                    if(electricVehicle.getInStock() < amount) {
                        System.out.println("You can buy " + electricVehicle.getInStock() + " pieces of this product at the moment");
                    }
                }
            }
        }
        return false;
    }

    public void addElectricVehicle(ElectricVehicle electricVehicle) {
        /*ElectricVehicle[] newElectricVehicles = new ElectricVehicle[this.electricVehicles.length +1];
        for(int i=0; i < this.electricVehicles.length; i++) {
            newElectricVehicles[i] = this.electricVehicles[i];
        }*/
        ElectricVehicle[] newElectricVehicles = Arrays.copyOf(electricVehicles, electricVehicles.length + 1);

        newElectricVehicles[newElectricVehicles.length - 1] = electricVehicle;
        this.electricVehicles = newElectricVehicles;
    }

    public boolean addStock(int code, int amount) {
        for(ElectricVehicle electricVehicle : this.electricVehicles) {
            if(electricVehicle.getCode() == code ){
                electricVehicle.setInStock(electricVehicle.getInStock() + amount);
                return true;
            }
        }
        return false;
    }

    public static ElectricVehicleDB getInstance() {
        return instance;
    }

}

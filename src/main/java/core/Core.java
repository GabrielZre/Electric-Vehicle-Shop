package core;

import database.UserDB;
import database.ElectricVehicleDB;
import gui.GUI;
import products.User;

public class Core {
    final ElectricVehicleDB electricVehicleDB = ElectricVehicleDB.getInstance();
    final UserDB userDB = UserDB.getInstance();
    final Authenticator authenticator = Authenticator.getInstance();
    final GUI gui = GUI.getInstance();
    private static final Core instance = new Core();


    private Core() {

    }
    boolean isRunning = false;

    public void start() {
        int counter =  0;
        boolean isLogged = false;
        while(!isLogged){
            switch (this.gui.showLoginMenu()) {
                case "1":
                    while(!isRunning && counter < 3) {
                        this.authenticator.authenticate(this.gui.readLoginAndPassword());
                        isRunning = this.authenticator.getLoggedUser() != null;
                        if(!isRunning) {
                            System.out.println("Not authorized !!");
                        }
                        else
                        {
                            isLogged = true;
                        }
                        counter++;
                    }
                    break;
                case "2":
                    this.userDB.addUser(this.gui.register());
                    break;
                case "3":
                    isLogged = true;
                    break;
            }
        }




        while(isRunning) {
            switch (this.gui.showMenu()) {
                case "1":
                    this.gui.listElectricVehicles();
                    break;
                case "2":
                    this.gui.showBuyResult(this.electricVehicleDB.buyVehicle(this.gui.readCode(), this.gui.readAmount()));
                    break;
                case "3":
                    isRunning = false;
                    break;

                case "4":
                    this.authenticator.Logout();
                    isRunning = false;
                    System.out.println("Logged Out Successfully!");
                    start();
                    break;

                case "5":
                    if(this.authenticator.getLoggedUser() != null &&
                            this.authenticator.getLoggedUser().getRole() == User.Role.ADMIN) {
                        this.electricVehicleDB.addElectricVehicle(this.gui.readNewElectricVehicleData());
                        break;
                    }
                case "6":
                    if(this.authenticator.getLoggedUser() != null &&
                            this.authenticator.getLoggedUser().getRole() == User.Role.ADMIN) {
                        this.gui.listUsers();
                        this.gui.showChangeRoleResult(this.userDB.changeUserRole(this.gui.readUser(), this.gui.readRole()));
                        break;
                    }
                case "7":
                    if(this.authenticator.getLoggedUser() != null &&
                            this.authenticator.getLoggedUser().getRole() == User.Role.ADMIN) {
                        this.gui.listElectricVehicles();
                        this.gui.showAddStockResult(this.electricVehicleDB.addStock(this.gui.readCode(),this.gui.readAmount()));
                        break;
                    }

                default:
                    System.out.println("Wrong choose !!");
                    break;
            }
        }
    }


    public static Core getInstance(){
        return instance;
    }
}

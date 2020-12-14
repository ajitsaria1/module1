package VendingMachine;
/**
 * * Factory class to create instance of Vending Machine,
 * this can be extended to create instance of
 * different types of vending machines.
 * */

public class VendingMachineInventory{
    public static VendingMachineDesign createVendingMachine() {
        return new DesignImplementation();
    }












}


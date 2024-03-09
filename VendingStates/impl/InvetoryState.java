package LowLevelDesign.DesignVendingMachine.VendingStates.impl;

import LowLevelDesign.DesignVendingMachine.Coin;
import LowLevelDesign.DesignVendingMachine.Item;
import LowLevelDesign.DesignVendingMachine.VendingMachine;
import LowLevelDesign.DesignVendingMachine.VendingStates.State;

import java.util.List;

public class InvetoryState implements State {

    public InvetoryState() {
        System.out.println("Currently Vending machine is in InventoyState");
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {

    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {

    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {

    }

    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {

    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        return 0;
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
        return null;
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
        return null;
    }

    @Override
    public void updateInventory(VendingMachine machine, int codeNumber) throws Exception {
        machine.getInventory().fillSoldOutItem(codeNumber);
        machine.setVendingMachineState(new IdleState(machine));
    }
}

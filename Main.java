package LowLevelDesign.DesignVendingMachine;

import LowLevelDesign.DesignVendingMachine.Autenticacion.LoginUser;
import LowLevelDesign.DesignVendingMachine.VendingStates.State;

import java.util.Scanner;


public class Main {

    public static void main(String args[]){

        VendingMachine vendingMachine = new VendingMachine();
        Scanner sc = new Scanner(System.in);
        boolean redo = true;
        int opcion;
        try {

            System.out.println("|");
            System.out.println("filling up the inventory");
            System.out.println("|");

            fillUpInventory(vendingMachine);
            displayInventory(vendingMachine);
            State vendingState = vendingMachine.getVendingMachineState();
            //vendingState.clickOnInsertCoinButton(vendingMachine);
            do {
                displayInventory(vendingMachine);
                System.out.println("Seleccione acion de la maquina");
                System.out.println("[1] insertar dinero." +
                        "\n[2] seleccionar producto" +
                        "\n[3] Inventario ");
                System.out.println( "0 para salir");

                opcion = sc.nextInt();

                switch (opcion){
                    case 1:
                        System.out.println("|");
                        System.out.println("Click en Insertando Dinero");
                        System.out.println("|");
                        vendingState.clickOnInsertCoinButton(vendingMachine);
                        boolean redoMoney = true;
                        int opcionMoney;
                        do {
                            vendingState = vendingMachine.getVendingMachineState();
                            System.out.println("[1] insertat NCKEL. \n[2] insertar QUARTER. \n[0] Salir.");
                            opcionMoney = sc.nextInt();
                            switch (opcionMoney){
                                case 1:
                                    vendingState.insertCoin(vendingMachine, Coin.NICKEL);
                                    break;
                                case 2:
                                    vendingState.insertCoin(vendingMachine, Coin.QUARTER);
                                    break;
                                case 0:
                                    redoMoney=false;
                                    break;
                            }
                        }while (redoMoney);
                        break;

                    case 2:
                        System.out.println("|");
                        System.out.println("Click en Seleccionando producto");
                        System.out.println("|");
                        vendingState.clickOnStartProductSelectionButton(vendingMachine);
                        vendingState = vendingMachine.getVendingMachineState();
                        displayInventory(vendingMachine);
                        int producto;
                        System.out.println("Digite el producto:");
                        producto =sc.nextInt();
                        vendingState.chooseProduct(vendingMachine, producto);
                        System.out.println("Producto Despachando.1");
                        break;
                    case 3:
                        System.out.println("|");
                        System.out.println("Click en inventario");
                        System.out.println("|");
                        System.out.println("Porfavor logearse");
                        boolean redoAuten = true;
                        int aut;
                        do{
                            System.out.println("[1] Usuario y contraseña" +
                                    "\n[2] Pin" +
                                    "\n[3] Redes Sociales" +
                                    "\n[0] Salir");
                            aut = sc.nextInt();
                            switch (aut){
                                case 1:
                                    int intentos = 0;
                                    LoginUser loginUser = new LoginUser();
                                    if(loginUser.loginUser()){
                                        displayInventory(vendingMachine);
                                        System.out.println("Ingrese codigo de item a actualizar:");
                                        int codeNumber = sc.nextInt();
                                      }else{
                                        intentos++;
                                        if(intentos>=3){
                                            break;
                                        }
                                    }
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    break;
                                case 0:
                                    redoAuten = false;
                                    break;
                            };
                        }while(redoAuten);


                        break;
                    case 0:
                        redo = false;
                        break;
                }


            }while(redo);

        }
        catch (Exception e){
            //displayInventory(vendingMachine);
        }


    }

    private static void fillUpInventory(VendingMachine vendingMachine){
        ItemShelf[] slots = vendingMachine.getInventory().getInventory();
        for (int i = 0; i < slots.length; i++) {
            Item newItem = new Item();
            if(i >=0 && i<3) {
                newItem.setType(ItemType.COKE);
                newItem.setPrice(12);
            }else if(i >=3 && i<5){
                newItem.setType(ItemType.PEPSI);
                newItem.setPrice(9);
            }else if(i >=5 && i<7){
                newItem.setType(ItemType.JUICE);
                newItem.setPrice(13);
            }else if(i >=7 && i<10){
                newItem.setType(ItemType.SODA);
                newItem.setPrice(7);
            }
            slots[i].setItem(newItem);
            slots[i].setSoldOut(false);
        }
    }

    private static void displayInventory(VendingMachine vendingMachine){

        ItemShelf[] slots = vendingMachine.getInventory().getInventory();
        for (int i = 0; i < slots.length; i++) {

            System.out.println("CodeNumber: " + slots[i].getCode() +
                    " Item: " + slots[i].getItem().getType().name() +
                    " Price: " + slots[i].getItem().getPrice() +
                    " isAvailable: " + !slots[i].isSoldOut());
        }
    }
}

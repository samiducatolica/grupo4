package LowLevelDesign.DesignVendingMachine.Autenticacion;

import LowLevelDesign.DesignVendingMachine.User;
import LowLevelDesign.DesignVendingMachine.VendingMachine;

import java.util.Scanner;

public class LoginUser implements Autentificacion {

    private User currentUser;
    private int loginAttempts;

    public LoginUser() {
        this.currentUser = null;
        this.loginAttempts = 0;
    }

    @Override
    public boolean loginUser() throws Exception {
        boolean respuesta = false;
        if (currentUser != null) {
            System.out.println("Ya hay un usuario autenticado.");
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese su nombre de usuario: ");
        String username = scanner.nextLine();
        System.out.println("Ingrese su contraseña: ");
        String password = scanner.nextLine();

        User admin = new User("4dm1nv","V3nd1Ma5h");


        if (username.equals(admin.getUsername()) && password.equals(admin.getPassword()) ) {
            System.out.println("Autenticación exitosa.");
            currentUser = new User(username, password);
            respuesta = true;
        } else {
            loginAttempts++;
            System.out.println("Nombre de usuario o contraseña incorrectos.");
            if (loginAttempts >= 3) {
                System.out.println("Usuario bloqueado. Contacte al administrador.");
            }
        }
        return respuesta;
    }

    @Override
    public void loginPatron() throws Exception {
        throw new Exception("No implementado");
    }

    @Override
    public void loginRedesSociales() throws Exception {
        throw new Exception("No implementado");
    }
}

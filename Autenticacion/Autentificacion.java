package LowLevelDesign.DesignVendingMachine.Autenticacion;

import LowLevelDesign.DesignVendingMachine.VendingMachine;

public interface Autentificacion  {

    public boolean loginUser( ) throws Exception;

    public void loginPatron( ) throws Exception;

    public void loginRedesSociales( ) throws Exception;
}

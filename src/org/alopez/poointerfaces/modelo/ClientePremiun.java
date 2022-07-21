package org.alopez.poointerfaces.modelo;

public class ClientePremiun extends Cliente implements Comparable<ClientePremiun>{
    //Clase que extiende de Cliente y además implementa la interfaz Comparable e implementa el metodo <ClientePremium>

    public ClientePremiun(String nombre, String apellido) {
        super(nombre, apellido);
    }

    @Override
    public int compareTo(ClientePremiun o) {
        return 0;
    }
}
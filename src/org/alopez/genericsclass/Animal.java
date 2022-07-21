package org.alopez.genericsclass;

public class Animal {

    private String nombre;
    private String tipo;

    public Animal(String nombre, String tipo) { //Constructor que pasa ambos atributos
        this.nombre = nombre;
        this.tipo = tipo;
    }

    //Getter de ambos atributos
    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

}
package org.alopez.poointerfaces.modelo;

public class Cliente extends EntidadGenerica{ //Clase que extiende la clase EntidadGenerica

    private String nombre;
    private String apellido;


    //Constructor para pasar nombre y apellido
    public Cliente(String nombre, String apellido) {
        super(); //Agregamos este para pasar el id del constructor de arriba
        this.nombre = nombre;
        this.apellido = apellido;
    }


    //Getter and Setter de nombre y apellido
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'';
    }

}
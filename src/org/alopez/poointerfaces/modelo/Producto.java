package org.alopez.poointerfaces.modelo;

public class Producto extends EntidadGenerica{ //Clase que hereda de la clase EntidadGenerica

    private String descripcion;
    private Double precio;

    public Producto(String descripcion, double precio) { //Constructor que pasa descripcion y precio
        super(); //Va al super de la clase padre para inicializar el id
        this.descripcion = descripcion;
        this.precio = precio;
    }

    //Getter and Setter de descripcion y precio
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio;
    }
}
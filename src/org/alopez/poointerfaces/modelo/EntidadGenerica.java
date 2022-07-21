package org.alopez.poointerfaces.modelo;

import java.util.Objects;

public class EntidadGenerica {

    protected Integer id;
    private static int ultimoId;

    //Creamos un constructor vacio y asignamos el ID
    public EntidadGenerica() {
        this.id = ++ultimoId; //Preincremento de ultimoId para generar un id de manera automatica
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    //Implementacion de equals con clic derecho Generate -> equals() and hashCode() -> Next -> elegimos solo id -> Next -> Next -> Finish

    @Override
    public boolean equals(Object o) { //Implementamos el equals para que compare objetos para poder borrar en ClienteListRepositorio
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntidadGenerica entidad = (EntidadGenerica) o;
        return Objects.equals(id, entidad.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

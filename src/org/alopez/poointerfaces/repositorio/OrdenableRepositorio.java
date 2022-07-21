package org.alopez.poointerfaces.repositorio;

import java.util.List;

public interface OrdenableRepositorio<T> { //Al usar <T> indicamos que la interfaz usa genericos

/*
    List<Cliente> listar(String campo, Direccion dir); //Sobrecarga de metodo de la interfaz Crud repositorio, pasamos por
    //argumento el nombre del campo por el cual queremos ordenar y la direccion si es ascendente o descendente
*/

    //Cambiamos a que la Interfaz use genericos
    List<T> listar(String campo, Direccion dir); //Sobrecarga de metodo de la interfaz Crud repositorio, pasamos por
    //argumento el nombre del campo por el cual queremos ordenar y la direccion si es ascendente o descendente

}

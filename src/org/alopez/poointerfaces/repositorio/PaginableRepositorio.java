package org.alopez.poointerfaces.repositorio;

import java.util.List;

public interface PaginableRepositorio<T> { //Al usar <T> indicamos que la interfaz usa genericos

//    List<Cliente> listar(int desde, int hasta); //Rango desde donde se quiere paginar, hasta donde

    //Cambiamos a que la Interfaz use genericos
    List<T> listar(int desde, int hasta); //Rango desde donde se quiere paginar, hasta donde

}

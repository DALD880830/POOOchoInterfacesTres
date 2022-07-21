package org.alopez.poointerfaces.repositorio;

//public interface OrdenablePaginableCrudRepositorio extends OrdenableRepositorio,
//        PaginableRepositorio, CrudRepositorio, ContableRepositorio{
//Extends soporta Herencia multiple de Interfaces

public interface OrdenablePaginableCrudRepositorio<T> extends OrdenableRepositorio<T>,
        PaginableRepositorio<T>, CrudRepositorio<T>, ContableRepositorio{ //Al usar <T> indicamos que la interfaz
    // usa genericos

}
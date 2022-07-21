package org.alopez.poointerfaces.repositorio;

import org.alopez.poointerfaces.modelo.EntidadGenerica;
import org.alopez.poointerfaces.repositorio.excepciones.*;

import java.util.ArrayList;

import java.util.List;

public abstract class AbstractListRepositorio<T extends EntidadGenerica> implements OrdenablePaginableCrudRepositorio<T>{
//public class ClienteListRepositorio implements OrdenablePaginableCrudRepositorio<Cliente>{ //Definimos el tipo <Cliente> del uso de interfaz con genericos
//public class ClienteListRepositorio implements CrudRepositorio, OrdenableRepositorio,
//        PaginableRepositorio{ //Clase que implementa multiples interfaces,
    //con cada nueva implementación de interfaz, se deben implementar los metodos de dicha interfaz

    protected List<T> dataSource;

    public AbstractListRepositorio() { //Generamos un constructor vacio e inicializamos el ArrayList

        this.dataSource = new ArrayList<>();

    }

    @Override
    public List<T> listar() { //Método de la interfaz CrudRepositorio
        return dataSource; //Retorna la lista
    }

    @Override
    public T porId(Integer id) throws LecturaAccesoDatoException{ //Método de la interfaz CrudRepositorio
        if (id == null || id <= 0){
            throw new LecturaAccesoDatoException("Id invalido, debe ser mayor que 0");
        }
        T resultado = null; //Cuando se encuentre el cliente, se guarda en esta variable
        for (T cli: dataSource){ //Iteramos con un for y busca cliente por cliente si coincide con el id que se pasa por argumento
            if (cli.getId().equals(id)){ //Si el id del cliente es igual al id que se pasa por argumento
                resultado=cli; //Si son iguales, resultado es igual a cli
                break; //Salimos del for
            }
        }
        if (resultado == null){ //Si el resultado es igual a null, arrojamos una excepcion
            throw new LecturaAccesoDatoException("No existe el registro con id: " + id);
        }
        return resultado; //Se retorna el cliente encontrado
    }


    @Override
    public void crear(T t) throws EscrituraAccesoDatoException { //Método de la interfaz CrudRepositorio
        if (t == null){
            throw new EscrituraAccesoDatoException("Error al insertar un objeto null");
        }
        if (this.dataSource.contains(t)){ //El contains, busca el objeto, si ya existe entonces
            throw new RegistroDuplicadoAccesoDatoException(t.getId() + "el id ya existe");
        }
        this.dataSource.add(t); //Agregamos un cliente
    }

    @Override
    public void eliminar(Integer id) throws LecturaAccesoDatoException{ //Método de la interfaz CrudRepositorio
        this.dataSource.remove(this.porId(id)); //this.porId(id) busca el cliente por id con el id que se recibe por argumente
        //this.dataSource.remove() removemos el objeto del ArrayList
    }

    @Override
    public List<T> listar(int desde, int hasta) { //Método de la interfaz PaginableRepositorio
        return dataSource.subList(desde, hasta); //Sublist es un subconjunto de la lista
    }

    @Override
    public int total() {
        return this.dataSource.size(); //Nos genera un contador de registros
    }
}
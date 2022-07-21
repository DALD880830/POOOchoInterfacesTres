package org.alopez.poointerfaces.repositorio.lista;

import org.alopez.poointerfaces.modelo.Cliente;
import org.alopez.poointerfaces.repositorio.AbstractListRepositorio;
import org.alopez.poointerfaces.repositorio.Direccion;
import org.alopez.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClienteListRepositorio extends AbstractListRepositorio<Cliente> { //Clase que hereda de la clase abstracta y pasamos el tipo generico Cliente

//public class ClienteListRepositorio implements OrdenablePaginableCrudRepositorio<Cliente>{ //Definimos el tipo <Cliente> del uso de interfaz con genericos
//public class ClienteListRepositorio implements CrudRepositorio, OrdenableRepositorio,
//        PaginableRepositorio{ //Clase que implementa multiples interfaces,
    //con cada nueva implementación de interfaz, se deben implementar los metodos de dicha interfaz

    @Override
    public void editar(Cliente cliente) throws LecturaAccesoDatoException { //Método de la interfaz CrudRepositorio
        Cliente c = this.porId(cliente.getId()); //Obtenemos el cliente que se encuentra en la lista
        //c los buscamos usando el metodo porId, el cual viene en el onjeto cliente
        c.setNombre(cliente.getNombre()); //Modificamos los datos con el nombre del cliente que se recibe por argumento
        c.setApellido(cliente.getApellido());
    }

    @Override
    public List<Cliente> listar(String campo, Direccion dir) { //Método de la interfaz OrdenableRepositorio
        List<Cliente> listaOrdenada = new ArrayList<>(this.dataSource);
        listaOrdenada.sort(new Comparator<Cliente>() { //Implementamos la interfaz Comparator
            @Override
            public int compare(Cliente a, Cliente b) { //Compara los objetos
                int resultado = 0; //Retorna un entero que corresponde al orden de la tabla Unicode
                if (dir == Direccion.ASC){ //Si dir es igual a direccion ascendente
                    switch (campo){ //Inicializamos un switch que recibe el campo
                        case "id" -> //Para campo id, compara id de a con id de b
                                resultado = a.getId().compareTo(b.getId());
                        case "nombre" -> //Para campo nombre
                                resultado = a.getNombre().compareTo(b.getNombre());
                        case "apellido" -> //Para campo apellido
                                resultado = a.getApellido().compareTo(b.getApellido());
                    }
                }else if(dir == Direccion.DESC){ //Si dir es igual a direccion descendente
                    switch (campo){
                        case "id" -> //Para campo id, compara b con a
                                resultado = b.getId().compareTo(a.getId());
                        case "nombre" ->
                                resultado = b.getNombre().compareTo(a.getNombre());
                        case "apellido" ->
                                resultado = b.getApellido().compareTo(a.getApellido());
                    }
                }
                return resultado;
            }
        }); //Cualquier implementación de un List tiene el metodo sort, recibe la implementacion de una
        //interfaz funcional "Comparator" podemos comparar y ordenar cualquier tipo de objeto
        return listaOrdenada; //Retornamos la lista
    }

}
package org.alopez.poointerfaces.repositorio.lista;

import org.alopez.poointerfaces.modelo.Producto;
import org.alopez.poointerfaces.repositorio.AbstractListRepositorio;
import org.alopez.poointerfaces.repositorio.Direccion;
import org.alopez.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;

import java.util.ArrayList;
import java.util.List;

public class ProductoListRepositorio extends AbstractListRepositorio<Producto> { //Clase que hereda de la clase abstracta y pasamos el tipo generico Producto

    //Implementacion de los metodos
    @Override
    public void editar(Producto producto) throws LecturaAccesoDatoException {
        Producto p = porId(producto.getId()); //Obtenemos el producto que se encuentra en la lista p los buscamos usando
        // el metodo porId, /Modificamos los datos con el nombre y el precio del producto que se recibe por argumento
        p.setDescripcion(producto.getDescripcion());
        p.setPrecio(producto.getPrecio());
    }

    @Override
    public List<Producto> listar(String campo, Direccion dir) { //Método de la interfaz OrdenableRepositorio
        List<Producto> listaOrdenada = new ArrayList<>(this.dataSource);
        listaOrdenada.sort((a, b) -> { //Implementamos la interfaz Comparator
            int resultado = 0; //Retorna un entero que corresponde al orden de la tabla Unicode
            if (dir == Direccion.ASC){ //Si dir es igual a direccion ascendente
                switch (campo){ //Inicializamos un switch que recibe el campo
                    case "id" -> //Para campo id, compara id de a con id de b
                            resultado = a.getId().compareTo(b.getId());
                    case "descripcion" -> //Para campo nombre
                            resultado = a.getDescripcion().compareTo(b.getDescripcion());
                    case "precio" -> //Para campo apellido
                            resultado = a.getPrecio().compareTo(b.getPrecio());
                }
            }else if(dir == Direccion.DESC){ //Si dir es igual a direccion descendente
                switch (campo){
                    case "id" -> //Para campo id, compara b con a
                            resultado = b.getId().compareTo(a.getId());
                    case "descripcion" ->
                            resultado = b.getDescripcion().compareTo(a.getDescripcion());
                    case "precio" ->
                            resultado = b.getPrecio().compareTo(a.getPrecio());
                }
            }
            return resultado;
        }); //Cualquier implementación de un List tiene el metodo sort, recibe la implementacion de una
        //interfaz funcional "Comparator" podemos comparar y ordenar cualquier tipo de objeto
        return listaOrdenada; //Retornamos la lista
    }
}

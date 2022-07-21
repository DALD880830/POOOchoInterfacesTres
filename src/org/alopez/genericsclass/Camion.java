package org.alopez.genericsclass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Camion<T> implements Iterable<T>{ //Con Iterable, cualquier objeto que implemente esta Interfaz se puede Iterar con un For each
//Despues el nombre de la clase se coloca <T> para indicar que la clase tiene un parametro genérico
//También lo colocamos despues del nombre de la Interfaz

    //    private List objetos; //Lista de objetos | Antes de definir que la clase tiene un parametro generico
    private List<T> objetos; //Lista de objetos
    private int max; //Maximo de elementos a transportar

    public Camion(int max) {
        this.max = max;
        this.objetos = new ArrayList<>(); //Inicializamos objetos
    }

    //    public void add(Object objeto){ //Metodo para adherir objetos a la lista | Antes de definir que la clase tiene un parametro generico
    public void add(T objeto){ //Metodo para adherir objetos a la lista
        if (this.objetos.size() <= max){ //Si el numero de objetos es menor o igual a max, que es el numero de elementos de la lista
            this.objetos.add(objeto); //Adherimos objeto a la lista
        }else{ //Si es mayor a max
            throw new RuntimeException("no hay mas espacio"); //Arrojamos una excepecion
        }

    }

    @Override
    public Iterator<T> iterator() {
        return this.objetos.iterator(); //Iteramos la lista objetos
    }
}

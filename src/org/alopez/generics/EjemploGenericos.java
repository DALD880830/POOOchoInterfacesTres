package org.alopez.generics;

import org.alopez.poointerfaces.modelo.Cliente;
import org.alopez.poointerfaces.modelo.ClientePremiun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploGenericos {

    public static void main(String[] args) {

        List<Cliente> clientes = new ArrayList<>(); //Las listas trabajan con genéricos | Esto es una lista de clientes
        //Con List<Cliente> indicamos de forma explicita que el arraylist sera del tipo Cliente

        clientes.add(new Cliente("Alejandro", "Lopez")); //Clientes add permite adherir clientes a la lista
        //al manejar genericos de Java, por defecto debe ser del tipo Object, por ello agregamos new Cliente

        Cliente alejandro = clientes.get(0); //0 es el indice de la lista, al partir en 0, obtenemos el cliente creado
        //debemos indicar de forma explicita de que tipo es el Objeto, por ello, realizamos el CAST (Cliente), aunque, si en
        //List agregamos que la lista sera de tipo Cliente List<Cliente>, entonces ya no se necesita el CAST

//        Cliente alejandro = (Cliente)clientes.iterator().next(); //Con itarator().next() podemos obtener el primer elemento

        Cliente[] clientesArreglo = {new Cliente("Alejandro", "Lopez"),
                new Cliente("Daniel", "Delgado")}; //Creamos un arreglo de clientes, en el que adherimos
        // 2 clientes, para despues transformarlos a lista
        Integer[] enteros = {1,2,3}; //Usando el metodo generico tambien podemos convertir un arreglo de enteros, lo creamos con 3 numeros

        List<Cliente> clientesToList = fromArrayToList(clientesArreglo); //Generamos una lista a partir de un arreglo, usando el metodo generico
        List<Integer> enterosToList = fromArrayToList(enteros);

        clientesToList.forEach(System.out::println); //Imprimimos las listas utilizando for each
        enterosToList.forEach(System.out::println);

        List<String> nombres = fromArrayToList(new String[]{"Alex", "Dan", "Yaz"}, enteros); //Lo que esta antes de la
        //coma, solo lo convierte, lo que esta despues de la coma lo va a covertir e imprimir
        nombres.forEach(System.out::println);

        List<ClientePremiun> clientesPremiumList = fromArrayToList(//Creamos una lista de ClientesPremium
                new ClientePremiun[]{ //Creamos un nuevo arreglo de ClientesPremium
                        new ClientePremiun("Hector", "Curiel")}); //Creamos un nuevo ClientePremium

        imprimirClientes(clientes); //Invocamos el metodo y le pasamos la lista clientes
        imprimirClientes(clientesToList);
        imprimirClientes(clientesPremiumList);

        System.out.println("Maximo de 1, 9 y 4 es: " + maximo(1,9,4));
        System.out.println("Maximo de 7.78, 3.9 y 11.6 es: " + maximo(7.78,3.9,11.6));
        System.out.println("Maximo de zanahoria, arándano, manzana es : " +
                maximo("zanahoria", "arándano", "manzana"));


    }

    public static <T> List<T> fromArrayToList(T[] c){
        return Arrays.asList(c); //Arrays.asList() Puede recibir un arreglo y convertirlo a una lista
        //<T> Indica que vamos a utilizar un método genérico, en este caso ya no solo convertira Clientes, si no tammbien
        //pueden ser numeros o arreglo de Strings
    }

    //    public static List<Cliente> fromArrayToList(Cliente[] c){ //Metodo estático generico de Java, convertir un arreglo en una lista
    public static <T extends Number> List<T> fromArrayToList(T[] c){ //Limitamos el metodo para que solo acepte tipos Number
        return Arrays.asList(c); //Arrays.asList() Puede recibir un arreglo y convertirlo a una lista
        //<T> Indica que vamos a utilizar un método genérico, en este caso solo convertira numeros
    }

    public static <T extends Cliente & Comparable<T>> List<T> fromArrayToList(T[] c){ //Este metodo acepta cualquier tipo generico del
        //tipo Cliente y las subclases, clases que heredan de Cliente, y que implementen la interfaz Comparable del tipo generico con <T>
        return Arrays.asList(c);
    }


    public static <T, G> List<T> fromArrayToList(T[] c, G[] x){
        for(G elemento: x){ //Tipo G, variable elemento : del origen x
            System.out.println(elemento); //Imprimimos elemento
        }
        return Arrays.asList(c);
//        <T, G> | Junto a static se definen los tipos genericos como parametros
//        T[] c, G[] g | El tipo T es un arreeglo, aunque el tipo G no necesariamente debe ser un arreglo
    }

    public static void imprimirClientes(List<? extends Cliente> clientes){ //Los comodines o Wildcards solo se pueden
        // utilizar en listas <? extends>
        //Es void porque solo va a imprimir un dato, recibe una lista de clientes
        clientes.forEach(System.out::println);
    }

    public static <T extends Comparable<T>> T maximo(T a, T b, T c){ //Metodo para comparar entre 3 objetos y retornar
        //el que tenga mayor valor | Comparable es un tipo de la interfaz que contiene el CompareTo
        T max = a; //Definimos que a es el valor maximo
        if(b.compareTo(max) > 0){ //Si b compareTo max si es mayor que cero | Invocamos compareTo porque es un tipo de Comparable
            max = b; //Entonces max es igual b
        }
        if(c.compareTo(max) > 0){ //Si c es mayor que maximo, entonces max es igual a c
            max = c;
        }
        return max;
    }

}

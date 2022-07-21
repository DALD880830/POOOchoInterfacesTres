package org.alopez.poointerfaces;

import org.alopez.poointerfaces.modelo.Producto;
import org.alopez.poointerfaces.repositorio.Direccion;
import org.alopez.poointerfaces.repositorio.OrdenablePaginableCrudRepositorio;
import org.alopez.poointerfaces.repositorio.excepciones.AccesoDatosException;
import org.alopez.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;
import org.alopez.poointerfaces.repositorio.lista.ProductoListRepositorio;

import java.util.List;

public class EjemploRepositorioProducto {

    public static void main(String[] args) {

        try {
            //Si colocamos la interfaz OrdenablePaginableCrudRepositorio que agrupa todo, ya no hay necesidad de hacer CAST en ningun lado
            OrdenablePaginableCrudRepositorio<Producto> repo = new ProductoListRepositorio(); //Creamos una instancia de ClienteListRepositorio, Está
//implementada en la interfaz, por ello se utiliza OrdenablePaginableCrudRepositorio y en el new colocamos la implementación concreta
            //Despues de OrdenablePaginableCrudRepositorio pasamos el tipo generico Cliente

            //Implementacion como DAO data access object

            //Insertamos nuevos registros
            repo.crear(new Producto("mesa", 50.50)); //usamos crear, dentro de crear, instanciamos un nuevo cliente
            repo.crear(new Producto("silla", 18.59));
            repo.crear(new Producto("lampara", 10.99));
            repo.crear(new Producto("banco", 25.15));

            List<Producto> productos = repo.listar(); //Creamos la variable tipo List, vemos la lista de cliente con repo.listar()
            productos.forEach(c -> System.out.println(c)); //Recorremos la lista de clientes e imprimimos cada cliente con su id

            System.out.println();

            List<Producto> paginable = repo.listar(1, 3); //Obtenemos un subconjunto de la lista
            //Para ello se debe hacer un cast ((PaginableRepositorio)repo) //Desde el indice hasta el 3, pero 3 no se incluye
            paginable.forEach(System.out::println); //Este print hace lo mismo que el der arriba, solo cambia porque se utilizan
            //expresiones lambda //Recorremos la lista del subconjunto de clientes e imprimimos cada cliente con su id

            System.out.println();

            List<Producto> productosOrdenAsc = repo.listar("descripcion", Direccion.ASC); //Ordenamos la lista popr nombre de manera ascendente
            for (Producto c : productosOrdenAsc) { //Recorremos la lista de clientes que ya cuentan con una dirección ascendente
                System.out.println(c);
            }

            System.out.println();

            Producto lamparaActualizar = new Producto("lampara escritorio", 15.99); //Generamos un nuevo cliente con los nombres cambiado
            lamparaActualizar.setId(3); //Cambiamos el id, para que el nuevo usuario quede en ese id 2
            repo.editar(lamparaActualizar); //Pasamos los datos del usuario cambiado
            Producto lampara = repo.porId(3); //Buscamos el cliente por id y lo asignamos a la varible daniel
            System.out.println(lampara);

            System.out.println();

            repo.eliminar(2); //Eliminams el id 2 de la lista
            repo.listar().forEach(System.out::println);

            System.out.println();
            System.out.println("Total registros: " + repo.total()); //Obtenemos el total de registros
            //y los imprimimos, usamos el CAST de ContableRepositorio, aunque si implementamos la interfaz que agrupa todo
            //ya no hay necesidad de colocar el CAST

        } catch (LecturaAccesoDatoException lade) { //Siempre van primero las excepciones hijas y despues la padre
            System.out.println(lade.getMessage()); //Imprimimos
            lade.printStackTrace();
        } catch (AccesoDatosException ade) {
            System.out.println(ade.getMessage());
            ade.printStackTrace();
        }
    }

}

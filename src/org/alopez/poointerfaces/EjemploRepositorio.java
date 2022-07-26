package org.alopez.poointerfaces;

import org.alopez.poointerfaces.modelo.Cliente;
import org.alopez.poointerfaces.repositorio.*;
import org.alopez.poointerfaces.repositorio.excepciones.AccesoDatosException;
import org.alopez.poointerfaces.repositorio.excepciones.EscrituraAccesoDatoException;
import org.alopez.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;
import org.alopez.poointerfaces.repositorio.excepciones.RegistroDuplicadoAccesoDatoException;
import org.alopez.poointerfaces.repositorio.lista.ClienteListRepositorio;

import java.util.List;

public class EjemploRepositorio {

    public static void main(String[] args) {

        try {
            //Si colocamos la interfaz OrdenablePaginableCrudRepositorio que agrupa todo, ya no hay necesidad de hacer CAST en ningun lado
            OrdenablePaginableCrudRepositorio<Cliente> repo = new ClienteListRepositorio(); //Creamos una instancia de ClienteListRepositorio, Está
//implementada en la interfaz, por ello se utiliza OrdenablePaginableCrudRepositorio y en el new colocamos la implementación concreta
            //Despues de OrdenablePaginableCrudRepositorio pasamos el tipo generico Cliente

            //Implementacion como DAO data access object

            //Insertamos nuevos registros
            repo.crear(new Cliente("Alejandro", "López")); //usamos crear, dentro de crear, instanciamos un nuevo cliente
            repo.crear(new Cliente("Daniel", "Delgado"));
            repo.crear(new Cliente("Delgado", "Alejandro"));
            repo.crear(new Cliente("López", "Daniel"));

            List<Cliente> clientes = repo.listar(); //Creamos la variable tipo List, vemos la lista de cliente con repo.listar()
            clientes.forEach(c -> System.out.println(c)); //Recorremos la lista de clientes e imprimimos cada cliente con su id

            System.out.println();

            List<Cliente> paginable = repo.listar(1, 3); //Obtenemos un subconjunto de la lista
            //Para ello se debe hacer un cast ((PaginableRepositorio)repo) //Desde el indice hasta el 3, pero 3 no se incluye
            paginable.forEach(System.out::println); //Este print hace lo mismo que el der arriba, solo cambia porque se utilizan
            //expresiones lambda //Recorremos la lista del subconjunto de clientes e imprimimos cada cliente con su id

            System.out.println();

            List<Cliente> clientesOrdenAsc = repo.listar("nombre", Direccion.ASC); //Ordenamos la lista popr nombre de manera ascendente
            for (Cliente c : clientesOrdenAsc) { //Recorremos la lista de clientes que ya cuentan con una dirección ascendente
                System.out.println(c);
            }

            System.out.println();

            Cliente danielActualizar = new Cliente("Daniel", "Apellido"); //Generamos un nuevo cliente con los nombres cambiado
            danielActualizar.setId(2); //Cambiamos el id, para que el nuevo usuario quede en ese id 2
            repo.editar(danielActualizar); //Pasamos los datos del usuario cambiado
            Cliente daniel = repo.porId(2); //Buscamos el cliente por id y lo asignamos a la varible daniel
            System.out.println(daniel);

            System.out.println();

            repo.eliminar(2); //Eliminams el id 2 de la lista
            repo.listar().forEach(System.out::println);

            System.out.println();
            System.out.println("Total registros: " + repo.total()); //Obtenemos el total de registros
            //y los imprimimos, usamos el CAST de ContableRepositorio, aunque si implementamos la interfaz que agrupa todo
            //ya no hay necesidad de colocar el CAST
        } catch (RegistroDuplicadoAccesoDatoException rdade){
            System.out.println(rdade.getMessage());
            rdade.printStackTrace();
        } catch (LecturaAccesoDatoException lade) { //Siempre van primero las excepciones hijas y despues la padre
            System.out.println(lade.getMessage()); //Imprimimos el error
            lade.printStackTrace(); //Imprimimos la ruta del error
        } catch (EscrituraAccesoDatoException eade){
            System.out.println(eade.getMessage()); //Imprimimos
            eade.printStackTrace();
        } catch (AccesoDatosException ade){
            System.out.println(ade.getMessage());
            ade.printStackTrace();
        }
    }
}
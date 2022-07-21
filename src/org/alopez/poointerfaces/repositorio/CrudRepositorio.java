package org.alopez.poointerfaces.repositorio;

import org.alopez.poointerfaces.repositorio.excepciones.AccesoDatosException;

import java.util.List;

public interface CrudRepositorio<T> { //Al usar <T> indicamos que la interfaz usa genericos

/*    List<Cliente> listar(); //Obtenemos todos los clientes //Esta interfaz se puede implementar con base de datos,
    //api rest, un arreglo, un array list, incluso en un xml
    Cliente porId(Integer id); //Metodo para obtener el cliente por id
    void crear(Cliente cliente); //Crea un cliente en el repositorio, se crea un cliente desde cero
    void editar(Cliente cliente); //Edita un cliente ya existente
    void eliminar(Integer id); //Elimina un cliente por Id
*/

    //Cambiamos a que la Interfaz use genericos
    List<T> listar(); //Obtenemos todos los clientes //Esta interfaz se puede implementar con base de datos,
    //api rest, un arreglo, un array list, incluso en un xml

    T porId(Integer id) throws AccesoDatosException; //Metodo para obtener el cliente por id

    void crear(T objeto) throws AccesoDatosException; //Crea un cliente en el repositorio, se crea un cliente desde cero
    void editar(T objeto) throws AccesoDatosException; //Edita un cliente ya existente
    void eliminar(Integer id) throws AccesoDatosException; //Elimina un cliente por Id

}

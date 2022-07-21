package org.alopez.genericsclass;

public class EjemploGenericos {


    public static <T> void imprimirCamion(Camion<T> camion){ //Metodo generico para imprimir la lista de objetos en camion
        for(T a : camion){ //Para generico T con variable a del origen camion
            if (a instanceof Animal){ //Si a es instancia de Animal, entonces imprime
                System.out.println("Nombre: " + ((Animal)a).getNombre() + " tipo: " + ((Animal)a).getTipo()); //Es necesario hacer el CAST
            }
            else if (a instanceof Automovil){ //Si a es instancia de Automovil, entonces imprime
                System.out.println("Marca: " + ((Automovil)a).getMarca()); //Es necesario hacer el CAST
            }
            else if (a instanceof Maquinaria){ //Si a es instancia de Maquinaria, entonces imprime
                System.out.println("Tipo: " + ((Maquinaria)a).getTipo()); //Es necesario hacer el CAST
            }
        }
    }


    public static void main(String[] args) {

//        Camion transporteCaballos = new Camion(5); | Antes de definir que la clase tiene un parametro generico
        Camion<Animal> transporteCaballos = new Camion<>(5); //Inicializamos un nuevo camion que transporta 5 objetos
        transporteCaballos.add(new Animal("Peregrino", "Caballo")); //Adherimos los objetos a la lista
        transporteCaballos.add(new Animal("Rayo", "Caballo"));
        transporteCaballos.add(new Animal("Epona", "Caballo"));
        transporteCaballos.add(new Animal("Vaquero", "Caballo"));
        transporteCaballos.add(new Animal("Doc", "Caballo"));

//        for(Object o: transporteCaballos){ //Del tipo object, recorremos la lista de transporteCaballos
//            Animal a = (Animal) o; //Hacemos el CAST para que object ahora sea animal | Antes de definir que la clase tiene un parametro generico
/*        for(Animal a: transporteCaballos){
            System.out.println("Nombre: " + a.getNombre() + " tipo: " + a.getTipo()); //Imprimimos el nombre y el tipo de Animal
        }
*/
        imprimirCamion(transporteCaballos); //Imprimir la lista usando el metodo generico

        Camion<Maquinaria> transporteMaquinaria = new Camion<>(3); //Inicializamos un nuevo camion que transporta 3 objetos
        transporteMaquinaria.add(new Maquinaria("Bulldozer")); //Adherimos los objetos a la lista
        transporteMaquinaria.add(new Maquinaria("Grua"));
        transporteMaquinaria.add(new Maquinaria("Perforadora"));

//        for(Object o: transporteMaquinaria){ //Del tipo object, recorremos la lista de transporteMaquinaria
//            Maquinaria m = (Maquinaria) o; //Hacemos el CAST para que object ahora sea maquinaria | Antes de definir que la clase tiene un parametro generico
/*        for(Maquinaria m: transporteMaquinaria){
            System.out.println("Tipo: " + m.getTipo()); //Imprimimos el tipo de maquinaria
        }
*/
        imprimirCamion(transporteMaquinaria); //Imprimir la lista usando el metodo generico

        Camion<Automovil> transporteAutos = new Camion<>(3); //Inicializamos un nuevo camion que transporta 3 objetos
        transporteAutos.add(new Automovil("Ford")); //Adherimos los objetos a la lista
        transporteAutos.add(new Automovil("Nissan"));
        transporteAutos.add(new Automovil("Suzuki"));

//        for(Object o: transporteAutos){ //Del tipo object, recorremos la lista de transporteMaquinaria
//            Automovil a = (Automovil) o; //Hacemos el CAST para que object ahora sea maquinaria | Antes de definir que la clase tiene un parametro generico
/*        for(Automovil a: transporteAutos){
            System.out.println("Marca: " + a.getMarca()); //Imprimimos el tipo de maquinaria
        }
*/
        imprimirCamion(transporteAutos); //Imprimir la lista usando el metodo generico

    }

}
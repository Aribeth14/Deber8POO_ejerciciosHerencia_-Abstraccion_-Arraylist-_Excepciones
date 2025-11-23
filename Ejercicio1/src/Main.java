//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Año invalido
        try{
            new Auto("Kia","Soluto",1800,10000);
        }catch(IllegalArgumentException e){
            System.out.println("Error: "+e.getMessage());
        }
        //Precio negativo
        try{
            new Moto("Honda","XR",2020,-2000,250);
        }catch (IllegalArgumentException e){
            System.out.println("Error: "+e.getMessage());
        }
        Concesionaria conc=new Concesionaria();
        //Impuestos con lista vacia
        try{
            conc.calcularTotalImpuestos();
        }catch (IllegalStateException e){
            System.out.println("Error: "+e.getMessage());
        }

        //Agregar 6 vehiculos
        conc.agregarVehiculo(new Auto("Mazda","MY3",2023,23000,4));
        conc.agregarVehiculo(new Auto("Chevrolet","Onix",2022,15000,4));
        conc.agregarVehiculo(new Moto("Honda","CB190",2023,5000,190));
        conc.agregarVehiculo(new Moto("Yamaha","R3",2024,8000,321));
        conc.agregarVehiculo(new Camion("Volvo","FH",2021,90000,20));
        conc.agregarVehiculo(new Camion("MAN","TGX",2023,110000,25));

        //Total impuestos
        System.out.println("Total Impuestos: "+conc.calcularTotalImpuestos());
        //Vehiculo mas caro
        System.out.println("Vehiculo mas caro: ");
        System.out.println(conc.obtenerVehiculoMasCaro());
        //Ordenar por precio
        System.out.println("Ordenar por Precio: ");
        conc.ordenarPorPrecio();
        //Mostrar Informacion
        conc.mostrarInventario();
    }
}
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Concesionaria {
    private ArrayList<Vehiculo> inventario=new ArrayList<>();

    public void agregarVehiculo(Vehiculo veh){
        if(veh==null)
            throw new NullPointerException("Vehiculo nulo.");
        inventario.add(veh);
    }
    public double calcularTotalImpuestos(){
        if(inventario.isEmpty())
            throw new IllegalStateException("Inventario vacio");

        double total=0;
        for(Vehiculo veh:inventario){
            total +=veh.calcularImpuestoCirculacion();
        }
        return total;
    }
    public Vehiculo obtenerVehiculoMasCaro(){
        if(inventario.isEmpty())
            throw new IllegalStateException("Inventario vacio");
        Vehiculo mayor=inventario.get(0);

        for(Vehiculo veh:inventario){
            if(veh.getPrecio()>mayor.getPrecio())
                mayor=veh;
        }
        return mayor;
    }

    public void ordenarPorPrecio(){
        Collections.sort(inventario, new Comparator<Vehiculo>() {
            @Override
            public int compare(Vehiculo a, Vehiculo b) {
                return Double.compare(a.getPrecio(),b.getPrecio());
            }
        });

    }
    public void mostrarInventario(){
        for(Vehiculo veh:inventario){
            System.out.println(veh);
        }
    }

}

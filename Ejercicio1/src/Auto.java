public class Auto extends Vehiculo{
    private int numeroPuertas;

    //Constructor
    public Auto(String marca, String modelo, int anio,double precio){
        super(marca,modelo,anio,precio);
        this.numeroPuertas=4;
    }


    public Auto(String marca, String modelo, int anio,double precio,int numeroPuertas){
        super(marca,modelo,anio,precio);
        if(numeroPuertas<0)
            throw new IllegalArgumentException("Numero de puertas Invalido");

        this.numeroPuertas=numeroPuertas;
    }
    @Override
    public double calcularImpuestoCirculacion() {
        return getPrecio()*0.05;
    }

    @Override
    public String toString(){
        return "Auto: "+super.toString()+" -Puertas: "+numeroPuertas;
    }
}

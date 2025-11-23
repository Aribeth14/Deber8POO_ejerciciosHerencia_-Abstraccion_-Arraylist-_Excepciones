public abstract class Vehiculo {
    private String marca;
    private String modelo;
    private int anio;
    private double precio;

    //Constructor con validaciones
    public Vehiculo(String marca, String modelo, int anio, double precio) {
        if(marca == null || marca.isEmpty())
            throw new IllegalArgumentException("Marca invalido");
        if(modelo == null || modelo.isEmpty())
            throw new IllegalArgumentException("Modelo invalido");
        if(anio < 1900 || anio > 2025)
            throw new IllegalArgumentException("Año fuera de rango");
        if(precio <= 0 )
            throw new IllegalArgumentException("El precio debe ser mayor que 0");
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.precio = precio;
    }
    //Getter para el calculo de impuesto
    public double getPrecio() {
        return precio;
    }
    //Metodo abstracto
    public abstract double calcularImpuestoCirculacion();
    //Metodo toString


    @Override
    public String toString() {
        return "Vehiculo{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anio=" + anio +
                ", precio=" + precio +
                '}';
    }
}

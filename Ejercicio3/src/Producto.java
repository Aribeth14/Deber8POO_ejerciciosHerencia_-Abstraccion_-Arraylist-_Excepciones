public abstract class Producto {
    private String codigo;
    private String nombre;
    protected double precioBase;
    protected int stock;

    public Producto(String codigo, String nombre, double precioBase, int stock) {
        if(codigo ==null || codigo.isEmpty())
            throw new IllegalArgumentException("Codigo Invalido");
        if(nombre==null || nombre.isEmpty())
            throw new IllegalArgumentException("Nombre Invalido");
        if(precioBase<=0)
            throw new IllegalArgumentException("Precio Base debe ser mayor a 0");
        if(stock<0)
            throw new IllegalArgumentException("Stock no puede ser negativo");
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.stock = stock;
    }
    //Getters
    public String getCodigo() {
        return codigo;
    }
    public int  getStock() {
        return stock;
    }
    public String getNombre() {
        return nombre;
    }


    //Metodo abstracto
    public abstract double calcularPrecioFinal();

    @Override
    public String toString() {
        return "Producto{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precioBase=" + precioBase +
                ", stock=" + stock +
                '}';
    }
}

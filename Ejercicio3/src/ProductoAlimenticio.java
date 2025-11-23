public class ProductoAlimenticio extends Producto {
    private String fechaVencimiento;
    private boolean requiereRefrigeracion;

    public ProductoAlimenticio(String codigo, String nombre, double precioBase, int stock,String fechaVencimiento, boolean requiereRefrigeracion) {
        super(codigo, nombre, precioBase, stock);
        //Validaciones
        if(fechaVencimiento==null || fechaVencimiento.isEmpty())
            throw new IllegalArgumentException("Fecha invalida");
        this.fechaVencimiento = fechaVencimiento;
        this.requiereRefrigeracion = requiereRefrigeracion;
    }

    @Override
    public double calcularPrecioFinal() {
        return precioBase; //Iva 0%
    }
}

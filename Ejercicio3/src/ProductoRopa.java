public class ProductoRopa extends  Producto{
    private String talla;
    private String material;

    public ProductoRopa(String codigo, String nombre, double precioBase,int stock,String talla, String material) {
        super(codigo, nombre, precioBase, stock);
        //Validaciones
        if(talla==null|| talla.isEmpty())
            throw new IllegalArgumentException("El talla Invalida");
        if(material==null|| material.isEmpty())
            throw new IllegalArgumentException("Material Invalida");
        this.talla = talla;
        this.material = material;
    }

    @Override
    public double calcularPrecioFinal() {
        return precioBase*1.12;
    }
}

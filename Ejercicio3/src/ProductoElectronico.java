public class ProductoElectronico extends  Producto{
    private String marca;
    private int garantiaMeses;

    public ProductoElectronico(String codigo, String nombre, double precioBase,int stock, String marca, int garantiaMeses) {
        super(codigo, nombre, precioBase, stock);
        if(marca==null || marca.isEmpty())
            throw new IllegalArgumentException("Marca Invalida");
        if(garantiaMeses<=0)
            throw new IllegalArgumentException("Garantia Invalida");
        this.marca=marca;
        this.garantiaMeses=garantiaMeses;
    }

    @Override
    public double calcularPrecioFinal() {
        return precioBase*1.12;
    }
    //Sobrecarga
    public boolean aplicarGarantia(){
        return garantiaMeses==12;
    }
    public double aplicarGarantia(int mesesExtras){
        if(mesesExtras<=0)
            throw new IllegalArgumentException("Meses extras Invalidos");
        return mesesExtras*5.0;
    }
}

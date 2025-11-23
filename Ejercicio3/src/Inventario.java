import java.util.ArrayList;

public class Inventario {
    private ArrayList<Producto> productos;
    private String nombreTienda;

    public Inventario(String nombreTienda) {
        if(nombreTienda==null || nombreTienda.isEmpty())
            throw  new IllegalArgumentException("Nombre de tienda Invalido");
        this.nombreTienda = nombreTienda;
        this.productos = new ArrayList<>();
    }
    //Metodo Estatico
    public static String generarCodigo(String categoria){
        int numero=(int)(Math.random()*9000+1000);
        return categoria +"-"+numero;
    }
    //Agregar
    public void agregarProducto(Producto prod){
        if(prod==null)
            throw  new NullPointerException("Producto null");
        productos.add(prod);
    }
    //Buscar
    public Producto buscarPorCodigo(String codigo){
        for(Producto prod:productos){
            if(prod.getCodigo().equals(codigo))
                return prod;
        }
        throw  new ProductoNoEncontradoException("Producto no encontrado: "+codigo);
    }
    //Vender
    public double venderProducto(String codigo, int cantidad)throws StockInsuficienteException{
        if(cantidad<=0)
            throw  new IllegalArgumentException("Cantidad Invalida");
        Producto prod = buscarPorCodigo(codigo);
        if(prod.getStock() < cantidad)
            throw new StockInsuficienteException("Stock Insuficiente");
        prod.stock-=cantidad;
        return prod.calcularPrecioFinal()*cantidad;
    }
    //Valor Total
    public double calcularValorInventario(){
        if(productos.isEmpty())
            throw new IllegalArgumentException("Inventario vacio");
        double total=0;
        for(Producto prod: productos){
            total += prod.calcularPrecioFinal()* prod.getStock();
        }
        return total;
    }
    //Producto con bajo stock
    public ArrayList<Producto> listarProductosBajoStock(int minimo){
        ArrayList<Producto> lista = new ArrayList<>();
        for(Producto prod:productos){
            if(prod.getStock()<minimo)
                lista.add(prod);
        }
        return lista;
    }
    //Ordenar por precio
    public void ordenarPorPrecio(){
        boolean cambio;
        do{
            cambio=false;
            for(int i=0;i<productos.size()-1;i++){
                if(productos.get(i).calcularPrecioFinal()>productos.get(i+1).calcularPrecioFinal()){
                    Producto aux=productos.get(i);
                    productos.set(i,productos.get(i+1));
                    productos.set(i+1,aux);
                    cambio=true;
                }
            }
        }while(cambio);

    }
    //Sobrecarga
    @Override
    public String toString() {
        String rescr="Inventario: "+nombreTienda+"\n";
        for(Producto prod:productos){
            rescr+=prod.toString()+"\n";
        }
        return rescr;
    }


}

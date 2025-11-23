//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        Inventario inv = new Inventario("MiTienda");

        // Precio negativo
        try {
            new ProductoElectronico("E-001", "TV", 500, 10, "Sony", 12);
        } catch (PrecioInvalidoException e) {
            System.out.println("EXCEPCION: " + e.getMessage());
        }

        // Código vacío
        try {
            new ProductoRopa("", "Camisa", 20, 10, "M", "Algodón");
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPCIÓN : " + e.getMessage());
        }

        inv.agregarProducto(new ProductoElectronico("ELEC-002", "Laptop", 500, 5, "Dell", 12));
        inv.agregarProducto(new ProductoElectronico("ELEC-003", "Mouse", 10, 20, "Logi", 6));
        inv.agregarProducto(new ProductoElectronico("ELEC-004", "Monitor", 200, 3, "HP", 12));

        inv.agregarProducto(new ProductoAlimenticio("ALI-001", "Leche", 1.5, 50, "2025-01-01", true));
        inv.agregarProducto(new ProductoAlimenticio("ALI-002", "Pan", 0.15, 100, "2024-12-10", false));

        inv.agregarProducto(new ProductoRopa("ROP-001", "Camisa", 15, 8, "M", "Algodón"));
        inv.agregarProducto(new ProductoRopa("ROP-002", "Pantalón", 25, 4, "L", "Jean"));
        inv.agregarProducto(new ProductoRopa("ROP-003", "Zapatos", 40, 2, "42", "Cuero"));

        inv.agregarProducto(new ProductoElectronico("ELEC-004", "Teclado", 15, 10, "HP", 12));
        inv.agregarProducto(new ProductoAlimenticio("ALI-003", "Queso", 3.5, 6, "2024-11-01", true));

        // Venta exitosa
        try {
            double total = inv.venderProducto("ELEC-001", 2);
            System.out.println("Venta realizada: $" + total);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //  Venta con cantidad negativa
        try {
            inv.venderProducto("ELEC-002", -5);
        } catch (Exception e) {
            System.out.println("EXCEPCION ESPERADA: " + e.getMessage());
        }

        // Stock insuficiente
        try {
            inv.venderProducto("ROP-003", 10);
        } catch (Exception e) {
            System.out.println("EXCEPCION ESPERADA: " + e.getMessage());
        }

        // Buscar producto inexistente
        try {
            inv.buscarPorCodigo("XXX");
        } catch (Exception e) {
            System.out.println("EXCEPCION: " + e.getMessage());
        }

        // Total inventario
        System.out.println("Valor total: $" + inv.calcularValorInventario());

        // Productos con stock < 5
        System.out.println("Bajo stock (<5): " + inv.listarProductosBajoStock(5).size());

        // Ordenar por precio
        inv.ordenarPorPrecio();
        System.out.println(inv);
    }
}

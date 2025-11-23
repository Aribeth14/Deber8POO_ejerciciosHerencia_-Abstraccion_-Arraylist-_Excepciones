//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Biblioteca bib = new Biblioteca("Central");

        // Pruebas
        try {
            new Libro("LIB-001", "", "Autor X", 2020, 100, "Editorial Y", true);
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPCION : " + e.getMessage());
        }

        try {
            new Revista("REV-002", "Revista X", "Autor Y", 900, 1, "Enero", true);
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPCION : " + e.getMessage());
        }

        try {
            bib.agregarMaterial(new Libro("XXX-123", "Libro X", "Autor X", 2020, 150, "Editorial Z", false));
        } catch (CodigoInvalidoException e) {
            System.out.println("EXCEPCION : " + e.getMessage());
        }

        // Crear materiales
        try {
            Libro l1 = new Libro("LIB-101", "Orgullo y Prejuicio", "Jane Austen",1813 , 432, "Penguin", true);
            Libro l2 = new Libro("LIB-102", "It", "Stephen King", 1986, 1138, "Scribner", false);
            Revista r1 = new Revista("REV-201", "Moda Actual", "Alberth", 2023, 12, "Marzo", false);
            Revista r2 = new Revista("REV-202", "Farandula Hoy", "Vanessa", 2022, 8, "Abril", false);
            DVD d1 = new DVD("DVD-301", "Matrix", "Wachowski", 1999, 136, "Accion", true);
            DVD d2 = new DVD("DVD-302", "Avengers", "Joss Whedon", 2012, 143, "Accion", false);
            Libro l3 = new Libro("LIB-103", "Harry Potter", "J.K.Rowling", 1997, 309, "Bloomsbury", true);
            Revista r3 = new Revista("REV-203", "Historia Viva", "Pedro", 2015, 2, "Mayo", false);

            bib.agregarMaterial(l1);
            bib.agregarMaterial(l2);
            bib.agregarMaterial(r1);
            bib.agregarMaterial(r2);
            bib.agregarMaterial(d1);
            bib.agregarMaterial(d2);
            bib.agregarMaterial(l3);
            bib.agregarMaterial(r3);

            //Prestamos
            bib.prestarMaterial("LIB-101");
            bib.prestarMaterial("REV-201");
            bib.prestarMaterial("DVD-301");
            bib.prestarMaterial("LIB-102");

            try {
                bib.prestarMaterial("LIB-101");
            } catch (MaterialNoDisponibleException e) {
                System.out.println("EXCEPCION : " + e.getMessage());
            }

            // Devolver y mostrar multas
            double multa1 = bib.devolverMaterial("LIB-101", 3);
            double multa2 = bib.devolverMaterial("REV-201", 2);
            System.out.println("Multa LIB-101: " + multa1);
            System.out.println("Multa REV-201: " + multa2);

            // Lista disponibles
            bib.listarMaterialesDisponibles();

            // Ordenar por año
            bib.ordenarPorAnio();
            bib.mostrarCatalogo();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

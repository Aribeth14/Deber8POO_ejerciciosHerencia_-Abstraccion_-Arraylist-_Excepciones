import java.util.ArrayList;
import java.util.Random;

public class Biblioteca {
    private ArrayList<MaterialBiblioteca> catalogo;
    private String nombre;

    public Biblioteca(String nombre) {
        if (nombre == null || nombre.isEmpty())
            throw new IllegalArgumentException("Nombre de biblioteca invalido");
        this.nombre = nombre;
        this.catalogo = new ArrayList<>();
    }

    // Valida formatos: LIB-XXX, REV-XXX, DVD-XXX
    public static void validarCodigo(String codigo) throws CodigoInvalidoException {
        if (!(codigo.matches("LIB-\\d{3}") || codigo.matches("REV-\\d{3}") || codigo.matches("DVD-\\d{3}"))) {
            throw new CodigoInvalidoException("Código inválido: " + codigo);
        }
    }

    // Codigo aleatorio
    public static String generarCodigoAleatorio(String tipo) {
        Random generadorAleatorio = new Random();
        int numeroAleatorio = generadorAleatorio.nextInt(900) + 100;
        return tipo + "-" + numeroAleatorio;
    }


    // Agrega un material al catalogo
    public void agregarMaterial(MaterialBiblioteca material) throws CodigoInvalidoException {
        if (material == null)
            throw new NullPointerException("Material es null");
        validarCodigo(material.getCodigo());
        catalogo.add(material);
    }

    // Busca un material por codigo
    public MaterialBiblioteca buscarMaterial(String codigo) {
        for (MaterialBiblioteca material : catalogo) {
            if (material.getCodigo().equals(codigo))
                return material;
        }
        throw new MaterialNoEncontradoException("Material no encontrado: " + codigo);
    }

    // Presta un material
    public void prestarMaterial(String codigo) {
        MaterialBiblioteca material = buscarMaterial(codigo);
        if (material.isPrestado())
            throw new MaterialNoDisponibleException("Material no disponible: " + codigo);
        material.prestar();
    }

    // Devuelve un material y calcula la multa
    public double devolverMaterial(String codigo, int diasRetraso) {
        if (diasRetraso < 0)
            throw new IllegalArgumentException("Días de retraso invalido");
        MaterialBiblioteca material = buscarMaterial(codigo);
        material.devolver();
        return material.calcularMultaPorRetraso(diasRetraso);
    }

    // Materiales disponibles
    public void listarMaterialesDisponibles() {
        System.out.println("=== Materiales disponibles ===");
        for (MaterialBiblioteca material : catalogo) {
            if (!material.isPrestado())
                System.out.println(material);
        }
    }

    // Ordena los materiales por año (BUBLE SORT)
    public void ordenarPorAnio() {
        int n = catalogo.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (catalogo.get(j).getAnioPublicacion() > catalogo.get(j + 1).getAnioPublicacion()) {
                    MaterialBiblioteca temp = catalogo.get(j);
                    catalogo.set(j, catalogo.get(j + 1));
                    catalogo.set(j + 1, temp);
                }
            }
        }
    }

    // Muestra todos los materiales del catálogo
    public void mostrarCatalogo() {
        System.out.println("=== Catalogo completo ===");
        for (MaterialBiblioteca material : catalogo) {
            System.out.println(material);
        }
    }
}


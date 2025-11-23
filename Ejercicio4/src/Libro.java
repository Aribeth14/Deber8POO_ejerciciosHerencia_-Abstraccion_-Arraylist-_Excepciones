public class Libro extends MaterialBiblioteca {
    private int numPaginas;
    private String editorial;
    private boolean esDigital;

    public Libro(String codigo, String titulo, String autor, int anio, int numPaginas, String editorial, boolean esDigital) {
        super(codigo, titulo, autor, anio);
        if (numPaginas <= 0)
            throw new IllegalArgumentException("Numero de paginas invalido");
        if (editorial == null || editorial.isEmpty())
            throw new IllegalArgumentException("Editorial invalida");

        this.numPaginas = numPaginas;
        this.editorial = editorial;
        this.esDigital = esDigital;
    }
    //Sobreescribir
    @Override
    public double calcularMultaPorRetraso(int diasRetraso) {
        if (diasRetraso < 0)
            throw new IllegalArgumentException("Dias de retraso invalido");
        return diasRetraso * (esDigital ? 0.5 : 1.0);
    }
    //Sobreescribir
    @Override
    public int calcularTiempoMaximoPrestamo() {
        return esDigital ? 7 : 15;
    }
}


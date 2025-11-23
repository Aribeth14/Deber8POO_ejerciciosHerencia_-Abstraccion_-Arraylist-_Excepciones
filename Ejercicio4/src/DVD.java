public class DVD extends MaterialBiblioteca {
    private int duracionMinutos;
    private String genero;
    private boolean tieneSubtitulos;

    public DVD(String codigo, String titulo, String autor, int anio, int duracionMinutos, String genero, boolean tieneSubtitulos) {
        super(codigo, titulo, autor, anio);
        if (duracionMinutos <= 0)
            throw new IllegalArgumentException("Duracion invalida");
        if (genero == null || genero.isEmpty())
            throw new IllegalArgumentException("Genero invalido");

        this.duracionMinutos = duracionMinutos;
        this.genero = genero;
        this.tieneSubtitulos = tieneSubtitulos;
    }
    //Sobreescribir
    @Override
    public double calcularMultaPorRetraso(int diasRetraso) {
        if (diasRetraso < 0)
            throw new IllegalArgumentException("Dias de retraso invalido");
        return diasRetraso * 1.5;
    }
    //Sobreescribir
    @Override
    public int calcularTiempoMaximoPrestamo() {
        return 3;
    }
    //Sobrecarga
    public double calcularMultaPorRetraso(int diasRetraso, boolean esEstreno) {
        double multa = calcularMultaPorRetraso(diasRetraso);
        return esEstreno ? multa * 2 : multa;
    }
}


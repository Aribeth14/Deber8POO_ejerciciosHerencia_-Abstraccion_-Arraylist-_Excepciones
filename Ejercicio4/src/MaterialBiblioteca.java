public abstract class MaterialBiblioteca {
    private String codigo;
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private boolean estaPrestado;

    public MaterialBiblioteca(String codigo, String titulo, String autor, int anioPublicacion) {
        if (codigo == null || codigo.isEmpty())
            throw new IllegalArgumentException("Codigo invalido");
        if (titulo == null || titulo.isEmpty())
            throw new IllegalArgumentException("Titulo invalido");
        if (autor == null || autor.isEmpty())
            throw new IllegalArgumentException("Autor invalido");
        if (anioPublicacion < 1000 || anioPublicacion > 2025)
            throw new IllegalArgumentException("Año invalido");

        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.estaPrestado = false;
    }

    public abstract double calcularMultaPorRetraso(int diasRetraso);
    public abstract int calcularTiempoMaximoPrestamo();

    public void prestar() {
        if (estaPrestado) {
            throw new MaterialNoDisponibleException("Material  prestado: " + titulo);
        }
        estaPrestado = true;
    }

    public void devolver() {
        estaPrestado = false;
    }

    public boolean isPrestado() {
        return estaPrestado;
    }
    //Getters para codigo y año de publicacion
    public String getCodigo() {
        return codigo;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    //Metodo toString

    @Override
    public String toString() {
        return "MaterialBiblioteca{" +
                "codigo='" + codigo + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anioPublicacion=" + anioPublicacion +
                ", estaPrestado=" + estaPrestado +
                '}';
    }
}


public  abstract class CuentaBancaria {
    private String numCuenta;
    private String titular;
    protected double saldo;

    //Constructor con validaciones
    public CuentaBancaria(String numCuenta, String titular, double saldo) {
        if(numCuenta==null || numCuenta.isEmpty())
            throw new IllegalArgumentException("Numero de cuenta Invalido");
        if(titular==null || titular.isEmpty())
            throw new IllegalArgumentException("Titular Invalido");
        if(saldo<0)
            throw new IllegalArgumentException("El saldo no puede ser negativo");
        this.numCuenta = numCuenta;
        this.titular = titular;
        this.saldo = saldo;
    }
    //Metodos a implementar
    public void depositar(double monto){
        if(monto <=0 )
            throw new MontoInvalidoException("Monto a depositar Invalido");
        saldo += monto;
    }
    public void retirar(double monto)throws SaldoInsuficienteException{
        if (monto <=0 )
            throw new MontoInvalidoException("Monto Invalido");
        if(monto > saldo)
            throw new SaldoInsuficienteException("Saldo Insuficiente");
        saldo -= monto;
    }
    //Getters
    public String getNumCuenta() {
        return numCuenta;
    }
    public double getSaldo() {
        return saldo;
    }

    //To String

    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "numCuenta='" + numCuenta + '\'' +
                ", titular='" + titular + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}

public class CuentaAhorros extends CuentaBancaria{
    private double tasaInteres;

    public CuentaAhorros(String numCuenta,String titular, double saldo,double tasaInteres) {
        super(numCuenta, titular, saldo);
        if(tasaInteres< 0 || tasaInteres > 1 )
            throw new IllegalArgumentException("Tasa fuera de rango");
        this.tasaInteres = tasaInteres;
    }

    //Sobreescribir
    @Override
    public void retirar(double monto)throws SaldoInsuficienteException{
        if(monto<= 0)
            throw new MontoInvalidoException("Monto Invalido");
        if(saldo - monto < 50)
            throw new SaldoInsuficienteException("No se puede bajar de $50");
        saldo -= monto;
    }
    public void aplicarInteres(){
        saldo += saldo*tasaInteres;
    }
}

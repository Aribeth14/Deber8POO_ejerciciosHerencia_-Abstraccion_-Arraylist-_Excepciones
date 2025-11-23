public class CuentaCorriente extends CuentaBancaria{
    private  double limiteCredito;

    public CuentaCorriente(String numCuenta, String titular, double saldo, double limiteCredito){
        super(numCuenta, titular, saldo);
        if(limiteCredito<0 )
            throw new IllegalArgumentException("Limite de credito negativo");
        this.limiteCredito = limiteCredito;
    }
    //Sobreescribir
    @Override
    public void retirar(double monto)throws SaldoInsuficienteException{
        if(monto<=0)
            throw new MontoInvalidoException("Monto Invalido");
        if(monto > saldo + limiteCredito )
            throw new SaldoInsuficienteException("Excede credito");
        saldo-=monto;
    }
}

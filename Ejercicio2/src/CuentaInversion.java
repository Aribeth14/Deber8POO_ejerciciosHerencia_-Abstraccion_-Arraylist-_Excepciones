public class CuentaInversion extends CuentaBancaria{
    private double montoMinimo;
    private double rendimientoAnual;

    public CuentaInversion(String numCuenta,String titular,double saldo, double montoMinimo,double rendimientoAnual){
        super(numCuenta, titular, saldo);

        if(montoMinimo<=0)
            throw new IllegalArgumentException("Monto minimo invalido");
        if(rendimientoAnual<0)
            throw new IllegalArgumentException("Rendimiento negativo");
        this.montoMinimo=montoMinimo;
        this.rendimientoAnual=rendimientoAnual;
    }
    @Override
    public void depositar (double monto){
        if(monto < montoMinimo)
            throw new MontoInvalidoException("Deposito menor al minimo");
        saldo+=monto;
    }
    public double calcularRendimiento(){
        return saldo*(rendimientoAnual/12);
    }
    public double calcularRendimiento(int meses){
        return saldo*(rendimientoAnual/12)*meses;
    }
}

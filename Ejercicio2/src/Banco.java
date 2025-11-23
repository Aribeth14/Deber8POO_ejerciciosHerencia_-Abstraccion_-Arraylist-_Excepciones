import java.util.ArrayList;
public class Banco {
    private ArrayList<CuentaBancaria> cuentas = new ArrayList<>();
    private String nombre;

    public Banco(String nombre ){
        if(nombre==null || nombre.isEmpty())
            throw new IllegalArgumentException("Nombre de banco invalido");
        this.nombre = nombre;
    }
    public static String generarNumeroCuenta(){
        String numero= "";
        for(int i=0;i<10;i++){
            numero += (int)(Math.random()*10);
        }
        return numero;
    }
    public void abrirCuenta(CuentaBancaria cuenta){
        if(cuenta ==null)
            throw new NullPointerException("Cuando null");
        cuentas.add(cuenta);
    }
    public void transferir (String origin, String destino,double monto)throws SaldoInsuficienteException{
        if(monto<=0)
            throw new MontoInvalidoException("Monto invalido");
        CuentaBancaria cOrigen = null;
        CuentaBancaria cDestino = null;
        for(CuentaBancaria c:cuentas){
            if(c.getNumCuenta().equals(origin))cOrigen = c;
            if(c.getNumCuenta().equals(destino))cDestino = c;
        }
        if(cOrigen ==null || cDestino ==null)
            throw new IllegalArgumentException("Cuenta no encontrada ");
        cOrigen.retirar(monto);
        cDestino.depositar(monto);
    }
    public void aplicarIntersesAhorros(){
        for(CuentaBancaria c:cuentas){
            if(c instanceof CuentaAhorros ahor){
                if(ahor.getSaldo()==0)
                    throw new CuentaInactivaException("Cuenta Inactiva");
                ahor.aplicarInteres();
            }

        }
    }
    public double obtenerSaldo(){
        if(cuentas.isEmpty())
            throw new IllegalArgumentException("No hay cuentas ");
        double total=0;
        for(CuentaBancaria c:cuentas)total += c.getSaldo();
        return total;
    }
    public void ordenarPorSaldo(){
        //Bucle sort manual
        for(int i=0;i<cuentas.size()-1;i++){
            for(int j=i+1;j<cuentas.size()-i-1;j++){
                if(cuentas.get(j).getSaldo()>cuentas.get(j+1).getSaldo()){
                    CuentaBancaria temp=cuentas.get(j);
                    cuentas.set(j,cuentas.get(j+1));
                    cuentas.set(j+1,temp);
                }
            }
        }
    }

}

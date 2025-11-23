//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Prueba de errores
        try{
            new CuentaAhorros(Banco.generarNumeroCuenta(),"",100,0.05);
        }catch (Exception e){
            System.out.println("Error esperado: "+e.getMessage());
        }

        try{
            new CuentaCorriente(Banco.generarNumeroCuenta(),"Ariana",-20,100);
        }catch (Exception e){
            System.out.println("Error esperado: "+e.getMessage());
        }
        Banco banco=new Banco("Banco Pichincha");
        //Crear 6 validaciones
        CuentaAhorros a1=new CuentaAhorros(Banco.generarNumeroCuenta(),"Jordan",200,0.05);
        CuentaAhorros a2=new CuentaAhorros(Banco.generarNumeroCuenta(),"Maria",100,0.07);

        CuentaCorriente c1=new CuentaCorriente(Banco.generarNumeroCuenta(),"Alessia",300,200);
        CuentaCorriente c2=new CuentaCorriente(Banco.generarNumeroCuenta(),"ALejandro",500,100);

        CuentaInversion i1=new CuentaInversion(Banco.generarNumeroCuenta(),"Pedro",1000,50,0.10);
        CuentaInversion i2=new CuentaInversion(Banco.generarNumeroCuenta(),"Nayely",2000,100,0.12);

        banco.abrirCuenta(a1);
        banco.abrirCuenta(a2);
        banco.abrirCuenta(c1);
        banco.abrirCuenta(c2);
        banco.abrirCuenta(i1);
        banco.abrirCuenta(i2);
        //Depositos y retiros
        a1.depositar(100);
        try{
            a1.retirar(5000);
        }catch (SaldoInsuficienteException e){
            System.out.println("Retiro fallido: "+e.getMessage());
        }
        //Transferencia
        try{
            banco.transferir(a1.getNumCuenta(),c1.getNumCuenta(),50);
        }catch (Exception e){
            System.out.println("Error transferencia: "+e.getMessage());
        }
        //Monto negativo
        try{
            banco.transferir(a1.getNumCuenta(),c2.getNumCuenta(),-10);
        }catch (Exception e){
            System.out.println("Error esperdo: "+e.getMessage());
        }
        //Saldo total
        try{
            banco.aplicarIntersesAhorros();
        }catch (CuentaInactivaException e){
            System.out.println("Cuenta inactiva detectada: "+e.getMessage());
        }
        //Ordenar por saldo
        banco.ordenarPorSaldo();
        System.out.println("Cuenta ordenadas por saldo: ");

    }
}
import javax.swing.*;
import java.util.HashMap;
import java.util.Locale;
public class principal {
    HashMap<String, Double> datos = new HashMap<>();
    String nombre,tipo;
    Double ventas,comision;
    public void iniciar(){
        String validar="";
        JOptionPane.showMessageDialog(null,"programa para calcular comisiones segun tipo de vendedor");
        do {
            procesos();
            validar= JOptionPane.showInputDialog("desea seguir calculando comisiones (si/no)");
        }while(validar.equalsIgnoreCase("si"));
        JOptionPane.showMessageDialog(null,"============================================");
        JOptionPane.showMessageDialog(null,"Saliendo del sistema");
    }
    private void procesos() {
        ingresarDatos();
        comisionPorEmpleado();
        calcularPagoComisiones();
        cantidadEmpleadosComisionMayor();
    }

    private void cantidadEmpleadosComisionMayor() {
        int contador=0;
        for (Double valor : datos.values()) {
            if(valor>500000){
                contador++;
            }
        }
        if(contador<0){
            System.out.println("no hay empleados que hallan obtenido una comision mayor a 500000$");
        }
        else{
            System.out.println("la cantidad de empleados que obtuvieron una comision mayor a 500000 son "+contador);
        }
    }

    private void calcularPagoComisiones() {
        double pagoTotalComision=0;
        for (Double valor : datos.values()) {
            pagoTotalComision+=valor;
        }
        System.out.println("=================================================");
        System.out.println("el pago total por comisiones es "+pagoTotalComision);
    }

    private void comisionPorEmpleado() {
        datos.forEach((nombre, comision) -> {
            System.out.println("Vendedor: " + nombre + " comision " + comision);
        });
    }
    private void ingresarDatos() {
        int canti=Integer.parseInt(JOptionPane.showInputDialog("ingrese cantidad de empleados a calcular la comision"));
        for(int i=0;i<canti;i++){
            nombre=JOptionPane.showInputDialog("ingrese nombre del empleado "+(i+1));
            ventas=Double.parseDouble(JOptionPane.showInputDialog("ingrese el total de ventas realizadas "));
            tipo=validarTipoVendedor();
            calcularComision();
            datos.put(nombre,comision);
        }
    }
    private void calcularComision() {
        switch (tipo){
            case "a":
                comision=ventas*0.08;
                break;
            case "b":
                comision=ventas*0.06;
                break;
            case "c":
                comision=ventas*0.04;
                break;
            case "d":
                comision=ventas*0.02;
                break;
        }
    }
    public String validarTipoVendedor() {
        String tipo="";
        do{
            tipo=JOptionPane.showInputDialog("ingrese el tipo de vendedor "+
                    "\n"+"vendedor A"+"\n"+"vendedor B"+"\n"+"vendedor C"+"\n"+"vendedor D");
            tipo=tipo.toLowerCase();
            if(!tipo.equals("a") && !tipo.equals("b") && !tipo.equals("c") && !tipo.equals("d")  ){
                JOptionPane.showMessageDialog(null,"error, vuelve a intentar");
            }
        }while(!tipo.equals("a") && !tipo.equals("b") && !tipo.equals("c") && !tipo.equals("d"));
        return tipo;
    }

}

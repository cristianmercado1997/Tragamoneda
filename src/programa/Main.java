package programa;


import java.util.ArrayList;
import java.util.Scanner;
import tragaMonedas.Fruta;
import tragaMonedas.Fruta;
import tragaMonedas.Maquina;
import tragaMonedas.Maquina;
import tragaMonedas.Premio;
import tragaMonedas.Premio;

public class Main {

    public static void main(String[] args) {
         
        Premio premio1 = new Premio(20, Fruta.FRESA, Fruta.FRESA, Fruta.FRESA);
        Premio premio2 = new Premio(10, Fruta.SANDIA, Fruta.FRESA, Fruta.FRESA);
        
        Maquina maquina = new Maquina(3, 0.5, premio1, premio2);
        
        System.out.print("Introduzca la cantidad de credito : ");
        Scanner sn = new Scanner(System.in);
        double credito = sn.nextDouble();
        sn.nextLine();
        maquina.incrementarCredito(credito);
        
        while(maquina.getCreditoActual() > 0) {
            ArrayList <Fruta> combinacion = maquina.jugar();
            System.out.println(combinacion.toString() + " --- " + maquina.getCreditoActual());
            System.out.println("Pulse ENTER para continuar jugando...");
            sn.nextLine();
        }
        sn.close();
    }
}

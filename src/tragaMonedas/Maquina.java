package tragaMonedas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

public class Maquina {

    private final int numCasill;
    private double creditoAc;
    private double PrecioJugar;

    private final HashSet <Premio> premios = new HashSet<>();
    
    public Maquina(int numCasillas, double precio, Premio... premios) {
        this.numCasill = numCasillas;
        this.PrecioJugar = precio;
        for(Premio pt : premios) {
            this.premios.add(pt);
        }
    }

    //METODOS GET AND SET

        public void incrementarCredito(double credito)
    {
        this.creditoAc += credito;
    }
    
    public void setPrecioJugada(double precioJugada) {
        this.PrecioJugar = precioJugada; 
    }
    public int getNumCasillas() {
        return numCasill;
    }
    public double getPrecioJugada() {
        return PrecioJugar; 
    }
    public double getCreditoActual() {
        return creditoAc; 
    }
    
   
    public ArrayList<Fruta> jugar() {
        if(this.creditoAc >= this.PrecioJugar) {
            this.creditoAc -= this.PrecioJugar;
            ArrayList <Fruta> combActual, combPremio;
            combActual = this.generarCombinacion();
            for(Premio pt : this.premios) {
                combPremio = pt.getCombGanadora();
               if(combActual.equals(combPremio)) {
                   this.creditoAc += pt.getCantDinero();
                }
            }
            return combActual;
        }
            return null;
    }

    private ArrayList<Fruta> generarCombinacion() {
        ArrayList<Fruta> combinacion = new ArrayList<>(this.numCasill);
        Random random = new Random();
        Fruta[] frutas = Fruta.values();
        for(int i = 0; i < this.numCasill; i++) {
            Fruta fruta = frutas[random.nextInt(frutas.length)];
            combinacion.add(fruta);
        }
        
        return combinacion;
    }
        
    
}

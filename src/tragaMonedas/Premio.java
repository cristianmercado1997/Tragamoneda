package tragaMonedas;

import java.util.ArrayList;
import java.util.Objects;

public class Premio {
    private final ArrayList <Fruta> combGanad;
    private final double cantDin;
    
    public Premio(double cantDinero, Fruta... frutas) {
        this.cantDin = cantDinero;
        combGanad = new ArrayList<>();
        for(Fruta ft : frutas) {
            this.combGanad.add(ft);
        }
    }
    
    // GET AND SET
    public ArrayList<Fruta> getCombGanadora() 
    { return combGanad; 
    }
    
    public double getCantDinero() { 
        return cantDin; 
    }
    
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Premio other = (Premio) obj;
        return Objects.equals(this.combGanad, other.combGanad);

    }
    
    @Override
        public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.combGanad);
        hash = 73 * hash + (int) (Double.doubleToLongBits(this.cantDin) ^ (Double.doubleToLongBits(this.cantDin) >>> 32));
        return hash;
    }

}

package Taller1;

/**
 * Representa a la Lista de Campeones jugadors por el Invocador.
 */
public class ListaCampeonInv {
    /**
     * Arreglo que contiene a los campeones del invocador.
     */
    private CampeonInv[] vecCampeonInv;
    /**
     * Corresponde a la cantidad máxima de datos de la lista CampeonInv.
     */
    private int cantMax;
    /**
     * Corresponde a la cantidad actual de datos de la lista CampeonInv.
     */
    private int cantCampeonInv;


    /**
     * Constructor de la ListaCampeonInv.
     */
    public ListaCampeonInv(){
        this.cantMax = 151;
        this.vecCampeonInv = new CampeonInv[this.cantMax];
        this.cantCampeonInv = 0;
    }

    public CampeonInv[] getVecCampeonInv() {
        return vecCampeonInv;
    }

    /**
     * Metodo que obtiene la cantidad de Campeones del Invocador.
     * @return La cantidad de campeones del invocador.
     */
    public int getCantCampeonInv(){
        return this.cantCampeonInv;
    }

    /**
     * Metodo que agrega campeones a la lista de campeones jugador del invocador.
     * @param campeonInv campeon usado por el invocador.
     * @return true si se agrega exitosamente al campeon a la lista.
     */
    public boolean agregarCampeonInv(CampeonInv campeonInv){
        if (this.cantCampeonInv == this.cantMax){
            return false;
        }
        for (int i = 0; i < this.cantCampeonInv; i++) {
            if (this.vecCampeonInv[i].getNombreCampeon().equals(campeonInv.getNombreCampeon())){
                return false;
            }
        }
        this.vecCampeonInv[this.cantCampeonInv] = campeonInv;
        this.cantCampeonInv++;
        return true;
    }
}

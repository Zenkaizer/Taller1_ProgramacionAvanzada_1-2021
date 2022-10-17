package Taller1;

public class ListaInvocador {

    private Invocador[] vecInvocador;
    private int cantMax;
    private int cantInvocador;

    public ListaInvocador(){
        this.cantMax = 999;
        this.vecInvocador = new Invocador[999];
        this.cantInvocador = 0;
    }

    public Invocador[] getVecInvocador() {
        return vecInvocador;
    }

    public int getCantInvocador() {
        return this.cantInvocador;
    }

    /**
     *
     * @param invocador
     * @return
     */
    public boolean agregarInvocador(Invocador invocador) {
        if (this.cantInvocador == this.cantMax){
            return false;
        }
        for (int i = 0; i < this.cantInvocador; i++) {
            if (this.vecInvocador[i].getNombreInv().equals(invocador.getNombreInv())){
                return false;
            }
        }
        this.vecInvocador[this.cantInvocador] = invocador;
        this.cantInvocador++;
        return true;
    }
}

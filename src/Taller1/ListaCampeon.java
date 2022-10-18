package Taller1;

public class ListaCampeon {

    private Campeon[] vecCampeones;
    private int cantMax;
    private int cantCampeones;

    public ListaCampeon(){
        this.cantMax = 151;
        this.vecCampeones = new Campeon[cantMax];
        this.cantCampeones = 0;
    }

    public Campeon[] getVecCampeones() {
        return vecCampeones;
    }

    public int getCantCampeones(){
        return this.cantCampeones;
    }

    public int getCantMax() {
        return cantMax;
    }

    public boolean agregarCampeon(Campeon campeon) {
        if (this.cantCampeones == this.cantMax){
            return false;
        }
        for (int i = 0; i < this.cantCampeones; i++) {
            if (this.vecCampeones[i].getNombreCampeon().equals(campeon.getNombreCampeon())){
                return false;
            }
        }
        this.vecCampeones[this.cantCampeones] = campeon;
        this.cantCampeones++;
        return true;
    }

    public Campeon obtenerCampeon(int posicion){
        if(posicion < 0 || posicion >=this.cantCampeones){
            return null;
        }
        return this.vecCampeones[posicion];
    }





}


package gestaobiblioteca;


public class Audiobook extends ItemAcervo{

    private int duracaominutos;
    private double tamanhomb;

    
    public int getDuracaominutos() {
        return duracaominutos;
    }

    public void setDuracaominutos(int duracaominutos) {
        this.duracaominutos = duracaominutos;
    }

    public double getTamanhomb() {
        return tamanhomb;
    }

    public void setTamanhomb(double tamanhomb) {
        this.tamanhomb = tamanhomb;
    }
    
    
    @Override
    public int calcularPrazoDevolucao() {
        
        return 21;
        
    }
    
}

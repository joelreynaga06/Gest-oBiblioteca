
package gestaobiblioteca;


public class Revista extends ItemAcervo {

    private int edicao;
    private String titulo;

    public Revista(int edicao, String titulo) {
        this.edicao = edicao;
        this.titulo = titulo;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    @Override
    public String getTitulo() {
        return titulo;
    }

    @Override
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    
 
    
    
    @Override
    public int calcularPrazoDevolucao() {
        
        return 5;
        
    }
    
}


package gestaobiblioteca;

public class Livro extends ItemAcervo{
    private String titulo;
    private int numPaginas;
    
    

    public Livro(String titulo, int numPaginas) {
        this.titulo = titulo;
        this.numPaginas = numPaginas;
    }

    @Override
    public String getTitulo() {
        return titulo;
    }

    @Override
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }


    @Override
    public int calcularPrazoDevolucao() {
        return 14;
        
    }
    
    
}

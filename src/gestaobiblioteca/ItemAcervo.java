
package gestaobiblioteca;


public abstract class ItemAcervo {
    private int id;
    private String autor;
    private String titulo;
    private boolean disponivel;
    private double valorDiarioMulta;
    
    private CategoriaItem categoria;

    public CategoriaItem getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaItem categoria) {
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = true;
    }

    public double getValorDiarioMulta() {
        return valorDiarioMulta;
    }

    public void setValorDiarioMulta(double valorDiarioMulta) {
        this.valorDiarioMulta = valorDiarioMulta;
    }
    
    
    
    
    public abstract int calcularPrazoDevolucao();
    
    public void emprestar(){
        
    }
    public void devolver(){
        
}
    public void disponivel(){
        
    }
}

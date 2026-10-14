
package gestaobiblioteca;

import java.util.ArrayList;
import java.util.List;

public abstract class Usuario {
    
    private int id;
    private String nome;
    private String email;
    private double multapendente;
    
    
    private List <Emprestimo> itemsemprestados;

    public List<Emprestimo> getItemsemprestados() {
        return itemsemprestados;
    }

    public void setItemsemprestados(List<Emprestimo> itemsemprestados) {
        this.itemsemprestados = itemsemprestados;
    }

    public Usuario(int id, String nome, String email, double multapendente) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.multapendente = multapendente;
        this.itemsemprestados = new ArrayList<>();
    }

    public Usuario(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.email = "";
        this.multapendente = 0.0;
        this.itemsemprestados =  new ArrayList<>();
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getMultapendente() {
        return multapendente;
    }

    public void setMultapendente(double multapendente) {
        this.multapendente = multapendente;
    }
    
    
    
    public abstract int getLimiteEmprestimo();
    public abstract double getDescontoMulta();
    
    public void adicionarEmprestimo(Emprestimo emprestimo){
        this.itemsemprestados.add(emprestimo);
    }
    public void devolverEmprestimo(Emprestimo emprestimo){
        this.itemsemprestados.remove(emprestimo);
    }
    
}

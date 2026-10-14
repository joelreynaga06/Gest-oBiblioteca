
package gestaobiblioteca;

public class Professor extends Usuario{

    public Professor(int id, String nome, String email, double multapendente) {
        super(id, nome, email, multapendente);
    }
    public Professor (int id , String nome){
        super (id, nome);
    }

    @Override
    public int getLimiteEmprestimo() {
        return 10;
    }

    @Override
    public double getDescontoMulta() {
        return 0.50;
    }
    
}

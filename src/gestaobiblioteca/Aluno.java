
package gestaobiblioteca;


public class Aluno extends Usuario{

    public Aluno(int id, String nome, String email, double multapendente) {
        super(id, nome, email, multapendente);
    }

    public Aluno(int id, String nome) {
        super(id, nome);
    }

    
    @Override
    public int getLimiteEmprestimo() {
        return 3;
    }

    @Override
    public double getDescontoMulta() {
        return 0.0;
    }
}



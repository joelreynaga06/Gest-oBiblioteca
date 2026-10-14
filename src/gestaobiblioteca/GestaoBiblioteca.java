
package gestaobiblioteca;

import java.time.LocalDate;


public class GestaoBiblioteca {

    
    public static void main(String[] args) {
        
        System.out.println("----------- SISTEMA DE GESTÃO DE BIBLIOTECA - TESTES ----------------- ");
        
        testarFluxoSucessoEMulta();
        testarBloqueioPorMulta();
        testarBloqueioPorItemIndisponivel();
        
        System.out.println("TODOS OS TESTES FORAM REALIZADOS COM SUCESSO!!!!");
    }
    

    private static void testarFluxoSucessoEMulta() {
        System.out.println("teste 1 -  fluxo normal calculo de multa");
        BibliotecaService biblioteca = new BibliotecaService();
        Usuario Aluno = new Aluno(1, "joel");
        ItemAcervo Livro = new Livro("anjos e demonios" , 101);
        Livro.setDisponivel(true);
        
        try{
            
            //aqui realizou a parte do emprestimo//
            Emprestimo emp =  biblioteca.realizarEmprestimo( Aluno, Livro);   
            System.out.println("emprestimo realizado com sucesso para " + Aluno.getNome());
            System.out.println("a data de devolução prevista é para " + emp.getDataDevolucaoPrevista());
            
            // agora vamos simular a devolução do item com 3 dias de atraso
            LocalDate dataAtrasada =  emp.getDataDevolucaoPrevista().plusDays(3);
            System.out.println(" simulando a devolução da data " + dataAtrasada + "3 dias");
            emp.devolverItem(dataAtrasada);
            
            System.out.println("status final do emprestimo " + emp.getStatus());
            System.out.println("multa gerada no perfil do aluno R$ " + Aluno.getMultapendente() );
            
        }catch(IllegalStateException e){
            System.out.println("Falha inesperada no teste 1 " + e.getMessage() );
        }
        System.out.println();
    }
    
    // aqui vamos ver que o usuario com multa seja bloqueado

    private static void testarBloqueioPorMulta() {
        System.out.println("teste 2 - validação de usuario com multa que deseja pegar um novo item");
        BibliotecaService biblioteca = new BibliotecaService();
        Usuario aluno = new Aluno(1, "joel");
        aluno.setMultapendente(6.00);
        ItemAcervo revista = new Revista (1122, " casa de papel " );
        
        
        try{
            System.out.println(" tentando realizar um novo emprestimo ");
            biblioteca.realizarEmprestimo( aluno, revista);
            System.out.println(" alerta de erro, o sistema permitiu que um caloteiro pegue um livro novo");
        }catch(IllegalStateException e){
            System.out.println("sucesso no teste - usuario bloqueado com sucesso");
            System.out.println(" mensagem de retorno " + e.getMessage());
            
            
        }
        System.out.println();
    }

    private static void testarBloqueioPorItemIndisponivel() {
        System.out.println(" teste 3 - validação de item indisponivel ");
        BibliotecaService biblioteca =  new BibliotecaService();
        Usuario aluno = new Aluno (105, "ceison");
        Usuario prof =  new Professor(222, "jose");
        ItemAcervo livro =  new Livro("salem", 205);
        
        
        try{
            biblioteca.realizarEmprestimo( prof, livro);
            System.out.println("o livro " + livro.getTitulo()+ "emprestado para " + prof.getNome());
            
            biblioteca.realizarEmprestimo( aluno, livro);
            
        }catch(IllegalStateException erro){
            System.out.println("emprestimo duplicado foi impedido");
            System.out.println("mensagem de retorno do teste  "  +   erro.getMessage());
    }
        
        System.out.println();
    }
    
    
    
}

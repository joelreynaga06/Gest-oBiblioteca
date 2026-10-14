
package gestaobiblioteca;


public class BibliotecaService {

   
    public Emprestimo realizarEmprestimo( Usuario usuario, ItemAcervo item){
        if(usuario == null || item == null){
            throw new IllegalStateException("usuario e item não podem ser nulos");
        }
        
        if(!item.isDisponivel()){
            throw new IllegalStateException("o item" + item.getTitulo()+ "não esta disponivel no acervo");
            
        }
        if(usuario.getMultapendente()>0.0){
            throw new IllegalStateException("o usuario possui multas no valor de " + usuario.getMultapendente());
        }
        if(usuario.getItemsemprestados().size() >= usuario.getLimiteEmprestimo()){
            throw new IllegalStateException("o limite de items foi atingido por este usuario" + usuario.getLimiteEmprestimo());
        }
        
        Emprestimo novoEmprestimo = new Emprestimo(usuario, item);   
        item.setDisponivel(false);
        usuario.adicionarEmprestimo(novoEmprestimo);
        return novoEmprestimo;
        
    }
    
    
}


package gestaobiblioteca;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class Emprestimo {
    private int id;
    private Usuario usuario;
    private ItemAcervo item;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista;
    private LocalDate dataDevolucaoReal;
    private StatusEmprestimo status;

    public Emprestimo(Usuario usuario, ItemAcervo item) {
      
        this.usuario = usuario;
        this.item = item;
        this.dataEmprestimo = LocalDate.now();
        
        this.dataDevolucaoPrevista = this.dataEmprestimo.plusDays(item.calcularPrazoDevolucao());
        
        this.status = StatusEmprestimo.ATIVO;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }

    public void setDataDevolucaoPrevista(LocalDate dataDevolucaoPrevista) {
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
    }

    public LocalDate getDataDevolucaoReal() {
        return dataDevolucaoReal;
    }

    public void setDataDevolucaoReal(LocalDate dataDevolucaoReal) {
        this.dataDevolucaoReal = dataDevolucaoReal;
    }

    public StatusEmprestimo getStatus() {
        return status;
    }

    public void setStatus(StatusEmprestimo status) {
        this.status = status;
    }
    
    
    public double calcularMultaTotal(LocalDate dataDevolucaoReal){
        if(!dataDevolucaoReal.isAfter(this.dataDevolucaoPrevista)){
            return 0.0;
        }
    
    long diasAtraso = ChronoUnit.DAYS.between(this.dataDevolucaoPrevista,dataDevolucaoReal);
    double valorDiario = this.item.getValorDiarioMulta();
    double desconto =this.usuario.getDescontoMulta();
    
    double multaFinal = diasAtraso * valorDiario * (1.0 - desconto);
    return multaFinal;
    
    
    }
    
    public void devolverItem(LocalDate dataReal){
        this.dataDevolucaoReal =  dataReal;
        double multa = calcularMultaTotal(dataReal);
        
        if(multa>0.0){
            this.status = StatusEmprestimo.ATRASADO;
            this.usuario.setMultapendente(this.usuario.getMultapendente()+ multa);
        }else{
            this.status = StatusEmprestimo.DEVOLVIDO;
            
        }
    }
    
}
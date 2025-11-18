package AV_JAVA.questao2;


public class Cliente {
    private String nome;
    private int idade;
    private double renda;
    private double patrimonio;
    private int toleranciaRisco; 
    
    public Cliente(String nome, int idade, double renda, double patrimonio, int toleranciaRisco) {
        this.nome = nome;
        this.idade = idade;
        this.renda = renda;
        this.patrimonio = patrimonio;
        this.toleranciaRisco = toleranciaRisco;
    }
    
    public String getNome() { return nome; }
    public int getIdade() { return idade; }
    public double getRenda() { return renda; }
    public double getPatrimonio() { return patrimonio; }
    public int getToleranciaRisco() { return toleranciaRisco; }
    
    @Override
    public String toString() {
        return String.format("Cliente: %s | Idade: %d | Renda: R$%.2f | Patrimônio: R$%.2f | Tolerância Risco: %d/10", 
                           nome, idade, renda, patrimonio, toleranciaRisco);
    }
}
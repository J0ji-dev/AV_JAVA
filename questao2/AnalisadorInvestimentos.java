package AV_JAVA.questao2;

public class AnalisadorInvestimentos {
    private CalculoPerfilRisco estrategiaCalculo;
    private String ultimaEstrategia;
    
    public AnalisadorInvestimentos() {
        this.estrategiaCalculo = null;
        this.ultimaEstrategia = "Nenhuma";
    }
    
    public AnalisadorInvestimentos(CalculoPerfilRisco estrategiaInicial) {
        this.estrategiaCalculo = estrategiaInicial;
        this.ultimaEstrategia = estrategiaInicial.getClass().getSimpleName();
    }
    
    public void setEstrategiaCalculo(CalculoPerfilRisco estrategia) {
        this.estrategiaCalculo = estrategia;
        this.ultimaEstrategia = estrategia.getClass().getSimpleName();
        System.out.println("✓ Estratégia alterada para: " + this.ultimaEstrategia);
    }
    
    public PerfilRisco analisarCliente(Cliente cliente) {
        if (estrategiaCalculo == null) {
            throw new IllegalStateException("Erro: Estratégia de cálculo não foi definida. Use setEstrategiaCalculo() primeiro.");
        }
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("ANÁLISE DO CLIENTE: " + cliente.getNome().toUpperCase());
        System.out.println("=".repeat(60));
        System.out.println(cliente.toString());
        System.out.println("Estratégia aplicada: " + ultimaEstrategia);
        System.out.println("-".repeat(60));
        
        return estrategiaCalculo.calcular(cliente);
    }
    
    public PerfilRisco analisarCliente(Cliente cliente, CalculoPerfilRisco estrategiaTemporaria) {
        CalculoPerfilRisco estrategiaAnterior = this.estrategiaCalculo;
        String estrategiaAnteriorNome = this.ultimaEstrategia;
        
        setEstrategiaCalculo(estrategiaTemporaria);
        PerfilRisco resultado = analisarCliente(cliente);
        
        this.estrategiaCalculo = estrategiaAnterior;
        this.ultimaEstrategia = estrategiaAnteriorNome;
        
        return resultado;
    }
    
    public String getEstrategiaAtual() {
        return ultimaEstrategia;
    }
}
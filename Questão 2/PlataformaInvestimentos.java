public class PlataformaInvestimentos {
    public static void main(String[] args) {
        System.out.println(" PLATAFORMA DE ANÁLISE DE INVESTIMENTOS - STRATEGY PATTERN");
        System.out.println("=".repeat(70));
        
        AnalisadorInvestimentos analisador = new AnalisadorInvestimentos();
        
        Cliente[] clientes = {
            new Cliente("João Silva", 35, 8000, 150000, 6),
            new Cliente("Maria Santos", 28, 12000, 80000, 8),
            new Cliente("Carlos Oliveira", 55, 15000, 500000, 3),
            new Cliente("Ana Costa", 42, 25000, 300000, 7),
            new Cliente("Pedro Almeida", 29, 5000, 50000, 9)
        };
        
        System.out.println("\n DEMONSTRAÇÃO 1: ALTERNÂNCIA DINÂMICA DE ESTRATÉGIAS");
        System.out.println("-".repeat(70));
        
        Cliente clienteTeste = clientes[0];
        
        analisador.setEstrategiaCalculo(new ModeloConservador());
        System.out.println("RESULTADO: " + analisador.analisarCliente(clienteTeste));
        
        analisador.setEstrategiaCalculo(new ModeloModerado());
        System.out.println("RESULTADO: " + analisador.analisarCliente(clienteTeste));
        
        analisador.setEstrategiaCalculo(new ModeloAgressivo());
        System.out.println("RESULTADO: " + analisador.analisarCliente(clienteTeste));
        
        System.out.println("\n DEMONSTRAÇÃO 2: ANÁLISE DE MÚLTIPLOS CLIENTES");
        System.out.println("-".span(70));
        
        analisador.setEstrategiaCalculo(new ModeloModerado());
        
        for (int i = 0; i < clientes.length; i++) {
            System.out.println("RESULTADO: " + analisador.analisarCliente(clientes[i]));
        }
        
        System.out.println("\n DEMONSTRAÇÃO 3: EXTENSIBILIDADE - NOVO MODELO");
        System.out.println("-".repeat(70));
        
        System.out.println("RESULTADO: " + analisador.analisarCliente(clientes[1], new ModeloPersonalizado()));
        
        System.out.println("\n✓ Estratégia principal mantida: " + analisador.getEstrategiaAtual());
        
        System.out.println("\n DEMONSTRAÇÃO 4: SIMULAÇÃO DE CONSULTOR");
        System.out.println("-".repeat(70));
        
        System.out.println("Consultor analisando clientes com estratégias específicas...");
        
        System.out.println("RESULTADO: " + analisador.analisarCliente(clientes[2], new ModeloConservador()));
        
        System.out.println("RESULTADO: " + analisador.analisarCliente(clientes[4], new ModeloAgressivo()));
        
        System.out.println("\n" + "=".repeat(70));
        System.out.println(">> DEMONSTRAÇÃO CONCLUÍDA COM SUCESSO!");
        System.out.println(">> STRATEGY PATTERN IMPLEMENTADO CORRETAMENTE!");
        System.out.println(">> SISTEMA FLEXÍVEL E EXTENSÍVEL!");
        System.out.println("=".repeat(70));
    }
}
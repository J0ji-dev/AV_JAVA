package AV_JAVA.questao2;


public class ModeloAgressivo implements CalculoPerfilRisco {
    @Override
    public PerfilRisco calcular(Cliente cliente) {
        System.out.println("Aplicando modelo AGRESSIVO...");
        System.out.println("-> Fórmula: Tolerância Risco (60%) + Renda (30%) + Patrimônio (40%) - Idade (20%)");
        
    
        int pontuacao = (int) (
            (cliente.getToleranciaRisco() * 6) +  
            (cliente.getRenda() / 1000 * 0.3) +   
            (cliente.getPatrimonio() / 100000 * 0.4) - 
            (cliente.getIdade() * 0.2)            
        );
        
        pontuacao = Math.max(pontuacao, 71);
        
        String recomendacao = "Carteira arrojada: Ações small caps, Opções, ETFs internacionais, Criptomoedas, Fundos de Ações Agressivas, Private Equity, Venture Capital";
        
        return new PerfilRisco("AGRESSIVO", pontuacao, recomendacao);
    }
}
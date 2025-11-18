public class ModeloModerado implements CalculoPerfilRisco {
    @Override
    public PerfilRisco calcular(Cliente cliente) {
        System.out.println("Aplicando modelo MODERADO...");
        System.out.println("-> Fórmula: Idade (30%) + Tolerância Risco (40%) + Renda (20%) + Patrimônio (20%)");
        
        
        int pontuacao = (int) (
            (cliente.getIdade() * 0.3) +          
            (cliente.getToleranciaRisco() * 4) +   
            (cliente.getRenda() / 1000 * 0.2) +   
            (cliente.getPatrimonio() / 100000 * 0.2) 
        );
        
        pontuacao = Math.min(Math.max(pontuacao, 31), 70);
        
        String recomendacao = "Carteira balanceada: Ações blue chips, FIIs, Fundos multimercado, ETFs, COEs moderados, Fundos de Ações Conservadoras";
        
        return new PerfilRisco("MODERADO", pontuacao, recomendacao);
    }
}
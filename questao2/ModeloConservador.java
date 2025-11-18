package AV_JAVA.questao2;


public class ModeloConservador implements CalculoPerfilRisco {
    @Override
    public PerfilRisco calcular(Cliente cliente) {
        System.out.println("Aplicando modelo CONSERVADOR...");
        System.out.println("-> Fórmula: Idade (40%) + Tolerância Risco (20%) + Patrimônio (10%)");
        
        
        int pontuacao = (int) (
            (cliente.getIdade() * 0.4) +           
            (cliente.getToleranciaRisco() * 2) +   
            (cliente.getPatrimonio() / 100000 * 0.1)
        );
        
        pontuacao = Math.min(pontuacao, 30);
        
        String recomendacao = "Investimentos de baixo risco: Tesouro Direto, CDB, LCIs/LCAs, Fundos de Renda Fixa, Previdência Privada Conservadora";
        
        return new PerfilRisco("CONSERVADOR", pontuacao, recomendacao);
    }
}
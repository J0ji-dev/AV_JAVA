
package AV_JAVA.questao2;

public class ModeloPersonalizado implements CalculoPerfilRisco {
    @Override
    public PerfilRisco calcular(Cliente cliente) {
        System.out.println("Aplicando modelo PERSONALIZADO...");
        System.out.println("-> Fórmula: [Tolerância^2 + ln(Patrimônio) + (100-Idade)] / Fator de Ajuste");
        
        int pontuacao = (int) (
            (Math.pow(cliente.getToleranciaRisco(), 2) * 0.5) +  
            (Math.log(cliente.getPatrimonio() + 1) * 2) +        
            ((100 - cliente.getIdade()) * 0.3)                   
        );
        
        pontuacao = Math.min(Math.max(pontuacao, 0), 100);
        
        String perfil;
        String recomendacao;
        
        if (pontuacao <= 25) {
            perfil = "ULTRA-CONSERVADOR";
            recomendacao = "Foco total em preservação de capital: Tesouro Selic, Poupança, Fundos RF Liquidez Diária";
        } else if (pontuacao <= 40) {
            perfil = "CONSERVADOR";
            recomendacao = "Preservação com ganho real: CDBs, LCIs/LCAs, Debêntures, Fundos RF Longo Prazo";
        } else if (pontuacao <= 60) {
            perfil = "MODERADO";
            recomendacao = "Crescimento com risco controlado: Ações Dividendos, FIIs, ETFs, Fundos Imobiliários";
        } else if (pontuacao <= 80) {
            perfil = "ARROJADO";
            recomendacao = "Busca por retornos superiores: Ações Growth, Small Caps, ETFs Setoriais, Fundos Ações";
        } else {
            perfil = "ULTRA-AGRESSIVO";
            recomendacao = "Maximização de retorno: Opções, Alavancagem, Cripto, Startups, Mercado Internacional";
        }
        
        return new PerfilRisco(perfil, pontuacao, recomendacao);
    }
}
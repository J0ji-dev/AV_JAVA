package AV_JAVA.questao1;

public class RelatorioDiario implements Relatorio {
    @Override
    public void prepararDados() {
        System.out.println("Preparando dados de fontes do dia: banco de dados operacional, APIs de tracking");
    }
    
    @Override
    public void priorizarMetricas() {
        System.out.println("Priorizando métricas: entregas do dia, entregas pendentes, tempo médio de entrega");
    }
    
    @Override
    public void formatar() {
        System.out.println("Formatando relatório diário: tabelas detalhadas, gráficos de barras");
    }
    
    @Override
    public void gerar() {
        System.out.println("=== GERANDO RELATÓRIO DIÁRIO ===");
        prepararDados();
        priorizarMetricas();
        formatar();
        System.out.println("Relatório diário gerado com sucesso!\n");
    }
}
package AV_JAVA.questao1;

public class RelatorioSemanal implements Relatorio {
    @Override
    public void prepararDados() {
        System.out.println("Preparando dados consolidados da semana: data warehouse, sistemas analíticos");
    }
    
    @Override
    public void priorizarMetricas() {
        System.out.println("Priorizando métricas: tendências semanais, comparação com semanas anteriores, KPIs estratégicos");
    }
    
    @Override
    public void formatar() {
        System.out.println("Formatando relatório semanal: relatório executivo, dashboards, análises comparativas");
    }
    
    @Override
    public void gerar() {
        System.out.println("=== GERANDO RELATÓRIO SEMANAL ===");
        prepararDados();
        priorizarMetricas();
        formatar();
        System.out.println("Relatório semanal gerado com sucesso!\n");
    }
}
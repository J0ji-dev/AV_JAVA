package AV_JAVA.questao1;

public class RelatorioEmergencial implements Relatorio {
    @Override
    public void prepararDados() {
        System.out.println("Preparando dados emergenciais: sistemas em tempo real, alertas, monitoramento ativo");
    }
    
    @Override
    public void priorizarMetricas() {
        System.out.println("Priorizando métricas críticas: incidentes, atrasos críticos, problemas operacionais urgentes");
    }
    
    @Override
    public void formatar() {
        System.out.println("Formatando relatório emergencial: formato simplificado, alertas destacados, ações imediatas");
    }
    
    @Override
    public void gerar() {
        System.out.println("=== GERANDO RELATÓRIO EMERGENCIAL ===");
        prepararDados();
        priorizarMetricas();
        formatar();
        System.out.println("Relatório emergencial gerado com sucesso!\n");
    }
}
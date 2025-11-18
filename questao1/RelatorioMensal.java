package AV_JAVA.questao1;

// NOVO tipo de relatório - adicionado sem modificar o código existente
public class RelatorioMensal implements Relatorio {
    @Override
    public void prepararDados() {
        System.out.println("Preparando dados mensais: data warehouse corporativo, BI, sistemas financeiros");
    }
    
    @Override
    public void priorizarMetricas() {
        System.out.println("Priorizando métricas: resultados mensais, metas atingidas, projeções para o próximo mês");
    }
    
    @Override
    public void formatar() {
        System.out.println("Formatando relatório mensal: relatório executivo completo, análises estratégicas, PDF formal");
    }
    
    @Override
    public void gerar() {
        System.out.println("=== GERANDO RELATÓRIO MENSAL ===");
        prepararDados();
        priorizarMetricas();
        formatar();
        System.out.println("Relatório mensal gerado com sucesso!\n");
    }
}
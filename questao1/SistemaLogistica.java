package AV_JAVA.questao1;

public class SistemaLogistica {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE RELATÓRIOS OPERACIONAIS ===\n");
        
        RelatorioFactory factoryDiario = new RelatorioDiarioFactory();
        RelatorioFactory factorySemanal = new RelatorioSemanalFactory();
        RelatorioFactory factoryEmergencial = new RelatorioEmergencialFactory();
        
        factoryDiario.gerarRelatorio();
        factorySemanal.gerarRelatorio();
        factoryEmergencial.gerarRelatorio();
        
        System.out.println("=== DEMONSTRANDO EXTENSIBILIDADE ===");
        
        RelatorioFactory factoryMensal = new RelatorioMensalFactory();
        factoryMensal.gerarRelatorio();
    }
}
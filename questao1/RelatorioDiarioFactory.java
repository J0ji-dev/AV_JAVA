package AV_JAVA.questao1;

public class RelatorioDiarioFactory extends RelatorioFactory {
    @Override
    public Relatorio criarRelatorio() {
        return new RelatorioDiario();
    }
}
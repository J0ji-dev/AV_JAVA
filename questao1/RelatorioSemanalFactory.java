package AV_JAVA.questao1;

public class RelatorioSemanalFactory extends RelatorioFactory {
    @Override
    public Relatorio criarRelatorio() {
        return new RelatorioDiario();
    }
}
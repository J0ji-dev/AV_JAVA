package AV_JAVA.questao1;

public class RelatorioEmergencialFactory extends RelatorioFactory {
    @Override
    public Relatorio criarRelatorio() {
        return new RelatorioEmergencial();
    }
}
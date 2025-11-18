package AV_JAVA.questao1;

public class RelatorioMensalFactory extends RelatorioFactory {
    @Override
    public Relatorio criarRelatorio() {
        return new RelatorioMensal();
    }
}
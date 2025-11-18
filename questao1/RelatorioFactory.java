
package AV_JAVA.questao1;
public abstract class RelatorioFactory {
    
    public abstract Relatorio criarRelatorio();
    
    public void gerarRelatorio() {
        Relatorio relatorio = criarRelatorio();
        relatorio.gerar();
    }
    
    public String getTipoRelatorio() {
        Relatorio relatorio = criarRelatorio();
        return relatorio.getClass().getSimpleName();
    }
}
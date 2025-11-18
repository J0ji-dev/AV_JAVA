public class VerificacaoValor implements VerificacaoFraude {
    private VerificacaoFraude proximaVerificacao;
    private static final double VALOR_SUSPEITO = 10000.0;
    
    @Override
    public void setProximaVerificacao(VerificacaoFraude proxima) {
        this.proximaVerificacao = proxima;
    }
    
    @Override
    public boolean verificar(Transacao transacao) {
        System.out.println("Verificando valor da transacao: R$" + transacao.getValor());
        
        if (transacao.getValor() > VALOR_SUSPEITO) {
            transacao.marcarComoSuspeita("Valor suspeito: R$" + transacao.getValor() + " excede o limite de R$" + VALOR_SUSPEITO);
            System.out.println("FALHA: Valor suspeito detectado");
            return false;
        }
        
        System.out.println("SUCESSO: Valor dentro dos limites");
        
        if (proximaVerificacao != null) {
            return proximaVerificacao.verificar(transacao);
        }
        
        return true;
    }
}
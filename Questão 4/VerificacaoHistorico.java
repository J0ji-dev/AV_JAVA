public class VerificacaoHistorico implements VerificacaoFraude {
    private VerificacaoFraude proximaVerificacao;
    
    @Override
    public void setProximaVerificacao(VerificacaoFraude proxima) {
        this.proximaVerificacao = proxima;
    }
    
    @Override
    public boolean verificar(Transacao transacao) {
        System.out.println("Verificando historico do usuario: " + transacao.getUsuarioId());
        
        if (transacao.getUsuarioId().startsWith("USER_SUSP") || 
            transacao.getUsuarioId().equals("USER_BLOQUEADO")) {
            transacao.marcarComoSuspeita("Usuario com historico suspeito: " + transacao.getUsuarioId());
            System.out.println("FALHA: Historico suspeito detectado");
            return false;
        }
        
        System.out.println("SUCESSO: Historico verificado");
        
        if (proximaVerificacao != null) {
            return proximaVerificacao.verificar(transacao);
        }
        
        return true;
    }
}
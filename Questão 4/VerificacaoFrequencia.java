public class VerificacaoFrequencia implements VerificacaoFraude {
    private VerificacaoFraude proximaVerificacao;
    
    @Override
    public void setProximaVerificacao(VerificacaoFraude proxima) {
        this.proximaVerificacao = proxima;
    }
    
    @Override
    public boolean verificar(Transacao transacao) {
        System.out.println("Verificacao de frequencia de transacoes");
        
        if (transacao.getUsuarioId().equals("USER_FREQUENTE")) {
            transacao.marcarComoSuspeita("Frequencia anormal de transacoes detectada");
            System.out.println("FALHA: Frequencia suspeita detectada");
            return false;
        }
        
        System.out.println("SUCESSO: Frequencia normal");
        
        if (proximaVerificacao != null) {
            return proximaVerificacao.verificar(transacao);
        }
        
        return true;
    }
}
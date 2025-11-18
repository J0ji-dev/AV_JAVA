public interface VerificacaoFraude {
    void setProximaVerificacao(VerificacaoFraude proxima);
    boolean verificar(Transacao transacao);
}
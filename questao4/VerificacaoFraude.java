package AV_JAVA.questao4;


public interface VerificacaoFraude {
    void setProximaVerificacao(VerificacaoFraude proxima);
    boolean verificar(Transacao transacao);
}
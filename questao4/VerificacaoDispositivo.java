package AV_JAVA.questao4;


public class VerificacaoDispositivo implements VerificacaoFraude {
    private VerificacaoFraude proximaVerificacao;
    
    @Override
    public void setProximaVerificacao(VerificacaoFraude proxima) {
        this.proximaVerificacao = proxima;
    }
    
    @Override
    public boolean verificar(Transacao transacao) {
        System.out.println("Verificando dispositivo: " + transacao.getDispositivo());
        
        if (transacao.getDispositivo().contains("Emulador") || 
            transacao.getDispositivo().equals("Dispositivo Desconhecido") ||
            transacao.getDispositivo().startsWith("ROOT_")) {
            transacao.marcarComoSuspeita("Dispositivo suspeito: " + transacao.getDispositivo());
            System.out.println("FALHA: Dispositivo suspeito detectado");
            return false;
        }
        
        System.out.println("SUCESSO: Dispositivo verificado");
        
        if (proximaVerificacao != null) {
            return proximaVerificacao.verificar(transacao);
        }
        
        return true;
    }
}
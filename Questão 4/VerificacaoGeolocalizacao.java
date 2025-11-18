public class VerificacaoGeolocalizacao implements VerificacaoFraude {
    private VerificacaoFraude proximaVerificacao;
    
    @Override
    public void setProximaVerificacao(VerificacaoFraude proxima) {
        this.proximaVerificacao = proxima;
    }
    
    @Override
    public boolean verificar(Transacao transacao) {
        System.out.println("Verificando geolocalizacao: " + transacao.getLocalizacao());
        
        if (transacao.getLocalizacao().equals("País Risco Alto") || 
            transacao.getLocalizacao().contains("Zona de Conflito")) {
            transacao.marcarComoSuspeita("Localizacao suspeita: " + transacao.getLocalizacao());
            System.out.println("FALHA: Localizacao suspeita detectada");
            return false;
        }
        
        System.out.println("SUCESSO: Localizacao verificada");
        
        if (proximaVerificacao != null) {
            return proximaVerificacao.verificar(transacao);
        }
        
        return true;
    }
}
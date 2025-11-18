public class SistemaAntifraude {
    private VerificacaoFraude cadeiaVerificacoes;
    
    public SistemaAntifraude() {
        VerificacaoValor verificacaoValor = new VerificacaoValor();
        VerificacaoGeolocalizacao verificacaoGeo = new VerificacaoGeolocalizacao();
        VerificacaoHistorico verificacaoHistorico = new VerificacaoHistorico();
        VerificacaoDispositivo verificacaoDispositivo = new VerificacaoDispositivo();
        
        verificacaoValor.setProximaVerificacao(verificacaoGeo);
        verificacaoGeo.setProximaVerificacao(verificacaoHistorico);
        verificacaoHistorico.setProximaVerificacao(verificacaoDispositivo);
        
        this.cadeiaVerificacoes = verificacaoValor;
    }
    
    public boolean processarTransacao(Transacao transacao) {
        System.out.println("=== INICIANDO ANALISE ANTIFRAUDE ===");
        System.out.println(transacao.toString());
        System.out.println("------------------------------------");
        
        boolean aprovada = cadeiaVerificacoes.verificar(transacao);
        
        System.out.println("------------------------------------");
        if (aprovada) {
            System.out.println("RESULTADO: Transacao APROVADA");
        } else {
            System.out.println("RESULTADO: Transacao BLOQUEADA");
            System.out.println("MOTIVO: " + transacao.getMotivoBloqueio());
        }
        System.out.println("====================================");
        
        return aprovada;
    }
    
    public void setCadeiaVerificacoes(VerificacaoFraude novaCadeia) {
        this.cadeiaVerificacoes = novaCadeia;
    }
}
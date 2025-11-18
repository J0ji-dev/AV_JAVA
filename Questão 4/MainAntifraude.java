public class MainAntifraude {
    public static void main(String[] args) {
        SistemaAntifraude sistema = new SistemaAntifraude();
        
        System.out.println("SISTEMA ANTIFRAUDE - CHAIN OF RESPONSIBILITY PATTERN");
        System.out.println("====================================================");
        
        System.out.println("\nTESTE 1: Transacao normal");
        Transacao transacao1 = new Transacao("T001", 500.0, "USER_123", "Brasil", "iPhone 13");
        sistema.processarTransacao(transacao1);
        
        System.out.println("\nTESTE 2: Transacao com valor suspeito");
        Transacao transacao2 = new Transacao("T002", 15000.0, "USER_123", "Brasil", "iPhone 13");
        sistema.processarTransacao(transacao2);
        
        System.out.println("\nTESTE 3: Transacao com localizacao suspeita");
        Transacao transacao3 = new Transacao("T003", 800.0, "USER_456", "País Risco Alto", "Samsung Galaxy");
        sistema.processarTransacao(transacao3);
        
        System.out.println("\nTESTE 4: Transacao com usuario suspeito");
        Transacao transacao4 = new Transacao("T004", 300.0, "USER_SUSP789", "Brasil", "iPhone 12");
        sistema.processarTransacao(transacao4);
        
        System.out.println("\nTESTE 5: Transacao com dispositivo suspeito");
        Transacao transacao5 = new Transacao("T005", 200.0, "USER_999", "Brasil", "Emulador Android");
        sistema.processarTransacao(transacao5);
        
        System.out.println("\nDEMONSTRACAO DE EXTENSIBILIDADE");
        System.out.println("Adicionando nova verificacao de frequencia a cadeia");
        
        VerificacaoValor v1 = new VerificacaoValor();
        VerificacaoFrequencia v2 = new VerificacaoFrequencia(); 
        VerificacaoGeolocalizacao v3 = new VerificacaoGeolocalizacao();
        VerificacaoHistorico v4 = new VerificacaoHistorico();
        VerificacaoDispositivo v5 = new VerificacaoDispositivo();
        
        v1.setProximaVerificacao(v2);
        v2.setProximaVerificacao(v3);
        v3.setProximaVerificacao(v4);
        v4.setProximaVerificacao(v5);
        
        sistema.setCadeiaVerificacoes(v1);
        
        System.out.println("\nTESTE 6: Transacao com frequencia suspeita (nova verificacao)");
        Transacao transacao6 = new Transacao("T006", 400.0, "USER_FREQUENTE", "Brasil", "iPhone 13");
        sistema.processarTransacao(transacao6);
        
        System.out.println("\nDEMONSTRACAO DE REORGANIZACAO");
        System.out.println("Reorganizando a ordem das verificacoes");
        
        VerificacaoGeolocalizacao g1 = new VerificacaoGeolocalizacao();
        VerificacaoValor g2 = new VerificacaoValor();
        VerificacaoDispositivo g3 = new VerificacaoDispositivo();
        VerificacaoHistorico g4 = new VerificacaoHistorico();
        
        g1.setProximaVerificacao(g2);
        g2.setProximaVerificacao(g3);
        g3.setProximaVerificacao(g4);
        
        sistema.setCadeiaVerificacoes(g1);
        
        System.out.println("\nTESTE 7: Transacao normal com cadeia reorganizada");
        Transacao transacao7 = new Transacao("T007", 600.0, "USER_NORMAL", "Brasil", "Samsung Galaxy");
        sistema.processarTransacao(transacao7);
        
        System.out.println("\nSistema antifraude finalizado com sucesso!");
    }
}
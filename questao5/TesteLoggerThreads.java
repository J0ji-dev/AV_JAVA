package AV_JAVA.questao5;


public class TesteLoggerThreads {
    
    static class ModuloSistema implements Runnable {
        private String nomeModulo;
        private int iteracoes;
        
        public ModuloSistema(String nomeModulo, int iteracoes) {
            this.nomeModulo = nomeModulo;
            this.iteracoes = iteracoes;
        }
        
        @Override
        public void run() {
            Logger logger = Logger.getInstance();
            
            for (int i = 1; i <= iteracoes; i++) {
                logger.info("Iteracao " + i + " executada", nomeModulo);
                
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    logger.erro("Thread interrompida: " + e.getMessage(), nomeModulo);
                }
                
                if (i % 7 == 0) {
                    logger.erro("Erro simulado na iteracao " + i, nomeModulo);
                }
                
                if (i % 5 == 0) {
                    logger.auditoria("Evento de auditoria na iteracao " + i, nomeModulo);
                }
            }
            
            logger.info("Modulo " + nomeModulo + " finalizado", "SISTEMA");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("TESTE DO SINGLETON LOGGER COM MULTI-THREAD");
        System.out.println("==========================================");
        
        Logger logger = Logger.getInstance();
        logger.setDebugMode(true);
        
        logger.info("Iniciando teste do sistema de logging", "SISTEMA");
        
        Thread[] threads = new Thread[5];
        String[] modulos = {"MODULO_A", "MODULO_B", "MODULO_C", "MODULO_D", "MODULO_E"};
        
        System.out.println("Criando e iniciando " + threads.length + " threads...");
        
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new ModuloSistema(modulos[i], 10));
            threads[i].start();
        }
        
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                logger.erro("Erro ao aguardar thread: " + e.getMessage(), "SISTEMA");
            }
        }
        
        logger.info("Todas as threads finalizadas", "SISTEMA");
        
        testarInstanciaUnica();
        
        logger.close();
        
        System.out.println("Teste concluído. Verifique o arquivo sistema.log");
    }
    
    private static void testarInstanciaUnica() {
        System.out.println("\nVERIFICANDO INSTANCIA UNICA...");
        
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        Logger logger3 = Logger.getInstance();
        
        System.out.println("logger1 == logger2: " + (logger1 == logger2));
        System.out.println("logger2 == logger3: " + (logger2 == logger3));
        System.out.println("logger1 == logger3: " + (logger1 == logger3));
        
        System.out.println("HashCode logger1: " + logger1.hashCode());
        System.out.println("HashCode logger2: " + logger2.hashCode());
        System.out.println("HashCode logger3: " + logger3.hashCode());
        
        if (logger1 == logger2 && logger2 == logger3) {
            System.out.println("SUCESSO: Todas as referencias apontam para a mesma instancia Singleton");
        } else {
            System.out.println("FALHA: Foram criadas instancias diferentes");
        }
    }
}
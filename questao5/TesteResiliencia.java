package AV_JAVA.questao5;

public class TesteResiliencia {
    
    public static void main(String[] args) {
        System.out.println("TESTE DE RESILIENCIA - SINGLETON LOGGER");
        System.out.println("=======================================");
        
        System.out.println("Teste 1: Acesso concorrente massivo");
        testarAcessoConcorrente();
        
        System.out.println("\nTeste 2: Configuração dinâmica");
        testarConfiguracaoDinamica();
        
        System.out.println("\nTeste 3: Fechamento e reabertura");
        testarFechamentoReabertura();
    }
    
    private static void testarAcessoConcorrente() {
        final int NUM_THREADS = 50;
        final int LOGS_POR_THREAD = 20;
        
        Thread[] threads = new Thread[NUM_THREADS];
        
        for (int i = 0; i < NUM_THREADS; i++) {
            final int threadId = i;
            threads[i] = new Thread(() -> {
                Logger logger = Logger.getInstance();
                for (int j = 0; j < LOGS_POR_THREAD; j++) {
                    logger.info("Log " + j + " da thread " + threadId, "THREAD_" + threadId);
                }
            });
        }
        
        for (Thread thread : threads) {
            thread.start();
        }
        
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("Acesso concorrente concluído: " + (NUM_THREADS * LOGS_POR_THREAD) + " logs processados");
    }
    
    private static void testarConfiguracaoDinamica() {
        Logger logger = Logger.getInstance();
        
        logger.setDebugMode(true);
        logger.info("Modo debug ativado", "CONFIG");
        
        logger.setArquivoLog("teste_dinamico.log");
        logger.info("Arquivo de log alterado", "CONFIG");
        
        logger.setDebugMode(false);
        logger.info("Modo debug desativado", "CONFIG");
        
        System.out.println("Configuração dinâmica testada com sucesso");
    }
    
    private static void testarFechamentoReabertura() {
        Logger logger1 = Logger.getInstance();
        logger1.info("Antes do fechamento", "TESTE");
        logger1.close();
        
        Logger logger2 = Logger.getInstance();
        logger2.info("Após reabertura", "TESTE");
        
        System.out.println("Fechamento e reabertura testados com sucesso");
        System.out.println("Mesma instancia após reabertura: " + (logger1 == logger2));
    }
}
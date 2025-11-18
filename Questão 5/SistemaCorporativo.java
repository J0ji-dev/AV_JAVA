public class SistemaCorporativo {
    
    static class ModuloPagamentos {
        public void processarPagamento(double valor, String usuario) {
            Logger logger = Logger.getInstance();
            
            logger.auditoria("Iniciando processamento de pagamento: R$" + valor + " - Usuario: " + usuario, "PAGAMENTOS");
            
            try {
                Thread.sleep(200);
                logger.info("Pagamento processado com sucesso", "PAGAMENTOS");
            } catch (InterruptedException e) {
                logger.erro("Erro ao processar pagamento: " + e.getMessage(), "PAGAMENTOS");
            }
        }
    }
    
    static class ModuloUsuarios {
        public void criarUsuario(String nome, String email) {
            Logger logger = Logger.getInstance();
            
            logger.auditoria("Criando novo usuario: " + nome + " (" + email + ")", "USUARIOS");
            
            try {
                Thread.sleep(150);
                logger.info("Usuario criado com sucesso", "USUARIOS");
            } catch (Exception e) {
                logger.erro("Erro ao criar usuario: " + e.getMessage(), "USUARIOS");
            }
        }
    }
    
    static class ModuloRelatorios {
        public void gerarRelatorio(String tipo) {
            Logger logger = Logger.getInstance();
            
            logger.info("Gerando relatorio: " + tipo, "RELATORIOS");
            
            try {
                Thread.sleep(300);
                
                if (tipo.equals("CRITICO")) {
                    logger.warn("Relatorio critico gerado - revisao necessaria", "RELATORIOS");
                } else {
                    logger.info("Relatorio gerado com sucesso", "RELATORIOS");
                }
            } catch (InterruptedException e) {
                logger.erro("Erro ao gerar relatorio: " + e.getMessage(), "RELATORIOS");
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println("SISTEMA CORPORATIVO - SINGLETON LOGGER");
        System.out.println("======================================");
        
        Logger logger = Logger.getInstance();
        logger.setDebugMode(true);
        logger.setArquivoLog("corporativo.log");
        
        logger.info("Sistema corporativo inicializando", "SISTEMA");
        
        ModuloPagamentos moduloPagamentos = new ModuloPagamentos();
        ModuloUsuarios moduloUsuarios = new ModuloUsuarios();
        ModuloRelatorios moduloRelatorios = new ModuloRelatorios();
        
        logger.auditoria("Iniciando operacoes do dia", "SISTEMA");
        
        Thread t1 = new Thread(() -> moduloUsuarios.criarUsuario("João Silva", "joao@empresa.com"));
        Thread t2 = new Thread(() -> moduloPagamentos.processarPagamento(1500.0, "joao@empresa.com"));
        Thread t3 = new Thread(() -> moduloRelatorios.gerarRelatorio("DIARIO"));
        Thread t4 = new Thread(() -> moduloRelatorios.gerarRelatorio("CRITICO"));
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            logger.erro("Erro no fluxo principal: " + e.getMessage(), "SISTEMA");
        }
        
        demonstrarSingletonGlobal();
        
        logger.info("Sistema corporativo finalizado", "SISTEMA");
        logger.close();
        
        System.out.println("Sistema finalizado. Logs salvos em corporativo.log");
    }
    
    private static void demonstrarSingletonGlobal() {
        System.out.println("\nDEMONSTRACAO DO SINGLETON GLOBAL");
        System.out.println("Todos os módulos abaixo usam a mesma instância:");
        
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        
        logger1.info("Mensagem do modulo A", "MODULO_A");
        logger2.info("Mensagem do modulo B", "MODULO_B");
        
        System.out.println("Instancia 1 hashCode: " + logger1.hashCode());
        System.out.println("Instancia 2 hashCode: " + logger2.hashCode());
        System.out.println("Mesma instancia: " + (logger1 == logger2));
    }
}
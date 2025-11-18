public class SistemaMonitoramento {
    public static void main(String[] args) {
        System.out.println(">> SISTEMA DE MONITORAMENTO AMBIENTAL - OBSERVER PATTERN");
        System.out.println("=".repeat(70));
        
        Sensor sensorTemperatura = new Sensor("TEMP-001", "Centro da Cidade", "temperatura", "°C");
        Sensor sensorUmidade = new Sensor("UMID-001", "Parque Central", "umidade", "%");
        Sensor sensorPoluicao = new Sensor("POL-001", "Zona Industrial", "poluicao", "AQI");
        
        Observer painelCentral = new PainelControle("Painel Central");
        Observer moduloAlertas = new ModuloAlertas("Sistema de Alertas");
        Observer registroHistorico = new ModuloRegistroHistorico("Banco de Dados");
        
        System.out.println("\n>> DEMONSTRAÇÃO 1: INSCRIÇÃO DE OBSERVADORES");
        System.out.println("-".repeat(70));
        
        sensorTemperatura.registrarObserver(painelCentral);
        sensorTemperatura.registrarObserver(moduloAlertas);
        sensorTemperatura.registrarObserver(registroHistorico);
        
        sensorUmidade.registrarObserver(painelCentral);
        sensorUmidade.registrarObserver(registroHistorico);
        
        sensorPoluicao.registrarObserver(painelCentral);
        sensorPoluicao.registrarObserver(moduloAlertas);
        sensorPoluicao.registrarObserver(registroHistorico);
        
        System.out.println("\n>> DEMONSTRAÇÃO 2: ATUALIZAÇÕES DOS SENSORES");
        System.out.println("-".repeat(70));
        
        sensorTemperatura.setValor(25.5);
        System.out.println("\n" + "─".repeat(50));
        
        sensorUmidade.setValor(65.2);
        System.out.println("\n" + "─".repeat(50));
        
        sensorPoluicao.setValor(45.0);
        System.out.println("\n" + "─".repeat(50));
        
        System.out.println("\n>> DEMONSTRAÇÃO 3: SITUAÇÕES DE ALERTA");
        System.out.println("-".repeat(70));
        
        sensorTemperatura.setValor(42.8);
        System.out.println("\n" + "─".repeat(50));
        
        sensorPoluicao.setValor(120.5);    
        System.out.println("\n" + "─".repeat(50));
        
        sensorUmidade.setValor(15.3);    
        System.out.println("\n" + "─".repeat(50));
        
        System.out.println("\n>> DEMONSTRAÇÃO 4: EXTENSIBILIDADE - NOVO MÓDULO");
        System.out.println("-".repeat(70));
        
        Observer moduloRelatorios = new ModuloRelatorios("Gerador de Relatórios");
        
        sensorTemperatura.registrarObserver(moduloRelatorios);
        sensorUmidade.registrarObserver(moduloRelatorios);
        sensorPoluicao.registrarObserver(moduloRelatorios);
        
        sensorTemperatura.setValor(18.7);
        System.out.println("\n" + "─".repeat(50));
        
        System.out.println("\n>>  DEMONSTRAÇÃO 5: REMOÇÃO DE OBSERVADOR");
        System.out.println("-".repeat(70));
        
        sensorTemperatura.removerObserver(moduloAlertas);
        
        sensorTemperatura.setValor(30.2);
        
        System.out.println("\n" + "=".repeat(70));
        System.out.println(" SISTEMA DE MONITORAMENTO CONCLUÍDO COM SUCESSO!");
        System.out.println(" OBSERVER PATTERN IMPLEMENTADO CORRETAMENTE!");
        System.out.println(" BAIXO ACOPLAMENTO E ALTA EXTENSIBILIDADE!");
        System.out.println("=".repeat(70));
    }
}
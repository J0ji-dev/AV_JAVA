package AV_JAVA.questao3;

public class PainelControle implements Observer {
    private String nome;
    
    public PainelControle(String nome) {
        this.nome = nome;
    }
    
    @Override
    public void atualizar(Sensor sensor) {
        System.out.println(">> PAINEL [" + nome + "] recebeu atualização:");
        System.out.println("   • Sensor: " + sensor.getId() + " | " + sensor.getLocalizacao());
        System.out.println("   • " + sensor.getTipo() + ": " + sensor.getValor() + " " + sensor.getUnidade());
        
        if (sensor.getTipo().equals("temperatura")) {
            if (sensor.getValor() > 35) {
                System.out.println("   ⚠️  Temperatura alta detectada!");
            } else if (sensor.getValor() < 10) {
                System.out.println("   ⚠️  Temperatura baixa detectada!");
            }
        }
        
        System.out.println("   → Atualizando interface gráfica...");
    }
    
    public String getNome() {
        return nome;
    }
}
package AV_JAVA.questao3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ModuloRegistroHistorico implements Observer {
    private String nome;
    
    public ModuloRegistroHistorico(String nome) {
        this.nome = nome;
    }
    
    @Override
    public void atualizar(Sensor sensor) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        
        System.out.println(">> HISTÓRICO [" + nome + "] registrando dados:");
        System.out.println("   • Timestamp: " + timestamp);
        System.out.println("   • Sensor: " + sensor.getId());
        System.out.println("   • Localização: " + sensor.getLocalizacao());
        System.out.println("   • Tipo: " + sensor.getTipo());
        System.out.println("   • Valor: " + sensor.getValor() + " " + sensor.getUnidade());
        
        System.out.println("   → Armazenando no banco de dados histórico...");
        
        analisarTendencia(sensor);
    }
    
    private void analisarTendencia(Sensor sensor) {
        if (sensor.getTipo().equals("temperatura") && sensor.getValor() > 30) {
            System.out.println("   >> Tendência: Temperatura em elevação");
        } else if (sensor.getTipo().equals("poluicao") && sensor.getValor() > 80) {
            System.out.println("   >> Tendência: Poluição em crescimento");
        }
    }
    
    public String getNome() {
        return nome;
    }
}
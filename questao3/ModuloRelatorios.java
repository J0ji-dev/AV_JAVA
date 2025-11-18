package AV_JAVA.questao3;

public class ModuloRelatorios implements Observer {
    private String nome;
    
    public ModuloRelatorios(String nome) {
        this.nome = nome;
    }
    
    @Override
    public void atualizar(Sensor sensor) {
        System.out.println(">> RELATÓRIOS [" + nome + "] processando dados:");
        System.out.println("   • Coletando dados de: " + sensor.getId());
        System.out.println("   • Valor atual: " + sensor.getValor() + " " + sensor.getUnidade());
        
        if (sensor.getTipo().equals("temperatura")) {
            System.out.println("   → Gerando relatório de variação térmica...");
        } else if (sensor.getTipo().equals("poluicao")) {
            System.out.println("   → Gerando relatório de qualidade do ar...");
        } else if (sensor.getTipo().equals("umidade")) {
            System.out.println("   → Gerando relatório de condições atmosféricas...");
        }
        
        System.out.println("   >> Dados incorporados ao relatório semanal");
    }
    
    public String getNome() {
        return nome;
    }
}
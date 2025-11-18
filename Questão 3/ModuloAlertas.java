public class ModuloAlertas implements Observer {
    private String nome;
    
    public ModuloAlertas(String nome) {
        this.nome = nome;
    }
    
    @Override
    public void atualizar(Sensor sensor) {
        System.out.println(">> ALERTAS [" + nome + "] analisando dados:");
        System.out.println("   • Fonte: " + sensor.getId() + " | " + sensor.getLocalizacao());
        
        boolean alertaGerado = false;
        
        switch (sensor.getTipo()) {
            case "temperatura":
                if (sensor.getValor() > 40) {
                    System.out.println("   >> ALERTA CRÍTICO: Temperatura extremamente alta!");
                    alertaGerado = true;
                } else if (sensor.getValor() < 0) {
                    System.out.println("   >>  ALERTA CRÍTICO: Temperatura abaixo de zero!");
                    alertaGerado = true;
                }
                break;
                
            case "umidade":
                if (sensor.getValor() > 90) {
                    System.out.println("   >> ALERTA: Umidade muito alta!");
                    alertaGerado = true;
                } else if (sensor.getValor() < 20) {
                    System.out.println("   >>  ALERTA: Umidade muito baixa!");
                    alertaGerado = true;
                }
                break;
                
            case "poluicao":
                if (sensor.getValor() > 100) {
                    System.out.println("   >>  ALERTA CRÍTICO: Índice de poluição perigoso!");
                    alertaGerado = true;
                } else if (sensor.getValor() > 50) {
                    System.out.println("   >>  ALERTA: Índice de poluição moderado");
                    alertaGerado = true;
                }
                break;
        }
        
        if (!alertaGerado) {
            System.out.println("   >> Níveis dentro da normalidade");
        }
    }
    
    public String getNome() {
        return nome;
    }
}
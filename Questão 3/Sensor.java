import java.util.ArrayList;
import java.util.List;

public class Sensor implements Subject {
    private String id;
    private String localizacao;
    private String tipo; 
    private double valor;
    private String unidade;
    private List<Observer> observers;
    
    public Sensor(String id, String localizacao, String tipo, String unidade) {
        this.id = id;
        this.localizacao = localizacao;
        this.tipo = tipo;
        this.unidade = unidade;
        this.observers = new ArrayList<>();
        this.valor = 0.0;
    }
    
    public void setValor(double novoValor) {
        double valorAnterior = this.valor;
        this.valor = novoValor;
        
        System.out.println("\n⚡ SENSOR ATUALIZADO: " + id + " | " + localizacao);
        System.out.println("   " + tipo + ": " + valorAnterior + " → " + novoValor + " " + unidade);
        
        notificarObservers();
    }
    
    @Override
    public void registrarObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
            System.out.println(">> " + observer.getClass().getSimpleName() + " inscrito no sensor " + id);
        }
    }
    
    @Override
    public void removerObserver(Observer observer) {
        observers.remove(observer);
        System.out.println(">> " + observer.getClass().getSimpleName() + " removido do sensor " + id);
    }
    
    @Override
    public void notificarObservers() {
        System.out.println(">> Notificando " + observers.size() + " observadores...");
        for (Observer observer : observers) {
            observer.atualizar(this);
        }
    }
    
    public String getId() { return id; }
    public String getLocalizacao() { return localizacao; }
    public String getTipo() { return tipo; }
    public double getValor() { return valor; }
    public String getUnidade() { return unidade; }
    
    @Override
    public String toString() {
        return String.format("Sensor[%s - %s]: %.2f %s", id, localizacao, valor, unidade);
    }
}
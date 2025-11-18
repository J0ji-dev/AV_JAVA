public class Transacao {
    private String id;
    private double valor;
    private String usuarioId;
    private String localizacao;
    private String dispositivo;
    private boolean suspeita;
    private String motivoBloqueio;
    
    public Transacao(String id, double valor, String usuarioId, String localizacao, String dispositivo) {
        this.id = id;
        this.valor = valor;
        this.usuarioId = usuarioId;
        this.localizacao = localizacao;
        this.dispositivo = dispositivo;
        this.suspeita = false;
        this.motivoBloqueio = "";
    }
    
    public String getId() { return id; }
    public double getValor() { return valor; }
    public String getUsuarioId() { return usuarioId; }
    public String getLocalizacao() { return localizacao; }
    public String getDispositivo() { return dispositivo; }
    public boolean isSuspeita() { return suspeita; }
    public String getMotivoBloqueio() { return motivoBloqueio; }
    
    public void marcarComoSuspeita(String motivo) {
        this.suspeita = true;
        this.motivoBloqueio = motivo;
    }
    
    @Override
    public String toString() {
        return String.format("Transacao[ID: %s, Valor: R$%.2f, Usuario: %s, Local: %s, Dispositivo: %s]", 
                           id, valor, usuarioId, localizacao, dispositivo);
    }
}
package AV_JAVA.questao2;


public class PerfilRisco {
    private String perfil; 
    private int pontuacao; 
    private String recomendacao;
    
    public PerfilRisco(String perfil, int pontuacao, String recomendacao) {
        this.perfil = perfil;
        this.pontuacao = pontuacao;
        this.recomendacao = recomendacao;
    }
    
    public String getPerfil() { return perfil; }
    public int getPontuacao() { return pontuacao; }
    public String getRecomendacao() { return recomendacao; }
    
    @Override
    public String toString() {
        return String.format("Perfil: %s | Pontuação: %d/100 | Recomendação: %s", 
                           perfil, pontuacao, recomendacao);
    }
}
package pm_prova2;

public class Musculacao extends Atividade {
    
    private int aparelhos;
    
    public Musculacao(String nome, int duracao, int maximo, double valor, StatusAtividade status, int aparelhos) {
        super(nome, duracao, maximo, valor, status);
        this.aparelhos = aparelhos;
    }
    
    @Override
    public boolean atividadeColetiva() { return false; }
    
    @Override
    public void exibirDetalhes() {
        System.out.println("Musculacao: " + getNome() + " | Duracao: " + getDuracaoAula() + " | Aparelhos: " + aparelhos + " | Status: " + getStatus());
    }
}

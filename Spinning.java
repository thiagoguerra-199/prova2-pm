package pm_prova2;

import java.util.ArrayList;

public class Spinning extends Atividade implements ControladorPresenca {
    
    private int bicicletas;
    
    private ArrayList<String> presencas = new ArrayList<>();
    
    public Spinning(String nome, int duracao, int maximo, double valor, StatusAtividade status, int bicicletas) {
        
        super(nome, duracao, maximo, valor, status);
        
        this.bicicletas = bicicletas;
        
    }
    
    @Override
    public boolean atividadeColetiva() { return true; }
    
    @Override
    public void registrarPresenca(String nome) {
        
        if (getStatus() != StatusAtividade.ATIVA) { System.out.println("Atividade indisponivel."); return; }
        presencas.add(nome);
        
        System.out.println("Presenca registrada.");
    }
    @Override
    public void exibirDetalhes() {
        System.out.println("Spinning: " + getNome() + " | Bicicletas: " + bicicletas + " | Presencas: " + presencas.size() + " | Status: " + getStatus());
    }
}

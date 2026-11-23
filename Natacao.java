package pm_prova2;

import java.util.ArrayList;

public class Natacao extends Atividade implements Certificavel, ControladorPresenca {
    
    private double profundidade;
    
    private ArrayList<String> presencas = new ArrayList<>();
    
    public Natacao(String nome, int duracao, int maximo, double valor, StatusAtividade status, double profundidade) {
        super(nome, duracao, maximo, valor, status);
        this.profundidade = profundidade;
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
    public void emitirCertificado(String nome) { System.out.println("Certificado de natacao para " + nome); }
    
    @Override
    public void exibirDetalhes() {
        System.out.println("Natacao: " + getNome() + " | Profundidade: " + profundidade + " | Presencas: " + presencas.size() + " | Status: " + getStatus());
    }
}

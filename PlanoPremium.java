package pm_prova2;

import java.util.ArrayList;

public class PlanoPremium extends Plano {
    
    private ArrayList<Atividade> atividades = new ArrayList<>();
    
    public PlanoPremium(String nome, double valor, int maximo, StatusPlano status) {
        
        super(nome, valor, maximo, status);
    }
    
    @Override
    public boolean permiteAtividadeColetiva() { return true; }
    
    public void adicionarAtividade(Atividade a) {
        
        if (getStatus() != StatusPlano.ATIVO) System.out.println("Plano inativo.");
        
        else if (a.getStatus() != StatusAtividade.ATIVA) System.out.println("Atividade indisponivel.");
        
        else if (atividades.contains(a)) System.out.println("Atividade ja adicionada.");
        
        else if (atividades.size() >= getQuantidadeMaximaAtividades()) System.out.println("Limite atingido.");
        
        else { atividades.add(a); System.out.println("Atividade adicionada."); }
    }
    
    @Override
    public void exibirDetalhes() {
        
        System.out.println("Plano: " + getNome() + " | Valor: " + getValorMensal() + " | Status: " + getStatus());
        
        for (Atividade a : atividades) System.out.println(" - " + a.getNome());
        
    }
}

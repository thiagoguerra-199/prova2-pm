package pm_prova2;

import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDate;

public class PlanoBasico extends Plano implements ControladorPresenca {
    
    private ArrayList<Atividade> atividades = new ArrayList<>();
    
    private HashMap<String, LocalDate> acessos = new HashMap<>();
    
    public PlanoBasico(String nome, double valor, int maximo, StatusPlano status) {
        
        super(nome, valor, maximo, status);
    }
    
    @Override
    public boolean permiteAtividadeColetiva() { return false; }
    
    public void adicionarAtividade(Atividade a) {
        
        if (getStatus() != StatusPlano.ATIVO) System.out.println("Plano inativo.");
        
        else if (a.getStatus() != StatusAtividade.ATIVA) System.out.println("Atividade indisponivel.");
        
        else if (a.atividadeColetiva()) System.out.println("Plano basico nao permite atividade coletiva.");
        
        else if (atividades.contains(a)) System.out.println("Atividade ja adicionada.");
        
        else if (atividades.size() >= getQuantidadeMaximaAtividades()) System.out.println("Limite atingido.");
        
        else { atividades.add(a); System.out.println("Atividade adicionada."); }
    }
    
    @Override
    public void registrarPresenca(String nome) {
        LocalDate hoje = LocalDate.now();
        if (getStatus() != StatusPlano.ATIVO) System.out.println("Plano inativo.");
        else if (hoje.equals(acessos.get(nome))) System.out.println("Limite diario atingido.");
        else { acessos.put(nome, hoje); System.out.println("Acesso registrado."); }
    }
    
    @Override
    public void exibirDetalhes() {
        System.out.println("Plano: " + getNome() + " | Valor: " + getValorMensal() + " | Status: " + getStatus());
        for (Atividade a : atividades) System.out.println(" - " + a.getNome());
    }
    
}

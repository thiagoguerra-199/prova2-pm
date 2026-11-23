package pm_prova2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class PM_Prova2 {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Atividade> atividades = new ArrayList<>();
    static ArrayList<Plano> planos = new ArrayList<>();

    public static void criarDados() {
        atividades.add(new Musculacao("Musculacao", 60, 30, 100, StatusAtividade.ATIVA, 20));
        atividades.add(new Natacao("Natacao", 50, 15, 150, StatusAtividade.ATIVA, 2));
        atividades.add(new Spinning("Spinning", 45, 20, 120, StatusAtividade.INATIVA, 20));

        planos.add(new PlanoBasico("Basico", 100, 2, StatusPlano.ATIVO));
        planos.add(new PlanoPremium("Premium", 200, 5, StatusPlano.ATIVO));
    }

    public static void main(String[] args) {
        criarDados();
        int opcao;

        do {
            System.out.println("\n1 - Associar atividade");
            System.out.println("2 - Listar atividades");
            System.out.println("3 - Listar planos");
            System.out.println("4 - Planos ativos");
            System.out.println("5 - Emitir certificado");
            System.out.println("6 - Registrar presenca");
            System.out.println("7 - Remover atividades inativas");
            System.out.println("0 - Sair");
            System.out.print("Opcao: ");

            opcao = lerNumero();
            switch (opcao) {
                case 1: associar(); break;
                case 2: listarAtividades(); break;
                case 3: listarPlanos(); break;
                case 4: planosAtivos(); break;
                case 5: certificado(); break;
                case 6: presenca(); break;
                case 7: removerInativas(); break;
                case 0: System.out.println("Fim."); break;
                default: System.out.println("Opcao invalida.");
            }
        } while (opcao != 0);
    }

    public static int lerNumero() {
        if (!sc.hasNextInt()) {
            sc.nextLine();
            return -1;
        }
        int numero = sc.nextInt();
        sc.nextLine();
        return numero;
    }

    public static void listarAtividades() {
        for (int i = 0; i < atividades.size(); i++) {
            System.out.print((i + 1) + " - ");
            atividades.get(i).exibirDetalhes();
        }
    }

    public static void listarPlanos() {
        for (int i = 0; i < planos.size(); i++) {
            System.out.print((i + 1) + " - ");
            planos.get(i).exibirDetalhes();
        }
    }

    public static void planosAtivos() {
        for (Plano plano : planos) {
            if (plano.getStatus() == StatusPlano.ATIVO) {
                plano.exibirDetalhes();
            }
        }
    }

    public static void associar() {
        listarPlanos();
        System.out.print("Numero do plano: ");
        int p = lerNumero() - 1;

        listarAtividades();
        System.out.print("Numero da atividade: ");
        int a = lerNumero() - 1;

        if (p < 0 || p >= planos.size() || a < 0 || a >= atividades.size()) {
            System.out.println("Numero invalido.");
            return;
        }

        Plano plano = planos.get(p);
        Atividade atividade = atividades.get(a);

        if (plano instanceof PlanoBasico) {
            ((PlanoBasico) plano).adicionarAtividade(atividade);
        } else if (plano instanceof PlanoPremium) {
            ((PlanoPremium) plano).adicionarAtividade(atividade);
        }
    }

    public static void certificado() {
        listarAtividades();
        System.out.print("Numero da atividade: ");
        int n = lerNumero() - 1;

        if (n < 0 || n >= atividades.size()) {
            System.out.println("Numero invalido.");
            return;
        }

        Atividade atividade = atividades.get(n);
        if (atividade instanceof Certificavel) {
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            ((Certificavel) atividade).emitirCertificado(nome);
        } else {
            System.out.println("Nao emite certificado.");
        }
    }

    public static void presenca() {
        System.out.println("1 - Presenca em atividade");
        System.out.println("2 - Acesso no plano basico");
        int tipo = lerNumero();

        if (tipo == 1) {
            listarAtividades();
            System.out.print("Numero da atividade: ");
            int n = lerNumero() - 1;

            if (n < 0 || n >= atividades.size()) {
                System.out.println("Numero invalido.");
                return;
            }

            Atividade atividade = atividades.get(n);
            if (atividade instanceof ControladorPresenca) {
                System.out.print("Nome: ");
                String nome = sc.nextLine();
                ((ControladorPresenca) atividade).registrarPresenca(nome);
            } else {
                System.out.println("Nao controla presenca.");
            }
        } else if (tipo == 2) {
            listarPlanos();
            System.out.print("Numero do plano: ");
            int n = lerNumero() - 1;

            if (n < 0 || n >= planos.size()) {
                System.out.println("Numero invalido.");
                return;
            }

            Plano plano = planos.get(n);
            if (plano instanceof ControladorPresenca) {
                System.out.print("Nome: ");
                String nome = sc.nextLine();
                ((ControladorPresenca) plano).registrarPresenca(nome);
            } else {
                System.out.println("Plano sem controle de acesso.");
            }
        } else {
            System.out.println("Opcao invalida.");
        }
    }

    public static void removerInativas() {
        Iterator<Atividade> it = atividades.iterator();
        while (it.hasNext()) {
            Atividade atividade = it.next();
            if (atividade.getStatus() == StatusAtividade.INATIVA) {
                it.remove();
            }
        }
        System.out.println("Atividades inativas removidas.");
    }
}

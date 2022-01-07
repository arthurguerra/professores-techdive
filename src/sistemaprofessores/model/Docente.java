package sistemaprofessores.model;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Docente {

    private int id;
    private String nome;
    private Turma turmaAtendida;
    private static int totalDocentes = 0;
    private static List<Docente> docentes = new ArrayList<>();

    public Docente() {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Nome do docente: ");
            this.nome = sc.nextLine();

            Docente.totalDocentes++;
            this.id = Docente.totalDocentes;

            Docente.docentes.add(this);

            System.out.println("Docente cadastrado com sucesso!");

        } catch (Exception e) {
            System.err.println("Erro ao cadastrar docente!");
        }
    }

    public static Docente getDocente() {

        Scanner sc = new Scanner(System.in);
        Docente docente = null;
        int indexDocente = 0;

        for (Docente doc: Docente.getDocentes()) {
            System.out.println(doc);
        }
        do {
            System.out.print("Número do docente: ");
            try {
                indexDocente = Integer.parseInt(sc.nextLine());

            } catch (Exception e) {
                System.err.println("Erro ao selecionar docente!");
            }
        } while(indexDocente < 0 || indexDocente > Docente.getDocentes().size());

        if (indexDocente != 0) {
            docente = Docente.getDocentes().get(indexDocente - 1);
        }

        return docente;
    }

    public String getNome() {
        return nome;
    }

    public static List<Docente> getDocentes() {
        return docentes;
    }

    public void setTurmaAtendida(Turma turmaAtendida) {
        this.turmaAtendida = turmaAtendida;
    }

    @Override
    public String toString() {
        return "Docente " + id +
                "\nNome: " + nome + "\n";
//                + "\n Turma atendida atualmente: " +
//                "\n - Turma "+ turmaAtendida.getId() + " - " + turmaAtendida.getNome();
    }

    public String toStringCompleto() {
        return "Docente " + id +
                "\nNome: " + nome
                + "\n Turma atendida atualmente: " +
                "\n - Turma "+ turmaAtendida.getId() + " - " + turmaAtendida.getNome() + "\n";
    }
}

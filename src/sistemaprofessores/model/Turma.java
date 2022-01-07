package sistemaprofessores.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Turma {

    private int id;
    private String nome;
    private int qtAlunos;
    private List<String> assuntos = new ArrayList<>();
    private LocalDate dtInicioAula;
    private static int SEMANAS = 52;
    private static int qtTurmas = 0;
    private static List<Turma> turmas = new ArrayList<>();

    public Turma() {

        Scanner sc = new Scanner(System.in);
        String assunto;
        char continuarCadastroAssunto;
        int ano, mes, dia;
        LocalDate data = null;
        int qtAssuntos;

        try {
            System.out.print("Nome da turma: ");
            this.nome = sc.nextLine();

            System.out.print("Quantidade de alunos: ");
            this.qtAlunos = Integer.parseInt(sc.nextLine());

            do {
                System.out.print("Cadastrar assunto: ");
                assunto = sc.nextLine();
                if (assunto != null){
                    this.assuntos.add(assunto);
                    qtAssuntos++;
                }
                do {
                    System.out.print("Deseja cadastrar outro assunto? [ S / N ]: ");
                    continuarCadastroAssunto = sc.nextLine().trim().toLowerCase().charAt(0);
                } while (continuarCadastroAssunto != 's' && continuarCadastroAssunto != 'n');
            } while(continuarCadastroAssunto == 's' && qtAssuntos < SEMANAS);

            do {
                do {
                    System.out.print("-- Início das Aulas --\nDia: ");
                    dia = Integer.parseInt(sc.nextLine());
                } while (dia < 0 || dia > 31);

                do {
                    System.out.print("Mês [0 - 12]: ");
                    mes = Integer.parseInt(sc.nextLine());
                } while (mes < 0 || mes > 12);

                System.out.print("Ano: ");
                ano = Integer.parseInt(sc.nextLine());

                data = LocalDate.of(ano, mes, dia);

            } while (data == null);

            this.dtInicioAula = data;

            Turma.qtTurmas++;

            this.id = qtTurmas;

            List<String> listaAssuntos = this.getAssuntos();
            int contador = qtAssuntos;

            for (int i = 0; i < SEMANAS; i++) {
                
            }

            Turma.turmas.add(this);

            System.out.println("Turma criada com sucesso!");

        } catch (Exception e) {
            System.err.println("Erro ao cadastrar turma!");
        }
    }

    public static Turma getTurma() {

        Scanner sc = new Scanner(System.in);
        Turma turma = null;
        int indexTurma = 0;

        for (Turma t: Turma.getTurmas()) {
            System.out.println(t);
        }
        do {
            System.out.print("Número do turma: ");
            try {
                indexTurma = Integer.parseInt(sc.nextLine());

            } catch (Exception e) {
                System.err.println("Erro ao selecionar turma!");
            }
        } while(indexTurma < 0 || indexTurma > Docente.getDocentes().size());

        if (indexTurma != 0) {
            turma = Turma.getTurmas().get(indexTurma - 1);
        }

        return turma;

    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<String> getAssuntos() {
        return assuntos;
    }

    public static List<Turma> getTurmas() {
        return turmas;
    }

    @Override
    public String toString() {
        return "Turma " + id +
                "\nNome: " + nome +
                "\nQuantidade de Alunos:" + qtAlunos +
                "\nAssuntos: " + assuntos +
                "\nInício das aulas: " + dtInicioAula + "\n";
    }
}

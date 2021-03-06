package sistemaprofessores.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Turma {

    private int id;
    private String nome;
    private int qtAlunos;
    private List<String> assuntos = new ArrayList<>();
    private LocalDate dtInicioAula;
    private List<Semana> semanas = new ArrayList<>();
    private static final int SEMANAS = 52;
    private static int qtTurmas = 0;
    private static List<Turma> turmas = new ArrayList<>();

    public Turma() {

        Scanner sc = new Scanner(System.in);
        String assunto;
        char continuarCadastroAssunto;
        int ano, mes, dia;
        LocalDate dataInicio = null;
        int qtAssuntos = 0;

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

                do {
                    System.out.print("Ano: ");
                    ano = Integer.parseInt(sc.nextLine());
                } while (ano < 2000);

                dataInicio = LocalDate.of(ano, mes, dia);

            } while (dataInicio == null);

            this.dtInicioAula = dataInicio;

            for (int i = 0; i < SEMANAS; i++) {
                Semana semana = new Semana(ChronoUnit.WEEKS.addTo(dataInicio, i), i+1, this);
                semanas.add(semana);
            }

            Turma.qtTurmas++;

            this.id = qtTurmas;

            Turma.turmas.add(this);

            System.out.println("Turma criada com sucesso!");

        } catch (Exception e) {
            System.err.println("Erro ao cadastrar turma!");
        }
    }

    public void alocarDocente(Docente docente) {

        Scanner sc = new Scanner(System.in);
        int indexAssunto = 0;
        int indexSemana = 0;

        System.out.println("-- Assuntos --");
        for (int i = 0; i < this.assuntos.size(); i++) {
            System.out.printf("%d - %s%n", i+1, assuntos.get(i));
        }

        try {
            do {
                System.out.print("Escolha um assunto: ");
                indexAssunto = Integer.parseInt(sc.nextLine());
            } while (indexAssunto < 0 || indexAssunto > assuntos.size());

            if (indexAssunto != 0) {
                do {
                    System.out.print("Escolha uma semana (1 - 52): ");
                    indexSemana = Integer.parseInt(sc.nextLine());
                } while (indexSemana <= 0 || indexSemana > SEMANAS);

                Semana semana = this.semanas.get(indexSemana - 1);

                if (semana.getDocente() == null) {
                    semana.setAssunto(this.assuntos.get(indexAssunto - 1));
                    semana.setDocente(docente);
                    docente.getSemanas().add(semana);
                    System.out.println("Semana cadastrada com sucesso! ");
                } else if (semana.getDocenteAuxiliar() == null && semana.getDocente() != docente) {
                    semana.setAssunto(this.assuntos.get(indexAssunto - 1));
                    semana.setDocenteAuxiliar(docente);
                    docente.getSemanas().add(semana);
                    System.out.println("Segundo professor adicionado com sucesso!");
                } else if (semana.getDocente() != null && semana.getDocenteAuxiliar() != null){
                    System.err.println("Limite máximo de dois professores por semana atingido!");
                } else {
                    System.out.println("Este professor já está alocado para esta semana!");
                }
//                System.out.printf("Semana: %d %nAssunto: %s %nDocente: %s %nInício da semana: %s%n",
//                        indexSemana, this.assuntos.get(indexAssunto - 1), docente.getNome(), this.semanas.get(indexSemana - 1).getInicio());
            }
        } catch (Exception e) {
            System.err.println("Erro ao alocar docente!");
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
                "\nQuantidade de Alunos: " + qtAlunos +
                "\nAssuntos: " + assuntos +
                "\nInício das aulas: " + dtInicioAula + "\n";
    }

    public void toStringCompleto() {
        System.out.println("\nTurma: "+id);
        System.out.println("Nome: "+nome);
        System.out.println("Quantidade de Alunos: "+qtAlunos);
        System.out.println("Assuntos: "+assuntos);
        System.out.println("Início das aulas: "+dtInicioAula);
        for(Semana semana: semanas) {
            if (semana.getDocente() != null) {
                semana.toStringCompleto();
            }
        }
    }
}

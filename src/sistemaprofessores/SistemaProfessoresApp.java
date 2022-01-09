package sistemaprofessores;

import sistemaprofessores.model.Docente;
import sistemaprofessores.model.Turma;

import javax.print.Doc;
import java.util.Scanner;

public class SistemaProfessoresApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcao = 0;
        Docente docente;
        Turma turma;

        do {
            System.out.println("-----------------------------------------");
            System.out.println("[ 1 ] - Cadastrar turma");
            System.out.println("[ 2 ] - Cadastrar docentes");
            System.out.println("[ 3 ] - Definir docentes para uma determinada turma");
            System.out.println("[ 4 ] - Listar turmas");
            System.out.println("[ 5 ] - Listar todos os docentes");
            System.out.println("[ 6 ] - Ver detalhes de um docente");
            System.out.println("[ 9 ] - Sair ");

            try {

                System.out.print("Opção desejada (9 para sair): ");
                opcao = Integer.parseInt(sc.nextLine());

                switch (opcao) {
                    case 1:
                        new Turma();
                        break;
                    case 2:
                        new Docente();
                        break;
                    case 3:
                        if (Docente.getDocentes().isEmpty()) {
                            System.err.println("Ainda não há docentes cadastrados!");
                        } else if (Turma.getTurmas().isEmpty()) {
                            System.err.println("Ainda não há turmas cadastradas!");
                        } else {
                            docente = Docente.getDocente();
                            if (docente != null) {
                                turma = Turma.getTurma();
                                if (turma != null) {
                                    turma.alocarDocente(docente);
                                    docente.setTurmaAtendida(turma);
                                }
                            }
                        }
                        break;
                    case 4:
                        if (Turma.getTurmas().isEmpty()) {
                            System.err.println("Ainda não há turmas cadastradas!");
                        } else {
                            for (Turma t: Turma.getTurmas()) {
                                t.toStringCompleto();
                            }
                        }
                        break;
                    case 5:
                        if (Docente.getDocentes().isEmpty()) {
                            System.err.println("Ainda não há docentes cadastrados!");
                        } else {
                            for (Docente d: Docente.getDocentes()) {
                                System.out.println(d);
                            }
                        }
                        break;
                    case 6:
                        if (Docente.getDocentes().isEmpty()) {
                            System.err.println("Ainda não há docentes cadastrados!");
                        } else {
                            docente = Docente.getDocente();
                            if (docente != null) {
                                if (docente.getTurmaAtendida() != null) {
                                    docente.toStringCompleto();
                                } else {
                                    System.out.println(docente);
                                }
                            }
                        }
                        break;
                    case 9:
                        System.out.println("Encerrando sistema...");
                        break;
                    default:
                        System.err.println("Opção inválida!");
                        break;
                }

            } catch (Exception e) {
                System.err.println("Opção inválida!");
            }
        } while (opcao != 9);


    }
}

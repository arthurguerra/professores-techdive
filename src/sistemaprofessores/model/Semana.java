package sistemaprofessores.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Semana {

    private int numeroDaSemana;
    private Turma turma;
    private LocalDate inicio;
    private String assunto;
    private Docente docente;
    private Docente docenteAuxiliar;
    private Aula seg;
    private Aula ter;
    private Aula qua;
    private Aula qui;
    private Aula sex;

    public Semana() {
    }

    public Semana(LocalDate inicio) {
        this.inicio = inicio;
    }

    public Semana(LocalDate inicio, int num, Turma turma) {
        this.inicio = inicio;
        this.numeroDaSemana = num;
        this.turma = turma;

        if (inicio.getDayOfWeek().getValue() == 1) {
            seg = new Aula(inicio);
            ter = new Aula(ChronoUnit.DAYS.addTo(inicio, 1));
            qua = new Aula(ChronoUnit.DAYS.addTo(inicio, 2));
            qui = new Aula(ChronoUnit.DAYS.addTo(inicio, 3));
            sex = new Aula(ChronoUnit.DAYS.addTo(inicio, 4));
        }
        if (inicio.getDayOfWeek().getValue() == 2) {
            ter = new Aula(inicio);
            qua = new Aula(ChronoUnit.DAYS.addTo(inicio, 1));
            qui = new Aula(ChronoUnit.DAYS.addTo(inicio, 2));
            sex = new Aula(ChronoUnit.DAYS.addTo(inicio, 3));
            seg = new Aula(ChronoUnit.DAYS.addTo(inicio, 6));
        }
        if (inicio.getDayOfWeek().getValue() == 3) {
            qua = new Aula(inicio);
            qui = new Aula(ChronoUnit.DAYS.addTo(inicio, 1));
            sex = new Aula(ChronoUnit.DAYS.addTo(inicio, 2));
            seg = new Aula(ChronoUnit.DAYS.addTo(inicio, 5));
            ter = new Aula(ChronoUnit.DAYS.addTo(inicio, 6));
        }
        if (inicio.getDayOfWeek().getValue() == 4) {
            qui = new Aula(inicio);
            sex = new Aula(ChronoUnit.DAYS.addTo(inicio, 1));
            seg = new Aula(ChronoUnit.DAYS.addTo(inicio, 4));
            ter = new Aula(ChronoUnit.DAYS.addTo(inicio, 5));
            qua = new Aula(ChronoUnit.DAYS.addTo(inicio, 6));
        }
        if (inicio.getDayOfWeek().getValue() == 5) {
            sex = new Aula(inicio);
            seg = new Aula(ChronoUnit.DAYS.addTo(inicio, 3));
            ter = new Aula(ChronoUnit.DAYS.addTo(inicio, 4));
            qua = new Aula(ChronoUnit.DAYS.addTo(inicio, 5));
            qui = new Aula(ChronoUnit.DAYS.addTo(inicio, 6));
        }
        if (inicio.getDayOfWeek().getValue() == 6) {
            seg = new Aula(ChronoUnit.DAYS.addTo(inicio, 2));
            ter = new Aula(ChronoUnit.DAYS.addTo(inicio, 3));
            qua = new Aula(ChronoUnit.DAYS.addTo(inicio, 4));
            qui = new Aula(ChronoUnit.DAYS.addTo(inicio, 5));
            sex = new Aula(ChronoUnit.DAYS.addTo(inicio, 6));
        }
        if (inicio.getDayOfWeek().getValue() == 7) {
            seg = new Aula(ChronoUnit.DAYS.addTo(inicio, 1));
            ter = new Aula(ChronoUnit.DAYS.addTo(inicio, 2));
            qua = new Aula(ChronoUnit.DAYS.addTo(inicio, 3));
            qui = new Aula(ChronoUnit.DAYS.addTo(inicio, 4));
            sex = new Aula(ChronoUnit.DAYS.addTo(inicio, 5));
        }
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
        seg.setProfessor(docente);
        ter.setProfessor(docente);
        qua.setProfessor(docente);
        qui.setProfessor(docente);
        sex.setProfessor(docente);
    }

    public Docente getDocenteAuxiliar() {
        return docenteAuxiliar;
    }

    public void setDocenteAuxiliar(Docente docenteAuxiliar) {
        this.docenteAuxiliar = docenteAuxiliar;
        qua.setProfessor(docenteAuxiliar);
        qui.setProfessor(docenteAuxiliar);
        sex.setProfessor(docenteAuxiliar);
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public Docente getDocente() {
        return docente;
    }

    @Override
    public String toString() {
        return "Semana{" +
                "Início da semana: " + inicio +
                "assunto='" + assunto + '\'' +
                ", docente=" + docente +
                '}';
    }

    public void toStringCompleto() {
        System.out.println("\n  Semana "+numeroDaSemana);
        System.out.println("  Turma "+turma.getId()+": "+turma.getNome());
        System.out.println("  Assunto: "+assunto);
        System.out.println("  Professor: "+docente.getNome());
        if (docenteAuxiliar != null) {
            System.out.println("  Professor auxiliar: "+docenteAuxiliar.getNome());
        }
        System.out.println("    ["+seg.getDia()+"] - Segunda: "+seg.getProfessor().getNome());
        System.out.println("    ["+ter.getDia()+"] - Terça: "+ter.getProfessor().getNome());
        System.out.println("    ["+qua.getDia()+"] - Quarta: "+qua.getProfessor().getNome());
        System.out.println("    ["+qui.getDia()+"] - Quinta: "+qui.getProfessor().getNome());
        System.out.println("    ["+sex.getDia()+"] - Sexta: "+sex.getProfessor().getNome());
//        seg.toStringCompleto();
//        ter.toStringCompleto();
//        qua.toStringCompleto();
//        qui.toStringCompleto();
//        sex.toStringCompleto();
    }
}

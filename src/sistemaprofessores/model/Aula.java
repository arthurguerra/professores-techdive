package sistemaprofessores.model;

import java.time.LocalDate;

public class Aula {

    private LocalDate dia;
    private Docente professor;

    public Aula(LocalDate dia) {
        this.dia = dia;
    }

    public LocalDate getDia() {
        return dia;
    }

    public Docente getProfessor() {
        return professor;
    }

    public void setProfessor(Docente professor) {
        this.professor = professor;
    }

    public void toStringCompleto() {
        System.out.println("  ["+dia+"] - "+professor.getNome());
    }
}

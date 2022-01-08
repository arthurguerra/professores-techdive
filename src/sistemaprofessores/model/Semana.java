package sistemaprofessores.model;

import java.time.LocalDate;

public class Semana {

    private LocalDate inicio;
    private String assunto = "";
    private Docente docente;

    public Semana() {
    }

    public Semana(LocalDate inicio) {
        this.inicio = inicio;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    @Override
    public String toString() {
        return "Semana{" +
                "Início da semana: " + inicio +
                "assunto='" + assunto + '\'' +
                ", docente=" + docente +
                '}';
    }
}

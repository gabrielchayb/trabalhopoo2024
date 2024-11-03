import java.util.UUID;

public class AlunoIdoso extends Aluno {
    private int pas; // Pressão Arterial Sistólica
    private int pad; // Pressão Arterial Diastólica
    private int bpm; // Batimentos por Minuto
    private int glicemia; // Nível de Glicose no Sangue
    private String observacoes;

    public AlunoIdoso(String nomeAluno, double altura, String sexo, boolean favorito, int idade, double peso,
                     double imc, double gc, double me, double mb, double gv, String[] diasDisponiveis,
                     String treino, int pas, int pad, int bpm, int glicemia, String observacoes) {
        super(nomeAluno, altura, sexo, favorito, idade, peso, imc, gc, me, mb, gv, diasDisponiveis, treino);
        this.pas = pas;
        this.pad = pad;
        this.bpm = bpm;
        this.glicemia = glicemia;
        this.observacoes = observacoes;
    }

    public int getPas() {
        return pas;
    }

    public void setPas(int pas) {
        this.pas = pas;
    }

    public int getPad() {
        return pad;
    }

    public void setPad(int pad) {
        this.pad = pad;
    }

    public int getBpm() {
        return bpm;
    }

    public void setBpm(int bpm) {
        this.bpm = bpm;
    }

    public int getGlicemia() {
        return glicemia;
    }

    public void setGlicemia(int glicemia) {
        this.glicemia = glicemia;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
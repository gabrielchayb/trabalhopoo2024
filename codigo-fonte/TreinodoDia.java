import java.util.ArrayList;
import java.util.List;

public class TreinoDoDia {
    private List<String> tipos;
    private List<String> exercicios;
    private int quantidadeTipos;
    private int quantidadeExercicios;
    private double duracaoMedia;

    public TreinoDoDia() {
        this.tipos = new ArrayList<>();
        this.exercicios = new ArrayList<>();
        this.quantidadeTipos = 0;
        this.quantidadeExercicios = 0;
        this.duracaoMedia = 0.0;
    }

    public void adicionarTipo(String tipo) {
        this.tipos.add(tipo);
        this.quantidadeTipos = this.tipos.size();
    }

    public void adicionarExercicio(String exercicio) {
        this.exercicios.add(exercicio);
        this.quantidadeExercicios = this.exercicios.size();
    }

    public List<String> getTipos() {
        return this.tipos;
    }

    public int getQuantidadeTipos() {
        return this.quantidadeTipos;
    }

    public int getQuantidadeExercicios() {
        return this.quantidadeExercicios;
    }

    public double getDuracaoMedia() {
        return this.duracaoMedia;
    }

    public void setTipos(List<String> tipos) {
        this.tipos = tipos;
        this.quantidadeTipos = tipos.size();
    }

    public void setExercicios(List<String> exercicios) {
        this.exercicios = exercicios;
        this.quantidadeExercicios = exercicios.size();
    }

    public void setQuantidadeTipos(int quantidadeTipos) {
        this.quantidadeTipos = quantidadeTipos;
    }

    public void setQuantidadeExercicios(int quantidadeExercicios) {
        this.quantidadeExercicios = quantidadeExercicios;
    }

    public void setDuracaoMedia(double duracaoMedia) {
        this.duracaoMedia = duracaoMedia;
    }
}
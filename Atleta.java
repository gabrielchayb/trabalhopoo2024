import java.util.UUID;

public class Atleta extends Aluno {
    private boolean offseason;
    private boolean precontest;
    private int gramasCarb;
    private int litrosAgua;

    public Atleta(String nomeAluno, double altura, String sexo, boolean favorito, int idade, double peso,
                  double imc, double gc, double me, double mb, double gv, String[] diasDisponiveis,
                  String treino, boolean offseason, boolean precontest, int gramasCarb, int litrosAgua) {
        super(nomeAluno, altura, sexo, favorito, idade, peso, imc, gc, me, mb, gv, diasDisponiveis, treino);
        this.offseason = offseason;
        this.precontest = precontest;
        this.gramasCarb = gramasCarb;
        this.litrosAgua = litrosAgua;
    }

    public boolean isOffseason() {
        return offseason;
    }

    public void setOffseason(boolean offseason) {
        this.offseason = offseason;
    }

    public boolean isPrecontest() {
        return precontest;
    }

    public void setPrecontest(boolean precontest) {
        this.precontest = precontest;
    }

    public int getGramasCarb() {
        return gramasCarb;
    }

    public void setGramasCarb(int gramasCarb) {
        this.gramasCarb = gramasCarb;
    }

    public int getLitrosAgua() {
        return litrosAgua;
    }

    public void setLitrosAgua(int litrosAgua) {
        this.litrosAgua = litrosAgua;
    }
}
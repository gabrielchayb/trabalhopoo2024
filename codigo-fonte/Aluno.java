import java.util.UUID;

public class Aluno {
    private String nomeAluno;
    private double altura;
    private String sexo;
    private boolean favorito;
    private String alunoID;
    private int idade;
    private double peso;
    private double imc;
    private double gc;
    private double me;
    private double mb;
    private double gv;
    private String[] diasDisponiveis;
    private String treino;

    public Aluno(String nomeAluno, double altura, String sexo, boolean favorito, int idade, double peso, double imc, double gc, double me, double mb, double gv, String[] diasDisponiveis, String treino) {
        this.nomeAluno = nomeAluno;
        this.altura = altura;
        this.sexo = sexo;
        this.favorito = favorito;
        this.alunoID = UUID.randomUUID().toString();
        this.idade = idade;
        this.peso = peso;
        this.imc = imc;
        this.gc = gc;
        this.me = me;
        this.mb = mb;
        this.gv = gv;
        this.diasDisponiveis = diasDisponiveis;
        this.treino = treino;
    }

    // Getters and Setters for each attribute
    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    public String getAlunoID() {
        return alunoID;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public double getGc() {
        return gc;
    }

    public void setGc(double gc) {
        this.gc = gc;
    }

    public double getMe() {
        return me;
    }

    public void setMe(double me) {
        this.me = me;
    }

    public double getMb() {
        return mb;
    }

    public void setMb(double mb) {
        this.mb = mb;
    }

    public double getGv() {
        return gv;
    }

    public void setGv(double gv) {
        this.gv = gv;
    }

    public String[] getDiasDisponiveis() {
        return diasDisponiveis;
    }

    public void setDiasDisponiveis(String[] diasDisponiveis) {
        this.diasDisponiveis = diasDisponiveis;
    }

    public String getTreino() {
        return treino;
    }

    public void setTreino(String treino) {
        this.treino = treino;
    }
}
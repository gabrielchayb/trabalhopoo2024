public class Tempo {
    private int horas;
    private int minutos;
    private int segundos;
    private double duracaoMedia;
    private int quantidadeExercicios;

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    @Override
    public String toString() {
        return "Tempo{" +
                "horas=" + horas +
                ", minutos=" + minutos +
                ", segundos=" + segundos +
                ", duracaoMedia=" + duracaoMedia +
                ", quantidadeExercicios=" + quantidadeExercicios +
                '}';
    }
}
public class AvaliacaoFisica {
    private double peso;
    private double medidasCorporais;
    private double percentualGordura;

    public AvaliacaoFisica(double peso, double medidasCorporais, double percentualGordura) {
        this.peso = peso;
        this.medidasCorporais = medidasCorporais;
        this.percentualGordura = percentualGordura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getMedidasCorporais() {
        return medidasCorporais;
    }

    public void setMedidasCorporais(double medidasCorporais) {
        this.medidasCorporais = medidasCorporais;
    }

    public double getPercentualGordura() {
        return percentualGordura;
    }

    public void setPercentualGordura(double percentualGordura) {
        this.percentualGordura = percentualGordura;
    }

    @Override
    public String toString() {
        return "Peso: " + peso + ", Medidas Corporais: " + medidasCorporais + ", Percentual de Gordura: " + percentualGordura;
    }
}

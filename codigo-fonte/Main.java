import java.util.ArrayList;
import java.util.Scanner;

class Aluno {
    private String nome;
    private ArrayList<AvaliacaoFisica> avaliacoes;

    public Aluno(String nome) {
        this.nome = nome;
        this.avaliacoes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void adicionarAvaliacao(AvaliacaoFisica avaliacao) {
        avaliacoes.add(avaliacao);
    }

    public void removerAvaliacao(int index) {
        if (index >= 0 && index < avaliacoes.size()) {
            avaliacoes.remove(index);
        }
    }

    public void visualizarAvaliacoes() {
        for (int i = 0; i < avaliacoes.size(); i++) {
            System.out.println("Avaliação " + (i + 1) + ": " + avaliacoes.get(i));
        }
    }

    public void editarAvaliacao(int index, AvaliacaoFisica novaAvaliacao) {
        if (index >= 0 && index < avaliacoes.size()) {
            avaliacoes.set(index, novaAvaliacao);
        }
    }
}

class AvaliacaoFisica {
    private double peso;
    private double medidasCorporais;
    private double percentualGordura;

    public AvaliacaoFisica(double peso, double medidasCorporais, double percentualGordura) {
        this.peso = peso;
        this.medidasCorporais = medidasCorporais;
        this.percentualGordura = percentualGordura;
    }

    @Override
    public String toString() {
        return "Peso: " + peso + ", Medidas Corporais: " + medidasCorporais + ", Percentual de Gordura: " + percentualGordura;
    }
}

class PersonalTrainer {
    private String nome;
    private ArrayList<Aluno> alunos;

    public PersonalTrainer(String nome) {
        this.nome = nome;
        this.alunos = new ArrayList<>();
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public void removerAluno(int index) {
        if (index >= 0 && index < alunos.size()) {
            alunos.remove(index);
        }
    }

    public void visualizarAlunos() {
        for (int i = 0; i < alunos.size(); i++) {
            System.out.println("Aluno " + (i + 1) + ": " + alunos.get(i).getNome());
        }
    }

    public void editarAluno(int index, Aluno novoAluno) {
        if (index >= 0 && index < alunos.size()) {
            alunos.set(index, novoAluno);
        }
    }

    public void gerarTreino(Aluno aluno) {
        System.out.println("Gerando treino para o aluno " + aluno.getNome() + " com base nas avaliações físicas.");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PersonalTrainer personalTrainer = new PersonalTrainer("João");

        while (true) {
            System.out.println("1. Adicionar Aluno");
            System.out.println("2. Remover Aluno");
            System.out.println("3. Visualizar Alunos");
            System.out.println("4. Editar Aluno");
            System.out.println("5. Adicionar Avaliação Física");
            System.out.println("6. Remover Avaliação Física");
            System.out.println("7. Visualizar Avaliações Físicas");
            System.out.println("8. Editar Avaliação Física");
            System.out.println("9. Gerar Treino");
            System.out.println("0. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1:
                    System.out.println("Nome do Aluno:");
                    String nomeAluno = scanner.nextLine();
                    personalTrainer.adicionarAluno(new Aluno(nomeAluno));
                    break;
                case 2:
                    System.out.println("Índice do Aluno para remover:");
                    int indiceRemover = scanner.nextInt();
                    personalTrainer.removerAluno(indiceRemover - 1);
                    break;
                case 3:
                    personalTrainer.visualizarAlunos();
                    break;
                case 4:
                    System.out.println("Índice do Aluno para editar:");
                    int indiceEditar = scanner.nextInt();
                    scanner.nextLine(); // Consumir nova linha
                    System.out.println("Novo nome do Aluno:");
                    String novoNomeAluno = scanner.nextLine();
                    personalTrainer.editarAluno(indiceEditar - 1, new Aluno(novoNomeAluno));
                    break;
                case 5:
                    System.out.println("Índice do Aluno para adicionar avaliação:");
                    int indiceAdicionarAvaliacao = scanner.nextInt();
                    System.out.println("Peso:");
                    double peso = scanner.nextDouble();
                    System.out.println("Medidas Corporais:");
                    double medidasCorporais = scanner.nextDouble();
                    System.out.println("Percentual de Gordura:");
                    double percentualGordura = scanner.nextDouble();
                    Aluno alunoParaAvaliar = personalTrainer.alunos.get(indiceAdicionarAvaliacao - 1);
                    alunoParaAvaliar.adicionarAvaliacao(new AvaliacaoFisica(peso, medidasCorporais, percentualGordura));
                    break;
                case 6:
                    System.out.println("Índice do Aluno para remover avaliação:");
                    int indiceRemoverAvaliacao = scanner.nextInt();
                    System.out.println("Índice da Avaliação para remover:");
                    int indiceAvaliacaoRemover = scanner.nextInt();
                    Aluno alunoParaRemoverAvaliacao = personalTrainer.alunos.get(indiceRemoverAvaliacao - 1);
                    alunoParaRemoverAvaliacao.removerAvaliacao(indiceAvaliacaoRemover - 1);
                    break;
                case 7:
                    System.out.println("Índice do Aluno para visualizar avaliações:");
                    int indiceVisualizarAvaliacoes = scanner.nextInt();
                    Aluno alunoParaVisualizarAvaliacoes = personalTrainer.alunos.get(indiceVisualizarAvaliacoes - 1);
                    alunoParaVisualizarAvaliacoes.visualizarAvaliacoes();
                    break;
                case 8:
                    System.out.println("Índice do Aluno para editar avaliação:");
                    int indiceEditarAvaliacao = scanner.nextInt();
                    System.out.println("Índice da Avaliação para editar:");
                    int indiceAvaliacaoEditar = scanner.nextInt();
                    System.out.println("Novo Peso:");
                    double novoPeso = scanner.nextDouble();
                    System.out.println("Novas Medidas Corporais:");
                    double novasMedidasCorporais = scanner.nextDouble();
                    System.out.println("Novo Percentual de Gordura:");
                    double novoPercentualGordura = scanner.nextDouble();
                    Aluno alunoParaEditarAvaliacao = personalTrainer.alunos.get(indiceEditarAvaliacao - 1);
                    alunoParaEditarAvaliacao.editarAvaliacao(indiceAvaliacaoEditar - 1, new AvaliacaoFisica(novoPeso, novasMedidasCorporais, novoPercentualGordura));
                    break;
                case 9:
                    System.out.println("Índice do Aluno para gerar treino:");
                    int indiceGerarTreino = scanner.nextInt();
                    Aluno alunoParaGerarTreino = personalTrainer.alunos.get(indiceGerarTreino - 1);
                    personalTrainer.gerarTreino(alunoParaGerarTreino);
                    break;
                case 0:
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
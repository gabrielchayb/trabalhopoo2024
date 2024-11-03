import java.util.ArrayList;
import java.util.UUID;

public class Personal {
    private String nome;
    private String telefone;
    private String email;
    private String personalID;
    private String senha;
    private ArrayList<Aluno> alunos;

    public Personal(String nome, String telefone, String email, String senha) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.personalID = UUID.randomUUID().toString();
        this.senha = senha;
        this.alunos = new ArrayList<>();
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPersonalID() {
        return personalID;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    // Método para adicionar aluno
    public void addAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }

    // Método para remover aluno
    public void removeAluno(Aluno aluno) {
        this.alunos.remove(aluno);
    }

    // Método para visualizar todos os alunos
    public void visualizarAlunos() {
        System.out.println("Lista de alunos do Personal Trainer " + nome + ":");
        for (Aluno aluno : alunos) {
            System.out.println("- " + aluno.getNomeAluno());
        }
    }

    // Método para gerar treino para um aluno específico
    public void gerarTreino(Aluno aluno) {
        if (!aluno.getAvaliacoes().isEmpty()) {
            // Pegando a última avaliação do aluno
            AvaliacaoFisica ultimaAvaliacao = aluno.getAvaliacoes().get(aluno.getAvaliacoes().size() - 1);
            System.out.println("Gerando treino para o aluno " + aluno.getNomeAluno() + " com base na avaliação:");
            System.out.println("Peso: " + ultimaAvaliacao.getPeso() + 
                               ", Medidas Corporais: " + ultimaAvaliacao.getMedidasCorporais() + 
                               ", Percentual de Gordura: " + ultimaAvaliacao.getPercentualGordura());
            // Aqui você pode expandir para adicionar lógica de treino personalizada
        } else {
            System.out.println("Nenhuma avaliação encontrada para o aluno " + aluno.getNomeAluno());
        }
    }
}

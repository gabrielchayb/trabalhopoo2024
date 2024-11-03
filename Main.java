import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Personal> personals = new ArrayList<>();

        while (true) {
            System.out.println("=== Sistema de Avaliações Físicas ===");
            System.out.println("1. Registrar Personal Trainer");
            System.out.println("2. Login Personal Trainer");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = lerInteiro(scanner);
            scanner.nextLine(); // Consumir a nova linha restante

            switch (opcao) {
                case 1:
                    registrarPersonal(scanner, personals);
                    break;
                case 2:
                    Personal personalLogado = loginPersonal(scanner, personals);
                    if (personalLogado != null) {
                        menuPersonal(scanner, personalLogado);
                    }
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    // Método para registrar um novo Personal Trainer
    private static void registrarPersonal(Scanner scanner, ArrayList<Personal> personals) {
        System.out.println("=== Registro de Personal Trainer ===");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        // Verificar se o email já está registrado
        for (Personal p : personals) {
            if (p.getEmail().equalsIgnoreCase(email)) {
                System.out.println("Email já registrado. Tente novamente.");
                return;
            }
        }

        Personal novoPersonal = new Personal(nome, telefone, email, senha);
        personals.add(novoPersonal);
        System.out.println("Personal Trainer registrado com sucesso!");
    }

    // Método para realizar o login de um Personal Trainer
    private static Personal loginPersonal(Scanner scanner, ArrayList<Personal> personals) {
        System.out.println("=== Login de Personal Trainer ===");
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        for (Personal p : personals) {
            if (p.getEmail().equalsIgnoreCase(email) && p.getSenha().equals(senha)) {
                System.out.println("Login bem-sucedido! Bem-vindo, " + p.getNome() + "!");
                return p;
            }
        }

        System.out.println("Email ou senha inválidos.");
        return null;
    }

    // Menu de opções para o Personal Trainer logado
    private static void menuPersonal(Scanner scanner, Personal personal) {
        while (true) {
            System.out.println("\n=== Menu do Personal Trainer ===");
            System.out.println("1. Adicionar Aluno");
            System.out.println("2. Remover Aluno");
            System.out.println("3. Visualizar Alunos");
            System.out.println("4. Editar Aluno");
            System.out.println("5. Favoritar Aluno");
            System.out.println("6. Desfavoritar Aluno");
            System.out.println("7. Adicionar Avaliação Física");
            System.out.println("8. Remover Avaliação Física");
            System.out.println("9. Visualizar Avaliações Físicas");
            System.out.println("10. Editar Avaliação Física");
            System.out.println("11. Gerar Treino");
            System.out.println("0. Logout");
            System.out.print("Escolha uma opção: ");
            int opcao = lerInteiro(scanner);
            scanner.nextLine(); // Consumir a nova linha restante

            switch (opcao) {
                case 1:
                    adicionarAluno(scanner, personal);
                    break;
                case 2:
                    removerAluno(scanner, personal);
                    break;
                case 3:
                    visualizarAlunos(personal);
                    break;
                case 4:
                    editarAluno(scanner, personal);
                    break;
                case 5:
                    favoritarAluno(scanner, personal, true);
                    break;
                case 6:
                    favoritarAluno(scanner, personal, false);
                    break;
                case 7:
                    adicionarAvaliacao(scanner, personal);
                    break;
                case 8:
                    removerAvaliacao(scanner, personal);
                    break;
                case 9:
                    visualizarAvaliacoes(scanner, personal);
                    break;
                case 10:
                    editarAvaliacao(scanner, personal);
                    break;
                case 11:
                    gerarTreino(scanner, personal);
                    break;
                case 0:
                    System.out.println("Logout realizado. Retornando ao menu principal.");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    // Método para adicionar um novo Aluno (incluindo subclasses)
    private static void adicionarAluno(Scanner scanner, Personal personal) {
        System.out.println("=== Adicionar Aluno ===");
        System.out.println("Selecione o tipo de Aluno:");
        System.out.println("1. Aluno Regular");
        System.out.println("2. Atleta");
        System.out.println("3. Aluno Idoso");
        System.out.print("Escolha uma opção: ");
        int tipoAluno = lerInteiro(scanner);
        scanner.nextLine(); // Consumir a nova linha restante

        System.out.print("Nome do Aluno: ");
        String nomeAluno = scanner.nextLine();
        System.out.print("Altura (em metros): ");
        double altura = lerDouble(scanner);
        scanner.nextLine(); // Consumir a nova linha
        System.out.print("Sexo (M/F): ");
        String sexo = scanner.nextLine();
        System.out.print("Favorito? (true/false): ");
        boolean favorito = lerBoolean(scanner);
        System.out.print("Idade: ");
        int idade = lerInteiro(scanner);
        System.out.print("Peso (kg): ");
        double peso = lerDouble(scanner);
        scanner.nextLine(); // Consumir a nova linha
        double imc = calcularIMC(peso, altura);
        double gc = 0.0; // Inicializar conforme necessário
        double me = 0.0; // Inicializar conforme necessário
        double mb = 0.0; // Inicializar conforme necessário
        double gv = 0.0; // Inicializar conforme necessário
        System.out.print("Dias Disponíveis (separados por vírgula): ");
        String diasInput = scanner.nextLine();
        String[] diasDisponiveis = diasInput.split(",");
        System.out.print("Treino: ");
        String treino = scanner.nextLine();

        Aluno novoAluno;

        switch (tipoAluno) {
            case 1:
                // Aluno Regular
                novoAluno = new Aluno(nomeAluno, altura, sexo, favorito, idade, peso, imc, gc, me, mb, gv, diasDisponiveis, treino);
                break;
            case 2:
                // Atleta
                System.out.print("Offseason? (true/false): ");
                boolean offseason = lerBoolean(scanner);
                System.out.print("Precontest? (true/false): ");
                boolean precontest = lerBoolean(scanner);
                System.out.print("Gramas de Carboidrato: ");
                int gramasCarb = lerInteiro(scanner);
                System.out.print("Litros de Água: ");
                int litrosAgua = lerInteiro(scanner);
                novoAluno = new Atleta(nomeAluno, altura, sexo, favorito, idade, peso, imc, gc, me, mb, gv, diasDisponiveis, treino, offseason, precontest, gramasCarb, litrosAgua);
                break;
            case 3:
                // Aluno Idoso
                System.out.print("Pressão Arterial Sistólica (PAS): ");
                int pas = lerInteiro(scanner);
                System.out.print("Pressão Arterial Diastólica (PAD): ");
                int pad = lerInteiro(scanner);
                System.out.print("Batimentos por Minuto (BPM): ");
                int bpm = lerInteiro(scanner);
                System.out.print("Glicemia (mg/dL): ");
                int glicemia = lerInteiro(scanner);
                System.out.print("Observações: ");
                String observacoes = scanner.nextLine();
                novoAluno = new AlunoIdoso(nomeAluno, altura, sexo, favorito, idade, peso, imc, gc, me, mb, gv, diasDisponiveis, treino, pas, pad, bpm, glicemia, observacoes);
                break;
            default:
                System.out.println("Tipo de Aluno inválido. Aluno não adicionado.");
                return;
        }

        personal.addAluno(novoAluno);
        System.out.println("Aluno adicionado com sucesso!");
    }

    // Método para remover um Aluno
    private static void removerAluno(Scanner scanner, Personal personal) {
        System.out.println("=== Remover Aluno ===");
        if (personal.getAlunos().isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }
        visualizarAlunos(personal);
        System.out.print("Índice do Aluno para remover: ");
        int indice = lerInteiro(scanner) - 1;
        if (indice >= 0 && indice < personal.getAlunos().size()) {
            Aluno removido = personal.getAlunos().get(indice);
            personal.removerAluno(removido);
            System.out.println("Aluno " + removido.getNomeAluno() + " removido com sucesso.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    // Método para visualizar todos os Alunos
    private static void visualizarAlunos(Personal personal) {
        System.out.println("=== Lista de Alunos ===");
        if (personal.getAlunos().isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }
        for (int i = 0; i < personal.getAlunos().size(); i++) {
            Aluno aluno = personal.getAlunos().get(i);
            String tipo = "";
            if (aluno instanceof Atleta) {
                tipo = " [Atleta]";
            } else if (aluno instanceof AlunoIdoso) {
                tipo = " [Idoso]";
            }
            System.out.println((i + 1) + ". " + aluno.getNomeAluno() + tipo + (aluno.isFavorito() ? " [Favorito]" : ""));
        }
    }

    // Método para editar um Aluno
    private static void editarAluno(Scanner scanner, Personal personal) {
        System.out.println("=== Editar Aluno ===");
        if (personal.getAlunos().isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }
        visualizarAlunos(personal);
        System.out.print("Índice do Aluno para editar: ");
        int indice = lerInteiro(scanner) - 1;
        if (indice >= 0 && indice < personal.getAlunos().size()) {
            Aluno aluno = personal.getAlunos().get(indice);
            System.out.println("Editando Aluno: " + aluno.getNomeAluno());

            System.out.print("Novo Nome (current: " + aluno.getNomeAluno() + "): ");
            String novoNome = scanner.nextLine();
            if (!novoNome.isEmpty()) {
                aluno.setNomeAluno(novoNome);
            }

            System.out.print("Nova Altura (current: " + aluno.getAltura() + "): ");
            String alturaInput = scanner.nextLine();
            if (!alturaInput.isEmpty()) {
                double novaAltura = Double.parseDouble(alturaInput);
                aluno.setAltura(novaAltura);
                double novoIMC = calcularIMC(aluno.getPeso(), novaAltura);
                aluno.setImc(novoIMC);
            }

            System.out.print("Novo Sexo (current: " + aluno.getSexo() + "): ");
            String novoSexo = scanner.nextLine();
            if (!novoSexo.isEmpty()) {
                aluno.setSexo(novoSexo);
            }

            System.out.print("Favorito? (current: " + aluno.isFavorito() + "): ");
            String favoritoInput = scanner.nextLine();
            if (!favoritoInput.isEmpty()) {
                boolean novoFavorito = Boolean.parseBoolean(favoritoInput);
                aluno.setFavorito(novoFavorito);
            }

            System.out.print("Nova Idade (current: " + aluno.getIdade() + "): ");
            String idadeInput = scanner.nextLine();
            if (!idadeInput.isEmpty()) {
                int novaIdade = Integer.parseInt(idadeInput);
                aluno.setIdade(novaIdade);
            }

            System.out.print("Novo Peso (current: " + aluno.getPeso() + "): ");
            String pesoInput = scanner.nextLine();
            if (!pesoInput.isEmpty()) {
                double novoPeso = Double.parseDouble(pesoInput);
                aluno.setPeso(novoPeso);
                double novoIMC = calcularIMC(novoPeso, aluno.getAltura());
                aluno.setImc(novoIMC);
            }

            System.out.print("Novo Treino (current: " + aluno.getTreino() + "): ");
            String novoTreino = scanner.nextLine();
            if (!novoTreino.isEmpty()) {
                aluno.setTreino(novoTreino);
            }

            // Verificar se o aluno é uma instância de Atleta ou AlunoIdoso e editar atributos específicos
            if (aluno instanceof Atleta) {
                Atleta atleta = (Atleta) aluno;
                System.out.print("Offseason? (current: " + atleta.isOffseason() + "): ");
                String offseasonInput = scanner.nextLine();
                if (!offseasonInput.isEmpty()) {
                    boolean offseason = Boolean.parseBoolean(offseasonInput);
                    atleta.setOffseason(offseason);
                }

                System.out.print("Precontest? (current: " + atleta.isPrecontest() + "): ");
                String precontestInput = scanner.nextLine();
                if (!precontestInput.isEmpty()) {
                    boolean precontest = Boolean.parseBoolean(precontestInput);
                    atleta.setPrecontest(precontest);
                }

                System.out.print("Gramas de Carboidrato (current: " + atleta.getGramasCarb() + "): ");
                String carbInput = scanner.nextLine();
                if (!carbInput.isEmpty()) {
                    int gramasCarb = Integer.parseInt(carbInput);
                    atleta.setGramasCarb(gramasCarb);
                }

                System.out.print("Litros de Água (current: " + atleta.getLitrosAgua() + "): ");
                String aguaInput = scanner.nextLine();
                if (!aguaInput.isEmpty()) {
                    int litrosAgua = Integer.parseInt(aguaInput);
                    atleta.setLitrosAgua(litrosAgua);
                }
            } else if (aluno instanceof AlunoIdoso) {
                AlunoIdoso alunoIdoso = (AlunoIdoso) aluno;
                System.out.print("Pressão Arterial Sistólica (PAS) (current: " + alunoIdoso.getPas() + "): ");
                String pasInput = scanner.nextLine();
                if (!pasInput.isEmpty()) {
                    int pas = Integer.parseInt(pasInput);
                    alunoIdoso.setPas(pas);
                }

                System.out.print("Pressão Arterial Diastólica (PAD) (current: " + alunoIdoso.getPad() + "): ");
                String padInput = scanner.nextLine();
                if (!padInput.isEmpty()) {
                    int pad = Integer.parseInt(padInput);
                    alunoIdoso.setPad(pad);
                }

                System.out.print("Batimentos por Minuto (BPM) (current: " + alunoIdoso.getBpm() + "): ");
                String bpmInput = scanner.nextLine();
                if (!bpmInput.isEmpty()) {
                    int bpm = Integer.parseInt(bpmInput);
                    alunoIdoso.setBpm(bpm);
                }

                System.out.print("Glicemia (mg/dL) (current: " + alunoIdoso.getGlicemia() + "): ");
                String glicemiaInput = scanner.nextLine();
                if (!glicemiaInput.isEmpty()) {
                    int glicemia = Integer.parseInt(glicemiaInput);
                    alunoIdoso.setGlicemia(glicemia);
                }

                System.out.print("Observações (current: " + alunoIdoso.getObservacoes() + "): ");
                String observacoesInput = scanner.nextLine();
                if (!observacoesInput.isEmpty()) {
                    alunoIdoso.setObservacoes(observacoesInput);
                }
            }

            System.out.println("Aluno atualizado com sucesso.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    // Método para favoritar ou desfavoritar um Aluno
    private static void favoritarAluno(Scanner scanner, Personal personal, boolean favoritar) {
        String ação = favoritar ? "Favoritar" : "Desfavoritar";
        System.out.println("=== " + ação + " Aluno ===");
        if (personal.getAlunos().isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }
        visualizarAlunos(personal);
        System.out.print("Índice do Aluno para " + ação.toLowerCase() + ": ");
        int indice = lerInteiro(scanner) - 1;
        if (indice >= 0 && indice < personal.getAlunos().size()) {
            Aluno aluno = personal.getAlunos().get(indice);
            aluno.setFavorito(favoritar);
            System.out.println("Aluno " + aluno.getNomeAluno() + " " + (favoritar ? "favoritado." : "desfavoritado."));
        } else {
            System.out.println("Índice inválido.");
        }
    }

    // Método para adicionar uma Avaliação Física a um Aluno
    private static void adicionarAvaliacao(Scanner scanner, Personal personal) {
        System.out.println("=== Adicionar Avaliação Física ===");
        if (personal.getAlunos().isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }
        visualizarAlunos(personal);
        System.out.print("Índice do Aluno para adicionar avaliação: ");
        int indiceAluno = lerInteiro(scanner) - 1;
        if (indiceAluno >= 0 && indiceAluno < personal.getAlunos().size()) {
            Aluno aluno = personal.getAlunos().get(indiceAluno);
            System.out.print("Peso (kg): ");
            double peso = lerDouble(scanner);
            System.out.print("Medidas Corporais: ");
            double medidasCorporais = lerDouble(scanner);
            System.out.print("Percentual de Gordura: ");
            double percentualGordura = lerDouble(scanner);
            AvaliacaoFisica avaliacao = new AvaliacaoFisica(peso, medidasCorporais, percentualGordura);
            aluno.adicionarAvaliacao(avaliacao);
            System.out.println("Avaliação adicionada com sucesso.");
        } else {
            System.out.println("Índice de aluno inválido.");
        }
    }

    // Método para remover uma Avaliação Física de um Aluno
    private static void removerAvaliacao(Scanner scanner, Personal personal) {
        System.out.println("=== Remover Avaliação Física ===");
        if (personal.getAlunos().isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }
        visualizarAlunos(personal);
        System.out.print("Índice do Aluno para remover avaliação: ");
        int indiceAluno = lerInteiro(scanner) - 1;
        if (indiceAluno >= 0 && indiceAluno < personal.getAlunos().size()) {
            Aluno aluno = personal.getAlunos().get(indiceAluno);
            if (aluno.getAvaliacoes().isEmpty()) {
                System.out.println("Nenhuma avaliação para este aluno.");
                return;
            }
            aluno.visualizarAvaliacoes();
            System.out.print("Índice da Avaliação para remover: ");
            int indiceAvaliacao = lerInteiro(scanner) - 1;
            if (indiceAvaliacao >= 0 && indiceAvaliacao < aluno.getAvaliacoes().size()) {
                aluno.removerAvaliacao(indiceAvaliacao);
                System.out.println("Avaliação removida com sucesso.");
            } else {
                System.out.println("Índice da avaliação inválido.");
            }
        } else {
            System.out.println("Índice de aluno inválido.");
        }
    }

    // Método para visualizar Avaliações Físicas de um Aluno
    private static void visualizarAvaliacoes(Scanner scanner, Personal personal) {
        System.out.println("=== Visualizar Avaliações Físicas ===");
        if (personal.getAlunos().isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }
        visualizarAlunos(personal);
        System.out.print("Índice do Aluno para visualizar avaliações: ");
        int indiceAluno = lerInteiro(scanner) - 1;
        if (indiceAluno >= 0 && indiceAluno < personal.getAlunos().size()) {
            Aluno aluno = personal.getAlunos().get(indiceAluno);
            aluno.visualizarAvaliacoes();
        } else {
            System.out.println("Índice de aluno inválido.");
        }
    }

    // Método para editar uma Avaliação Física de um Aluno
    private static void editarAvaliacao(Scanner scanner, Personal personal) {
        System.out.println("=== Editar Avaliação Física ===");
        if (personal.getAlunos().isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }
        visualizarAlunos(personal);
        System.out.print("Índice do Aluno para editar avaliação: ");
        int indiceAluno = lerInteiro(scanner) - 1;
        if (indiceAluno >= 0 && indiceAluno < personal.getAlunos().size()) {
            Aluno aluno = personal.getAlunos().get(indiceAluno);
            if (aluno.getAvaliacoes().isEmpty()) {
                System.out.println("Nenhuma avaliação para este aluno.");
                return;
            }
            aluno.visualizarAvaliacoes();
            System.out.print("Índice da Avaliação para editar: ");
            int indiceAvaliacao = lerInteiro(scanner) - 1;
            if (indiceAvaliacao >= 0 && indiceAvaliacao < aluno.getAvaliacoes().size()) {
                System.out.print("Novo Peso (kg): ");
                double novoPeso = lerDouble(scanner);
                System.out.print("Novas Medidas Corporais: ");
                double novasMedidasCorporais = lerDouble(scanner);
                System.out.print("Novo Percentual de Gordura: ");
                double novoPercentualGordura = lerDouble(scanner);
                AvaliacaoFisica novaAvaliacao = new AvaliacaoFisica(novoPeso, novasMedidasCorporais, novoPercentualGordura);
                aluno.editarAvaliacao(indiceAvaliacao, novaAvaliacao);
                System.out.println("Avaliação atualizada com sucesso.");
            } else {
                System.out.println("Índice da avaliação inválido.");
            }
        } else {
            System.out.println("Índice de aluno inválido.");
        }
    }

    // Método para gerar treino baseado na última Avaliação Física do Aluno
    private static void gerarTreino(Scanner scanner, Personal personal) {
        System.out.println("=== Gerar Treino ===");
        if (personal.getAlunos().isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }
        visualizarAlunos(personal);
        System.out.print("Índice do Aluno para gerar treino: ");
        int indiceAluno = lerInteiro(scanner) - 1;
        if (indiceAluno >= 0 && indiceAluno < personal.getAlunos().size()) {
            Aluno aluno = personal.getAlunos().get(indiceAluno);
            TreinoDoDia treinoDoDia = new TreinoDoDia();

            // Exemplo simples de geração de treino baseado em IMC
            double imc = aluno.getImc();
            if (imc < 18.5) {
                treinoDoDia.adicionarTipo("Ganho de Massa");
                treinoDoDia.adicionarExercicio("Supino");
                treinoDoDia.adicionarExercicio("Agachamento");
            } else if (imc >= 18.5 && imc < 25) {
                treinoDoDia.adicionarTipo("Manutenção");
                treinoDoDia.adicionarExercicio("Corrida");
                treinoDoDia.adicionarExercicio("Basquete");
            } else {
                treinoDoDia.adicionarTipo("Perda de Massa");
                treinoDoDia.adicionarExercicio("Caminhada");
                treinoDoDia.adicionarExercicio("Natação");
            }

            // Adicionar duração média fictícia
            treinoDoDia.setDuracaoMedia(60.0); // 60 minutos

            // Exibir o treino gerado
            System.out.println("=== Treino Gerado ===");
            System.out.println("Tipo de Treino: " + String.join(", ", treinoDoDia.getTipos()));
            System.out.println("Exercícios:");
            for (String exercicio : treinoDoDia.getExercicios()) {
                System.out.println("- " + exercicio);
            }
            System.out.println("Duração Média: " + treinoDoDia.getDuracaoMedia() + " minutos");
        } else {
            System.out.println("Índice de aluno inválido.");
        }
    }

    // Métodos auxiliares para leitura segura
    private static int lerInteiro(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Entrada inválida. Por favor, digite um número inteiro: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static double lerDouble(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.print("Entrada inválida. Por favor, digite um número válido: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    private static boolean lerBoolean(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("true") || input.equals("false")) {
                return Boolean.parseBoolean(input);
            } else {
                System.out.print("Entrada inválida. Por favor, digite 'true' ou 'false': ");
            }
        }
    }

    // Método para calcular o IMC
    private static double calcularIMC(double peso, double altura) {
        if (altura <= 0) return 0;
        return peso / (altura * altura);
    }
}
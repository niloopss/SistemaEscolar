import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        Aluno alunos[] = new Aluno[0]; // Inicializa o array de alunos com tamanho zero

        int opcao;
        do {
            System.out.println("Bem vindo(a) ao sistema da Jala University");
            System.out.println("Este é o nosso menu: ");
            System.out.println("1. Cadastrar novo aluno");
            System.out.println("2. Adicionar notas e faltas");
            System.out.println("3. Exibir informações de um aluno");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = leia.nextInt();

            switch (opcao) {
                case 1:
                    // Implementar cadastro de novo aluno
                    System.out.println("Cadastro de Novo Aluno:");
                    // Solicitar informações do aluno (matrícula, nome, email, etc.)
                    System.out.print("Matrícula: ");
                    int matricula = leia.nextInt();
                    leia.nextLine(); // Consumir a quebra de linha pendente

                    System.out.print("Nome: ");
                    String nome = leia.nextLine();

                    System.out.print("Email: ");
                    String email = leia.nextLine();

                    System.out.print("Curso: ");
                    String curso = leia.nextLine();

                    System.out.print("Telefone: ");
                    String telefone = leia.nextLine();

                    System.out.print("Endereço: ");
                    String endereco = leia.nextLine();

                    // Criar instância do novo aluno e adicioná-lo ao array
                    Aluno novoAluno = new Aluno(matricula, nome, email, curso, telefone, endereco);
                    alunos = Arrays.copyOf(alunos, alunos.length + 1);
                    alunos[alunos.length - 1] = novoAluno;
                    break;

                case 2:
                    // Implementar lançamento de notas e faltas
                    System.out.println("Lançamento de Notas e Faltas:");
                    System.out.print("Digite o número da matrícula do aluno: ");
                    int matriculaAluno = leia.nextInt();
                    boolean alunoEncontrado = false;

                    // Buscar o aluno pelo número de matrícula
                    for (Aluno aluno : alunos) {
                        if (aluno.getMatricula() == matriculaAluno) {
                            alunoEncontrado = true;

                            System.out.print("Digite a nota 1: ");
                            double nota1 = leia.nextDouble();

                            System.out.print("Digite a nota 2: ");
                            double nota2 = leia.nextDouble();

                            System.out.print("Digite a nota 3: ");
                            double nota3 = leia.nextDouble();

                            System.out.print("Digite o número de faltas: ");
                            int faltas = leia.nextInt();

                            // Lançar notas e faltas para o aluno
                            aluno.sistemaDeNotas(nota1, nota2, nota3);
                            aluno.sistemasDeFaltas(faltas);

                            System.out.println("Notas e faltas lançadas com sucesso para o aluno " + aluno.getNome());
                            break;
                        }
                    }

                    if (!alunoEncontrado) {
                        System.out.println("Aluno não encontrado. Certifique-se de que a matrícula está correta.");
                    }
                    break;

                case 3:
                    for (Aluno aluno : alunos) {
                        System.out.println(aluno.toString());
                    }
                    break;

                case 4:
                    System.out.println("Encerrando o programa.");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);
    }
}

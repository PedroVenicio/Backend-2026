import java.util.Scanner;

void main() {

    Scanner scanner = new Scanner(System.in);

    IO.println(String.format("Sistema de notas - escola Ozzy Osbourne"));

    System.out.println("Informe a quantidade de alunos que serão cadastrados: ");
    int qtd = scanner.nextInt();
    scanner.nextLine();

    String[] lista_aluno = new String[qtd];
    double[] lista_notas = new double[qtd];

    for (int i = 0; i < qtd; i++) {
        System.out.println("Informe o nome do aluno: ");
        String aluno = scanner.nextLine();
        lista_aluno[i] = aluno;

        System.out.println("Informe a nota 1 do aluno " + aluno + " : ");
        double nota1 = scanner.nextDouble();
        System.out.println("Informe a nota 2 do aluno " + aluno + " : ");
        double nota2 = scanner.nextDouble();
        System.out.println("Informe a nota 3 do aluno " + aluno + " : ");
        double nota3 = scanner.nextDouble();
        scanner.nextLine();
        lista_notas[i] = (nota1 + nota2 + nota3) / 3;
    }

    for (int i = 0; i < qtd; i++) {
        System.out.println("O aluno " + lista_aluno[i] + " terminou o semestre com média " + lista_notas[i]);
    }
}

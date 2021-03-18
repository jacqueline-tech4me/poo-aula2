package Programa;

import java.util.InputMismatchException;
import java.util.Scanner;

import Classes.Aluno;

public class ProgramaAluno {
    public static void main(String[] args) {
        Aluno aluno = new Aluno();
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite o nome: ");
        aluno.setNome(ler.nextLine());

        try {
          System.out.println("Digite o cpf: ");
          aluno.setCpf(ler.nextLine());
        } catch (NumberFormatException e) {
          System.out.println(e.getMessage());
          System.out.println("Encerrando, pois sem CPF não dá!");
          ler.close();
          return;
        } catch (NullPointerException e) {
          System.out.println(e.getMessage()); 
          System.out.println("CPF nulo. Utilizando o CPF padrão 000.000.000-00");
          aluno.setCpf("00000000000"); 
        }
        
        try {
            System.out.println("Digite a idade: ");
            aluno.setIdade(ler.nextInt());
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            System.out.println("A idade padrão será setada como 18 anos");
            aluno.setIdade(18);
        }
        ler.close();

        System.out.println(aluno.toString());

    }
    
}

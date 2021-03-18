package Classes;

import java.util.InputMismatchException;

public class Aluno {
    private String nome;
    private String cpf;
    private int idade;

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return formataCPF(cpf);
    }

    public void setCpf(String cpf) {
        if (cpf == null) {
           throw new NullPointerException("O CPF está nulo.");
        }

        cpf = cpf.trim().replace(".", "").replace("-", "");
   
        if (cpf.length() == 11) {
          this.cpf = cpf;
        } else {
            throw new NumberFormatException("Número de caracteres inválidos para o CPF.");
        }
    }

    public void setNome(String nome) {
       if (nome.matches(".*\\d.*")) {
         System.out.println("Nome não pode conter números");  
       } else {
        this.nome = nome;
       }    
    }

    private String formataCPF(String cpf) {
        cpf = cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
        return cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade < 0) {
            throw new InputMismatchException("Idade não pode ser negativa.");
        } else
          this.idade = idade;
    }

    public String getFaixaEtaria() {
        if (this.idade < 12) {
            return "Criança";
        } else 
          if (this.idade < 65) {
              return "Adulto";
        } else
          return "Idoso";
    }

    @Override
    public String toString() {
        return String.format("Aluno: %s \nCPF: %s \nIdade: %d \nFaixa etária: %s", 
          nome, cpf, idade, getFaixaEtaria());
    }
   
}

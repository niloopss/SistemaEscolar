import java.util.Arrays;
import java.util.Scanner;

public class Aluno {
    private int matricula;
    private String nome;
    private String email;
    private String curso;
    private String telefone;
    private String endereco;
    private int numFaltas;
    private double[] notas;

    public Aluno(int matricula, String nome, String email, String curso, String telefone, String endereco) {
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.numFaltas = 0;
        this.notas = new double[3]; //aramazenando 3 notas para as 3 provas
    }
    public int getMatricula(){
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumFaltas() {
        return numFaltas;
    }

    public void setNumFaltas(int numFaltas) {
        this.numFaltas = numFaltas;
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        this.notas = notas;
    }
    public void sistemasDeFaltas(int faltas){
        if (faltas >= 0){
            this.numFaltas = faltas;
        }else{
            System.out.println("Não é possível que o número de faltas seja menor que 0");
        }
    }
    public void sistemaDeNotas(double nota1, double nota2, double nota3){
        if (nota1 >= 0 && nota2 >= 0 && nota3 >= 0 && nota1 <= 100 && nota2 <= 100 && nota3 <= 100){
            this.notas[0]= nota1;
            this.notas[1]= nota2;
            this.notas[2]= nota3;
        }else{
            System.out.println("Erro, as notas DEVEM estar no intervalo de 0 a 100.");
        }
    }
    public String notaFinal(){
        double media = calcularMedia();
        int mediaDeFaltas = calcularMediaDeFaltas();
        if (media >= 70 && numFaltas<= 15){
            return "Aluno aprovado";
        } else if (media < 50 || numFaltas > 15) {
            return "Aluno reprovado";
        } else if (media >= 50) {
            return "Aluno terá que fazer um Exame";
        } else{
            return "Indefinido";
        }
    }
    public double calcularMedia(){
        double soma = 0;
        for (double nota : notas){
            soma += nota;
        }
        return soma / notas.length;
    }
    public int calcularMediaDeFaltas(){
        return (numFaltas * 100) / 15;
    }
    public String toString(){
        return "Matrícula: "+matricula+ ", Nome: "+nome+", Situação Final: "+notaFinal();
    }
}

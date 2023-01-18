package models;

public class Pessoa {
    private String nome;
    private String cpf;
    private Integer idade;

    public Pessoa(String nome, String cpf, Integer idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }
    public Pessoa(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;
    }
    public String getNome() {
        return this.nome;
    }
    public String getCPF() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getIdade() {
        return this.idade;
    }

    @Override
    public String toString(){
        String pessoaString = "Nome: " + this.nome;
        if(this.cpf != null){
            pessoaString +=", CPF: " + this.cpf;
        }
        pessoaString += ", Idade: " + this.idade;
        return pessoaString;
    }

}

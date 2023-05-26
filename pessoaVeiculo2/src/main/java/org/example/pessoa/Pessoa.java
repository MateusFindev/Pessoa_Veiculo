package org.example.pessoa;

import org.example.veiculo.Carro;
import org.example.veiculo.Moto;

import javax.sound.midi.Soundbank;
import java.util.List;
import java.util.Scanner;

public abstract class Pessoa {
    private String nome;
    private String telefone;
    private String endereco;


    public static void escolherPessoa(List<PessoaFisica> listaPf, List<PessoaJuridica> listaPj, int resposta) {
        int resposta2;
        Scanner scan = new Scanner(System.in);

        PessoaFisica pfEscolhida = null;
        PessoaJuridica pjEscolhida = null;

        System.out.println("\nQual dessas Pessoas você é?");
        System.out.print("Digite o número da Pessoa:");
        resposta2 = scan.nextInt();

        if(resposta== 1){
            pfEscolhida = listaPf.get(resposta2-1);
        } else if (resposta== 2) {pjEscolhida = listaPj.get(resposta2-1);}
    }

    public abstract void salvarDadosPessoa();


    //CONSTRUCTOR
    public Pessoa(String nome, String telefone, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    // GETTERS E SETTERS
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public abstract String toString(int numeroPessoa);
}


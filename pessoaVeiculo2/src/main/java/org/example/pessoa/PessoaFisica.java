package org.example.pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PessoaFisica extends Pessoa{
    private String cpf;

    @Override
    public void salvarDadosPessoa() {
        Scanner scan = new Scanner(System.in);

        System.out.println("[CADASTRO PESSOA FÍSICA]\n");
        System.out.print("Nome: ");
        this.setNome(scan.next());

        System.out.print("Telefone: ");
        this.setTelefone(scan.next());

        System.out.print("Endereço: ");
        this.setEndereco(scan.next());

        System.out.print("CPF: ");
        this.setCpf(scan.next());

        System.out.println("\nPessoa cadastrada com sucesso!\n");
    }

    public List<PessoaFisica> registrarNaLista(List<PessoaFisica> listaPf){
        this.salvarDadosPessoa();
        listaPf.add(this);
        return listaPf;
    }


    @Override
    public String toString(int numeroPessoa) {
        return "\n[PF "+numeroPessoa+"]\n\nNome: "+ this.getNome()+"    Telefone: "+this.getTelefone()+"\nEndereço: "+this.getEndereco()+"CPF: "+ this.getCpf()
                +"\n -------------------------------------------------";
    }

    public static List instanciarPFPadrao(){
        List<PessoaFisica> listaPf = new ArrayList<>();

        listaPf.add(new PessoaFisica("Mateus Fin","(45) 1234-5678","Avenida dos Girassóis, 456","123.456.789-00"));
        listaPf.add(new PessoaFisica("Lucas Silva","(45) 9876-5432","Rua das Flores, 123","987.654.321-11"));
        listaPf.add(new PessoaFisica("Camila Santos","(45) 2468-1357","Travessa das Acácias, 789","555.444.333-22"));
        listaPf.add(new PessoaFisica("Mateus Oliveira","(45) 3698-0147","Praça das Margaridas, 101","888.777.666-33"));
        listaPf.add(new PessoaFisica("Isabella Costa","(45) 8023-4571","Alameda dos Cravos, 234","999.888.777-44"));

        return listaPf;
    }

    public static void imprimirPf(List<PessoaFisica> lista){
        int x=0;

        for (PessoaFisica i : lista) {
            x++;
            System.out.println(i.toString(x));
        }
    }




    //CONSTRUCTOR
    public PessoaFisica(String name, String telefone, String endereco ,String cpf) {
        super(name,telefone,endereco);
        this.cpf = cpf;
    }

    //GETTERS E SETTER
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}

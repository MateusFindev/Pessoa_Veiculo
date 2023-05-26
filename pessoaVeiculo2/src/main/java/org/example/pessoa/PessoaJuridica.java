package org.example.pessoa;

import org.example.veiculo.Moto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PessoaJuridica extends Pessoa {
    private String cnpj;

    public PessoaJuridica(String nome, String telefone, String endereco, String cnpj) {
        super(nome, telefone, endereco);
        this.cnpj = cnpj;
    }

    public List<PessoaJuridica> registrarNaLista(List<PessoaJuridica> listaPj){
        this.salvarDadosPessoa();
        listaPj.add(this);
        return listaPj;
    }

    @Override
    public void salvarDadosPessoa() {
        Scanner scan = new Scanner(System.in);

        System.out.println("[CADASTRO PESSOA JURÍDICA]\n");
        System.out.print("Nome: ");
        this.setNome(scan.next());

        System.out.print("Telefone: ");
        this.setTelefone(scan.next());

        System.out.print("Endereço: ");
        this.setEndereco(scan.next());

        System.out.print("CNPJ: ");
        this.setCnpj(scan.next());

        System.out.println("\nPessoa cadastrada com sucesso!\n");
    }

    @Override
    public String toString(int numeroPessoa) {
        return "\n[PF "+numeroPessoa+"]\n\nNome: "+ this.getNome()+"    Telefone: "+this.getTelefone()+"\nEndereço: "+this.getEndereco()+"CPF: "+ this.getCnpj()
                +"\n -------------------------------------------------";
    }

    public static List instanciarPJpadrao(){
        List<PessoaJuridica> listaPJ = new ArrayList<>();

        listaPJ.add(new PessoaJuridica("Mateus Fin","(45) 1234-5678","Avenida dos Girassóis, 456","12.345.678/0001-90"));
        listaPJ.add(new PessoaJuridica("Lucas Silva","(45) 9876-5432","Rua das Flores, 123","98.765.432/0001-21"));
        listaPJ.add(new PessoaJuridica("Camila Santos","(45) 2468-1357","Travessa das Acácias, 789","55.444.333/0001-52"));
        listaPJ.add(new PessoaJuridica("Mateus Oliveira","(45) 3698-0147","Praça das Margaridas, 101","88.777.666/0001-83"));
        listaPJ.add(new PessoaJuridica("Isabella Costa","(45) 8023-4571","Alameda dos Cravos, 234","99.888.777/0001-14"));

        return listaPJ;
    }

    public static void imprimirPj(List<PessoaJuridica> lista){
        int x=0;

        for (PessoaJuridica i : lista) {
            x++;
            System.out.println(i.toString(x));
        }
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}

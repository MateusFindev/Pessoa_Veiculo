package org.example;

import org.example.pessoa.Pessoa;
import org.example.pessoa.PessoaFisica;
import org.example.pessoa.PessoaJuridica;
import org.example.veiculo.Carro;
import org.example.veiculo.Moto;
import org.example.veiculo.Veiculo;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List listaCarros =  Carro.instanciarCarrosPadrao();
        List listaMotos = Moto.instanciarMotosPadrao();
        List listaPFPadrao = PessoaFisica.instanciarPFPadrao();
        List listaPJPadrao = PessoaJuridica.instanciarPJpadrao();

        aplicacao(listaCarros,listaMotos,listaPJPadrao,listaPFPadrao);
    }


    public static void aplicacao(List<Carro> listaCarros, List<Moto> listaMotos, List<PessoaJuridica> listaPJPadrao,List<PessoaFisica> listaPFPadrao){
        Scanner scan = new Scanner(System.in);

        int resposta = 0;

        System.out.println("Escolha uma das opções:\n");
        System.out.println("[1] Usar um veículo" + "\n[2] Cadastrar pessoa" + "\n[3] Cadastrar Veículo");
        System.out.print("\nDigite a opção: ");
        resposta = scan.nextInt();


        switch (resposta) {
            case 1: //USAR UM VEÍCULO
                opcoesEscolherPessoa(listaCarros,listaMotos,listaPJPadrao,listaPFPadrao);
                opcoesUsarVeiculo(listaCarros,listaMotos,listaPJPadrao,listaPFPadrao);
                break;


            case 2: // CADASTRAR PESSOA
                System.out.println("Gostaria de cadastrar qual tipo de pessoa?\n\n[1] Pessoa Física\n[2] Pessoa Jurídica\n[0] Voltar\n");
                System.out.print("Digite a opção desejada:");
                int resposta2 = scan.nextInt();

                switch (resposta2) {
                    case 1:
                        PessoaFisica pessoaFisica = new PessoaFisica(null,null,null,null);
                        listaPFPadrao = pessoaFisica.registrarNaLista(listaPFPadrao);
                        break;
                    case 2:
                        PessoaJuridica pessoaJuridica = new PessoaJuridica(null,null,null,null);
                        listaPJPadrao = pessoaJuridica.registrarNaLista(listaPJPadrao);
                        break;
                    case 0:
                        aplicacao(listaCarros,listaMotos,listaPJPadrao,listaPFPadrao);
                        break;
                    default:
                        System.out.println("\nInsira uma resposta válida!\n");

                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                        aplicacao(listaCarros,listaMotos,listaPJPadrao,listaPFPadrao);
                        break;
                }

                aplicacao(listaCarros,listaMotos,listaPJPadrao,listaPFPadrao);
                break;


            case 3: //CADASTRAR VEICULO
                System.out.println("Gostaria de cadastrar qual tipo de Veículo?\n\n[1] Carro\n[2] Moto\n[0] Voltar\n");
                System.out.print("Digite a opção desejada:");
                int resposta3 = scan.nextInt();

                switch (resposta3) {
                    case 1:
                        Carro carro = new Carro(null,0,0,0,false, 0);
                        listaCarros = carro.registrarNaLista(listaCarros, listaMotos);
                        break;
                    case 2:
                        Moto moto = new Moto(null,0,0,0,false, 0);
                        listaMotos = moto.registrarNaLista(listaCarros,listaMotos);
                        break;
                    case 0:
                        aplicacao(listaCarros,listaMotos,listaPJPadrao,listaPFPadrao);
                        break;
                    default:
                        System.out.println("\nInsira uma resposta válida!\n");

                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                        aplicacao(listaCarros,listaMotos,listaPJPadrao,listaPFPadrao);
                        break;
                }

                aplicacao(listaCarros,listaMotos,listaPJPadrao,listaPFPadrao);
                break;
            default:
                System.out.println("\nInsira uma resposta válida!\n");

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                aplicacao(listaCarros,listaMotos,listaPJPadrao,listaPFPadrao);
                break;
        }
    }
    public static void opcoesUsarVeiculo(List<Carro> listaCarro, List<Moto> listaMoto, List<PessoaJuridica> listaPJPadrao,List<PessoaFisica> listaPFPadrao) {
        int resposta = 0;
        Scanner scan = new Scanner(System.in);


        System.out.println("\nSelecione a opção desejada: \n");
        System.out.println("[1] Escolher um Carro" + "\n[2] Escolher uma Moto" + "\n[0] Voltar\n");
        System.out.print("\nDigite a opção: ");
        resposta = scan.nextInt();

        switch (resposta) {
            case 1:
                Carro.imprimirCarros(listaCarro);
                Carro.escolherVeiculo(listaCarro, listaMoto, resposta, listaPJPadrao, listaPFPadrao);
                break;
            case 2:
                Moto.imprimirMotos(listaMoto);
                Moto.escolherVeiculo(listaCarro, listaMoto, resposta, listaPJPadrao, listaPFPadrao);
                break;
            case 0:
                aplicacao(listaCarro,listaMoto,listaPJPadrao,listaPFPadrao);
                break;
            default:
                System.out.println("\nInsira uma resposta válida!\n");

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                opcoesUsarVeiculo(listaCarro, listaMoto,listaPJPadrao,listaPFPadrao);
                break;
        }
    }

    public static void opcoesEscolherPessoa(List<Carro> listaCarros, List<Moto> listaMotos, List<PessoaJuridica> listaPj, List<PessoaFisica> listaPf){
        Scanner scan = new Scanner(System.in);

        System.out.println("Escolha a opção no qual você se encontra:\n\n[1] Pessoa Física\n[2] Pessoas Jurídica\n[0] Voltar\n");
        System.out.print("Digite a opção:");
        int resposta = scan.nextInt();

        switch (resposta) {
            case 1:
                PessoaFisica.imprimirPf(listaPf);
                PessoaFisica.escolherPessoa(listaPf,listaPj, resposta);
                break;
            case 2:
                PessoaJuridica.imprimirPj(listaPj);
                PessoaJuridica.escolherPessoa(listaPf,listaPj, resposta);
                break;
            case 0:
                aplicacao(listaCarros,listaMotos,listaPj,listaPf);
            default:
                System.out.println("\nInsira uma resposta válida!\n");

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                opcoesEscolherPessoa(listaCarros,listaMotos,listaPj,listaPf);
                break;

        }

    }
}
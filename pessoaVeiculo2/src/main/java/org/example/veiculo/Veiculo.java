package org.example.veiculo;

import org.example.Main;
import org.example.pessoa.PessoaFisica;
import org.example.pessoa.PessoaJuridica;

import java.util.List;
import java.util.Scanner;

public abstract class Veiculo {
    private String placa;
    private int combustivelNoTanque;
    private int quilometragem;
    private double precoDiaria;
    private boolean alugado;

    public void abastecer(int adicionar) {
        int combustivel = getCombustivelNoTanque()+adicionar;
        System.out.println("Seu combustível no tanque foi de "+(getCombustivelNoTanque()-adicionar)+" litros para "+combustivel+" litros");
        setCombustivelNoTanque(combustivel);
    }

    public boolean equals(Veiculo veiculo, List<Carro> listaCarros, List<Moto> listaMotos) {
        for (Veiculo veiculo1 : listaCarros){
            if(veiculo1.getPlaca().equals(veiculo.getPlaca())){
                return true;
            }
        }

        for (Veiculo veiculo2 : listaMotos){
            if(veiculo2.getPlaca().equals(veiculo.getPlaca())){
                return true;
            }
        }

        return false;
    }

    public boolean viajar(int distancia){

        double combustivelUtilizado = 0;

        if (this.getClass() == Moto.class) {combustivelUtilizado = distancia/30;
        } else if (this.getClass() == Carro.class){combustivelUtilizado = distancia/10;}

        if (combustivelUtilizado >= getCombustivelNoTanque()) {
            System.out.println("\nO combustível no tanque não é o suficiente para concluir a viagem!");
            return false;
        } else {
            setQuilometragem(getQuilometragem()+distancia);
            setCombustivelNoTanque(getCombustivelNoTanque() - (int) Math.round(combustivelUtilizado));
            System.out.println("\nDisponível para viajar");
            System.out.println("Quilometragem após viagem: "+getQuilometragem()+"   Combustível no tanque após viagem: "+getCombustivelNoTanque()+" l");
            return true;
        }
    }

    public static void escolherVeiculo (List<Carro> listaCarro, List<Moto> listaMoto, int resposta, List<PessoaJuridica> listaPJPadrao,List<PessoaFisica> listaPFPadrao){
        int resposta2;
        Scanner scan = new Scanner(System.in);
        Carro carroEscolhido = null;
        Moto motoEscolhida = null;

        System.out.println("\nQual desses veículos você gostaria de usar?");
        System.out.print("Digite o número do veículo:");
        resposta2 = scan.nextInt();

        if (resposta==1){
            carroEscolhido = listaCarro.get(resposta2-1);
        } else {
            motoEscolhida = listaMoto.get(resposta2-1);
        }

        escolherOperacao(carroEscolhido,motoEscolhida,resposta,listaCarro,listaMoto, listaPJPadrao, listaPFPadrao);


    }

    public static void escolherOperacao (Carro carroEscolhido, Moto motoEscolhida, int resposta, List<Carro> listaCarro, List<Moto> listaMoto, List<PessoaJuridica> listaPJPadrao, List<PessoaFisica> listaPFPadrao){
        int resposta2=0;
        Scanner scan = new Scanner(System.in);

        System.out.println("\nO que você gostaria de fazer?\n\n[1] Abastecer o veiculo\n[2] Verificar disponibilidade para viagem\n[0] Voltar");
        System.out.print("\nDigite a opção: ");
        resposta2 =scan.nextInt();

        switch (resposta2) {
            case 2:
                System.out.println("\nQual a distância da viagem?");
                System.out.print("Digite a distancia em KM(inteiros):");
                int distancia = scan.nextInt();
                if(resposta == 1){carroEscolhido.viajar(distancia);} else {motoEscolhida.viajar(distancia);}
                break;
            case 1:
                System.out.println("\nQuanto gostaria de abastecer?");
                System.out.print("Digite a quantidade em Litros(inteiros):");
                int litros = scan.nextInt();
                if(resposta == 1){carroEscolhido.abastecer(litros);} else {motoEscolhida.abastecer(litros);}
                break;
            case 0:
                Main.opcoesUsarVeiculo(listaCarro, listaMoto, listaPJPadrao, listaPFPadrao);
                break;
            default:
                System.out.println("\nInsira uma resposta válida!\n");

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                Main.opcoesUsarVeiculo(listaCarro, listaMoto, listaPJPadrao, listaPFPadrao);
                break;
        }
    }


    //FUNÇÕES ABSTRATAS
    public abstract void salvarDadosVeiculo(List<Carro> listaCarros, List<Moto> listaMotos);

    //CONSTRUCTOR
    public Veiculo(String placa, int combustivelNoTanque, int quilometragem, double precoDiaria, boolean alugado) {
        this.placa = placa;
        this.combustivelNoTanque = combustivelNoTanque;
        this.quilometragem = quilometragem;
        this.precoDiaria = precoDiaria;
        this.alugado = alugado;
    }

    //GETTER E SETTER
    public String getPlaca() {
        return placa;
    }

    public int getCombustivelNoTanque() {
        return combustivelNoTanque;
    }

    public int getQuilometragem() {
        return quilometragem;
    }

    public double getPrecoDiaria() {
        return precoDiaria;
    }

    public boolean isAlugado() {
        return alugado;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setCombustivelNoTanque(int combustivelNoTanque) {
        this.combustivelNoTanque = combustivelNoTanque;
    }

    public void setQuilometragem(int quilometragem) {
        this.quilometragem = quilometragem;
    }

    public void setPrecoDiaria(float precoDiaria) {
        this.precoDiaria = precoDiaria;
    }

    public void setAlugado(boolean alugado) {
        this.alugado = alugado;
    }

}

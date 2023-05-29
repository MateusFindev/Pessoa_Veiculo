package org.example.veiculo;

import org.example.pessoa.PessoaFisica;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Carro extends Veiculo {
    private int potenciaDoMotor;


    public static String toString(int numeroVeiculo, Carro i) {
        return "\n[CARRO "+numeroVeiculo+"]\n\n Placa: "+i.getPlaca()+"   Combústivel no tanque: "+i.getCombustivelNoTanque()+"l    Quilometragem: "+i.getQuilometragem()+"" +
                "\n Preço Diária: R$"+i.getPrecoDiaria()+"     Alugado: "+i.isAlugado()+"    Potência Motor: "+i.getPotenciaDoMotor()+"\n -------------------------------------------------";
    }

    public static void imprimirCarros( List<Carro> lista){
        int x=0;

        for (Carro i : lista) {
            x++;
            System.out.println(Carro.toString(x,i));
        }
    }

    public List<Carro> registrarNaLista(List<Carro> listaCarro, List<Moto> listaMotos){
        this.salvarDadosVeiculo(listaCarro, listaMotos);
        listaCarro.add(this);
        return listaCarro;
    }

    @Override
    public void salvarDadosVeiculo(List<Carro> listaCarros, List<Moto> listaMotos) {
        Scanner scan = new Scanner(System.in);

        System.out.println("[CADASTRO CARRO]\n");
        System.out.print("Placa: ");
        this.setPlaca(scan.next());
        if (this.equals(this,listaCarros, listaMotos) == true){
            System.out.println("Já possuímos um veículo com esta placa! Tente novamente");
            salvarDadosVeiculo(listaCarros,listaMotos);
            this.setPlaca(null);
        }

        System.out.print("Quilometragem: ");
        this.setQuilometragem(scan.nextInt());

        System.out.print("Preço diaria: ");
        this.setPrecoDiaria(scan.nextInt());

        System.out.print("Combustível no tanque: ");
        this.setCombustivelNoTanque(scan.nextInt());

        System.out.print("Alugado ([1] Sim   [2] Não): ");
        int alugado = scan.nextInt();
        if (alugado==1) {
            this.setAlugado(true);
        } else if (alugado==2) {
            this.setAlugado(false);
        }

        System.out.print("Potência do motor: ");
        this.setPotenciaDoMotor(scan.nextInt());

        System.out.println("\nVeículo cadastrado com sucesso!\n");
    }


    //INSTÂNCIA CARROS
    public static List instanciarCarrosPadrao(){
        List listaCarros = new ArrayList();

        listaCarros.add(new Carro("BBF98G0",32,125347 ,150.00,true,250));
        listaCarros.add(new Carro("ABC1D23",56,101896 ,250.00,true,200));
        listaCarros.add(new Carro("XYZ4E56",63,135021 ,190.23,true,120));
        listaCarros.add(new Carro("QWE7R89",49,102809 ,200.98,true,130));
        listaCarros.add(new Carro("RTY0U12",25,122434 ,220.65,true,160));
        listaCarros.add(new Carro("MNB3V45",41,130187 ,400.56,true,110));

        return listaCarros;
    };


    //CONSTRUCTOR
    public Carro(String placa, int combustivelNoTanque, int quilometragem, double precoDiaria, boolean alugado, int potenciaDoMotor) {
        super(placa, combustivelNoTanque, quilometragem, precoDiaria, alugado);
        this.potenciaDoMotor = potenciaDoMotor;
    }


    //GETTERS E SETTERS
    public int getPotenciaDoMotor() {
        return potenciaDoMotor;
    }

    public void setPotenciaDoMotor(int potenciaDoMotor) {
        this.potenciaDoMotor = potenciaDoMotor;
    }



}

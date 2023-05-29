package org.example.veiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Moto extends Veiculo {
    private int cilindradas;

    public static String toString(int numeroVeiculo, Moto i) {
        return "\n[MOTO "+numeroVeiculo+"]\n\n Placa: "+i.getPlaca()+"   Combústivel no tanque: "+i.getCombustivelNoTanque()+"l    Quilometragem: "+i.getQuilometragem()+"" +
                "\n Preço Diária: R$"+i.getPrecoDiaria()+"     Alugado: "+i.isAlugado()+"    Cilindradas: "+i.getCilindradas()+"\n -------------------------------------------------";
    }

    @Override
    public void salvarDadosVeiculo(List<Carro> listaCarros, List<Moto> listaMotos) {
        Scanner scan = new Scanner(System.in);

        System.out.println("[CADASTRO MOTO]\n");
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

        System.out.print("Cilindradas: ");
        this.setCilindradas(scan.nextInt());

        System.out.println("\nVeículo cadastrado com sucesso!\n");
    }

    public List<Moto> registrarNaLista(List<Carro> listaCarro, List<Moto> listaMoto){
        this.salvarDadosVeiculo(listaCarro,listaMoto);
        listaMoto.add(this);
        return listaMoto;
    }
    public static void imprimirMotos(List<Moto> lista){
        int x=0;

        for (Moto i : lista) {
            x++;
            System.out.println(Moto.toString(x,i));
        }
    }


    //INSTANCIA MOTO
    public static List instanciarMotosPadrao(){
        List listaMotos = new ArrayList();

        listaMotos.add(new Moto("TGB8U90",17,125347 ,70.00,true,250));
        listaMotos.add(new Moto("OIU5Y67",29,101896 ,80.00,true,500));
        listaMotos.add(new Moto("CVB2N34",25,135021 ,90.23,true,750));
        listaMotos.add(new Moto("DFG9H01",22,102809 ,25.98,true,1000));
        listaMotos.add(new Moto("JKL6P78",23,122434 ,35.65,true,800));
        listaMotos.add(new Moto("MNO8J90",31,130187 ,40.56,true,200));

        return listaMotos;
    };

    //CONSTRUCTOR
    public Moto(String placa, int combustivelNoTanque, int quilometragem, double precoDiaria, boolean alugado, int cilindradas) {
        super(placa, combustivelNoTanque, quilometragem, precoDiaria, alugado);
        this.cilindradas = cilindradas;
    }

    //GETTER E SETTERS
    public int getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }
}

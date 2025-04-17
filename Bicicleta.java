package Wheels;

import java.util.Random;

public class Bicicleta {
    //criação da bicicleta
    //setar membros das variáveis
    protected int numeroBicicleta;
    protected String nome;
    protected String marca;
    protected String modelo;
    protected double deposito = 0;
    protected String tipo;
    protected double diariaTaxaAluguel = 0;
    protected boolean disponibilidade = true;

    /*Esse bloco é executado quando a classe é carregada e é setada a loja de Bicicletas
    *Ela arbitralmente tem os atributos: deposito, diariaTaxaAluguel e numeroBicicleta*/

//    static{
//        int j = 0;
//        for(int i = 10; i < 15; i++){
//            Bicicleta b = new Bicicleta("Bicicleta anos 2000",i, i, (j*100));
//            bicicletaLista[j] = b;
//            j++;
//        }
//    }

    public Bicicleta(String nome, double deposito, double diariaTaxaAluguel, String marca, String modelo, String tipo) {
        this.numeroBicicleta = new Random().nextInt(1,10000);
        this.nome = nome;
        this.deposito = deposito;
        this.diariaTaxaAluguel = diariaTaxaAluguel;
        this.marca = marca;
        this.modelo = modelo;
        this.tipo =  tipo;
    }

    public int getNumeroBicicleta() {
        return numeroBicicleta;
    }

    public String getNome() {
        return nome;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public double getDeposito() {
        return deposito;
    }

    public String getTipo() {
        return tipo;
    }

    public double getdiariaTaxaAluguel() {
        return diariaTaxaAluguel;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void exibirDetalhes() {
        System.out.println("Identificador da Bicicleta: " + numeroBicicleta);
        System.out.println("Nome: " + nome);
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Tipo de bicicleta: " + tipo);
        System.out.println("Depósito: R$ " + deposito);
        System.out.println("diariaTaxaAluguel: R$ " + diariaTaxaAluguel);
        System.out.println("Disponibilidade: " + disponibilidade);
    }

    public void calcularCusto(int numeroDeDias) {
        double custo = deposito + (diariaTaxaAluguel * numeroDeDias);
        System.out.println("O total custo para o alguel deve ser: R$ " + custo + "\n");
    }

    @Override
    public String toString() {
        return "\n"+numeroBicicleta+","+nome+","+marca+","+modelo+","+deposito+","+tipo+","+diariaTaxaAluguel+","+disponibilidade;
    }

//    public static Bicicleta encontrarBicicletaPeloNumero(int numeroDaBicicleta){
//        int numeroBicicleta = bicicletaLista.length;
//
//        //procura a Bicicleta mapeando pela a lista completa de bicicletas cadastradas
//        for(int i = 0; i < numeroBicicleta; i++){
//            //se encontrar a Bicicleta pelo número escolhido...
//            if(bicicletaLista[i].getNumeroBicicleta() == numeroDaBicicleta){
//                //avisa ao usuário que foi encontrada
//                System.out.println("Bicicleta com o número '" + numeroDaBicicleta + "' encontrada" + "\n");
//                //e retorna a bicicleta para a UI
//                return bicicletaLista[i];
//            }
//        }
//        //se não encontrar a Bicicleta, avisa ao usuário que não foi encontrada...
//        System.out.println("Bicicleta com o número '" + numeroDaBicicleta + "' não encontrada" + "\n");
//        return null;
//    }
}

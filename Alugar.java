package Wheels;

import java.util.Date;

public class Alugar {
    private Date dataInicial = null;
    private Cliente cliente = null;
    private Bicicleta bicicleta = null;
    private int numeroDeDias = 0;
    private int alugarID = 0;

    private static int contagemDeAlugueis = 001;

    public Alugar(Date sData, int numDias, Bicicleta bicicletaParaAlugar, Cliente client){
        dataInicial = sData;
        numeroDeDias = numDias;
        cliente = client;
        bicicleta = bicicletaParaAlugar;
        alugarID = contagemDeAlugueis++;
    }

    public Cliente getCliente(){
        return cliente;
    }

    public Bicicleta getBicicleta(){
        return bicicleta;
    }

    public int getNumeroDeDias(){
        return numeroDeDias;
    }

    public Date getDataInicial(){
        return dataInicial;
    }
}


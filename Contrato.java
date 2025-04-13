package Wheels;

import java.util.Date;

public class Contrato {
    private Date dataInicial = null;
    private Cliente cliente = null;
    private Bicicleta bicicleta = null;
    private int numeroDias = 0;
    private int alugarID = 0;

    private static int contagemDeAlugueis = 001;

    public Contrato(Date data, Cliente cliente, Bicicleta bicicleta, int numDias){
        dataInicial = data;
        numeroDias = numDias;
        this.cliente = cliente;
        this.bicicleta = bicicleta;
        alugarID = contagemDeAlugueis++;
    }

    public Cliente getCliente(){
        return cliente;
    }

    public Bicicleta getBicicleta(){
        return bicicleta;
    }

    public int getNumeroDeDias(){
        return numeroDias;
    }

    public Date getDataInicial(){
        return dataInicial;
    }
}


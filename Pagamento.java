package Wheels;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class Pagamento {
    //criação do pagamento
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    //criação do pagamento
    private Contrato contrato;
    private int pagamentoID = 0;
    private double valorTotal = 0;
    private double valorPago = 0;
    private LocalDate dataPagamento = LocalDate.now();
    private double pagamentoEmFalta = 0;

    public Pagamento(Contrato contrato){
        //setar membros das variáveis
        this.pagamentoID = new Random().nextInt(1,10000);
        this.contrato = contrato;
        this.valorTotal = contrato.getNumeroDias() * contrato.getBicicleta().diariaTaxaAluguel + contrato.getBicicleta().deposito;
        this.valorPago = pagarAluguel();
        this.pagamentoEmFalta = valorTotal - valorPago;
        this.dataPagamento = LocalDate.now();
    }

    private String nomeClienteCSV;
    private String dataPagamentoCSV;

    public Pagamento(int pagamentoID,String nomeCliente,String dataPagamento,double valorTotal,double valorPago,double pagamentoEmFalta){
        this.pagamentoID = pagamentoID;
        this.nomeClienteCSV = nomeCliente;
        this.dataPagamentoCSV = dataPagamento;
        this.valorTotal = valorTotal;
        this.valorPago = valorPago;
        this.pagamentoEmFalta = pagamentoEmFalta;
    }

    public int getPagamentoID() {
        return pagamentoID;
    }

    private double pagarAluguel() {
        System.out.print("Coloque o valor do pagamento: ");
//        Scanner leitor = new Scanner(System.in);
        return 100;
    }

    public void calcularPagamentoTotal(Contrato contrato){
        //chamar o método privado
        emitirRecibo(contrato);
    }

    private void emitirRecibo(Contrato contrato){
        //imprime todos os dados relevantes
        String client = contrato.getCliente().getNome();
        String endereco = contrato.getCliente().getEndereco();
        System.out.println("Imprimindo comprovante para: '" + client + "' ......");
        System.out.println("Endereço: " + endereco + "\n");

        System.out.println("Alugando Bicicleta de número '" + contrato.getBicicleta().getNumeroBicicleta() + "' para " + contrato.getNumeroDias() + " dias" + "\n");
        contrato.getBicicleta().calcularCusto(contrato.getNumeroDias());
    }

    public void exibirDetalhes() {
        System.out.println("Identificador do Pagamento: " + pagamentoID);
        System.out.println("Nome do Cliente: " + nomeClienteCSV);
        System.out.println("Data do Pagamento: " + dataPagamentoCSV);
        System.out.println("Valor Total: R$ " + valorTotal);
        System.out.println("Valor pago pelo cliente: R$ " + valorPago);
        System.out.println("Pagamento em falta: R$ " + pagamentoEmFalta);
    }

    @Override
    public String toString() {
        return "\n"+pagamentoID+","+contrato.getCliente().getNome()+","+dataPagamento.format(formatter) +","+valorTotal+","+valorPago+","+pagamentoEmFalta;
    }
}

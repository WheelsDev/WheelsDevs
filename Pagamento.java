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
        this.valorTotal = contrato.getNumeroDeDias() * contrato.getBicicleta().diariaTaxaAluguel + contrato.getBicicleta().deposito;
        this.valorPago = pagarAluguel();
        this.pagamentoEmFalta = valorTotal - valorPago;
        this.dataPagamento = LocalDate.now();
    }

    private double pagarAluguel() {
        System.out.print("Coloque o valor do pagamento: ");
        Scanner leitor = new Scanner(System.in);
        return leitor.nextDouble();
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

        System.out.println("Alugando Bicicleta de número '" + contrato.getBicicleta().getNumeroBicicleta() + "' para " + contrato.getNumeroDeDias() + " dias" + "\n");
        contrato.getBicicleta().calcularCusto(contrato.getNumeroDeDias());
    }

    @Override
    public String toString() {
        return "\n"+pagamentoID+","+contrato.getCliente().getNome()+","+dataPagamento.format(formatter) +","+valorTotal+","+valorPago+","+pagamentoEmFalta;
    }
}

package Wheels;

public class Pagamento {
    //criação do pagamento
    private Cliente cliente = null;
    private int pagamentoID = 0;
    private String moeda;

    private static int contadorPagamentos = 001;

    public Pagamento(Cliente cliente){
        //setar membros das variáveis

        this.cliente = cliente;
        pagamentoID = contadorPagamentos++;
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
}

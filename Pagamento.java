package Wheels;

public class Pagamento {
    //criação do pagamento
    private Cliente cliente = null;
    private int pagamentoID = 0;

    private static int contagemDePagamentos = 001;

    public Pagamento(Cliente client){
        //setar membros das variáveis

        cliente = client;
        pagamentoID = contagemDePagamentos++;
    }

    public void calcularPagamentoTotal(Alugar alugar){
        //chamar o método privado
        emitirComprovante(alugar);
    }

    private void emitirComprovante(Alugar alugar){
        //imprime todos os dados relevantes
        String client = alugar.getCliente().getNome();
        String endereco = alugar.getCliente().getEndereco();
        System.out.println("Imprimindo comprovante para: '" + client + "' ......");
        System.out.println("Endereço: " + endereco + "\n");

        System.out.println("Alugando Bicicleta de número '" + alugar.getBicicleta().getNumeroBicicleta() + "' para " + alugar.getNumeroDeDias() + " dias" + "\n");
        alugar.getBicicleta().calcularCusto(alugar.getNumeroDeDias());
    }
}

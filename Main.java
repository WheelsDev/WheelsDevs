package Wheels;

public class Main {
    public static void main(String[] args) {
        /* esse pequeno programa irá rodar de acordo com os métodos em "EmitirBicicletaUI"
        * chamando cada um em turno, igual um usuário com um Front end deveria fazer. */
        //primerio, cria-se a UI(User Interface//PT-BR: Interface do Usuário)
        EmitirBicicletaUI ui = new EmitirBicicletaUI();

        //1. Mostra os detalhes para a bicicleta escolhida
        ui.mostrarDetalhesBicicleta(100);

        //2. Calcula o custo para o aluguel dessa bicicleta por 5 dias
        ui.calcularCusto(5);

        //3.Cria um novo cliente, aluguel e pagamento
        ui.criarCliente("Les Hargreaves", "PW2 6TR", 1462501339);

        //4. Calcula o custo total final
        ui.calcularPagamentoTotal();
    }

}

package Wheels;

public class Cliente {
    //criação do cliente
    private String nome = null;
    private String endereco = null;
    private int telefone = 0;
    private int clienteID = 0;

    private static int contagemDeClientes = 001;

    public Cliente(String cnome, String pendereco, int tel){
        //setar membros das variáveis
        nome = cnome;
        endereco = pendereco;
        telefone = contagemDeClientes++;
    }

    public int getClienteID(){
        return clienteID;
    }

    public String getNome(){
        return nome;
    }

    public String getEndereco(){
        return endereco;
    }
}

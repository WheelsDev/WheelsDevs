package Wheels;

public class Cliente {
    //criação do cliente
    private String nome = null;
    private String endereco = null;
    private int telefone = 0;
    private int clienteID = 0;

    private static int contadorCliente = 001;

    public Cliente(String nome, String endereco, int telefone){
        //setar membros das variáveis
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        contadorCliente++;
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

    public int getTelefone(){
        return telefone;
    }

}

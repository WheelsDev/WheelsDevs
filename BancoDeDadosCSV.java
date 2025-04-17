package Wheels;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

public class BancoDeDadosCSV {

    public void salvarBicicleta(Bicicleta bicicleta) {
        try {
            Path caminhoDiretorio = Paths.get("BancoDeDados","Bicicletas.csv");
            OutputStream escreverArquivo = Files.newOutputStream(caminhoDiretorio, StandardOpenOption.CREATE,StandardOpenOption.APPEND);
            InputStream lerArquivo = Files.newInputStream(caminhoDiretorio);
            if (lerArquivo.read() == -1) {
                escreverArquivo.write("Numero Bicicleta,Nome,Marca,Modelo,Deposito,Tipo,Diaria Taxa Aluguel,Disponibilidade".getBytes());
            }
            escreverArquivo.write(bicicleta.toString().getBytes());
            System.out.println("Bicicleta salva no sistema!");
        } catch (Exception ex) {
            System.out.println("Erro ao encontrar o arquivo.");
        }

    }
    public void salvarCliente(Cliente cliente) {
        try {
            Path caminhoDiretorio = Paths.get("BancoDeDados","Clientes.csv");
            OutputStream escreverArquivo = Files.newOutputStream(caminhoDiretorio, StandardOpenOption.CREATE,StandardOpenOption.APPEND);
            InputStream lerArquivo = Files.newInputStream(caminhoDiretorio);
            if (lerArquivo.read() == -1) {
                escreverArquivo.write("ClienteID,Nome,Endereco,Telefone,Email".getBytes());
            }
            escreverArquivo.write(cliente.toString().getBytes());
            System.out.println("Cliente salvo no sistema!");
        } catch (Exception ex) {
            System.out.println("Erro ao encontrar o arquivo.");
        }

    }
    public void salvarContrato(Contrato contrato) {
        try {
            Path caminhoDiretorio = Paths.get("BancoDeDados","Contratos.csv");
            OutputStream escreverArquivo = Files.newOutputStream(caminhoDiretorio, StandardOpenOption.CREATE,StandardOpenOption.APPEND);
            InputStream lerArquivo = Files.newInputStream(caminhoDiretorio);
            if (lerArquivo.read() == -1) {
                escreverArquivo.write("Contrato ID,Cliente,Bicicleta,Data Inicial,Numero Dias,Data Retorno,Status Do Contrato".getBytes());
            }
            escreverArquivo.write(contrato.toString().getBytes());
            System.out.println("Contrato salvo no sistema!");
        } catch (Exception ex) {
            System.out.println("Erro ao encontrar o arquivo.");
        }

    }
    public void salvarPagamento(Pagamento pagamento) {
        try {
            Path caminhoDiretorio = Paths.get("BancoDeDados","Pagamentos.csv");
            OutputStream escreverArquivo = Files.newOutputStream(caminhoDiretorio, StandardOpenOption.CREATE,StandardOpenOption.APPEND);
            InputStream lerArquivo = Files.newInputStream(caminhoDiretorio);
            if (lerArquivo.read() == -1) {
                escreverArquivo.write("Pagamento ID,Nome Cliente,Data Pagamento,Valor Total,Valor Pago,Pagamento Em Falta".getBytes());
            }
            escreverArquivo.write(pagamento.toString().getBytes());
            System.out.println("Pagamento salvo no sistema!");
        } catch (Exception ex) {
            System.out.println("Erro ao encontrar o arquivo.");
        }

    }
}
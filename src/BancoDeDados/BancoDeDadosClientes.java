package BancoDeDados;

import Clientes.Cliente;
import Clientes.PessoaFisica;
import Clientes.PessoaJuridica;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BancoDeDadosClientes implements BancoDeDados<Cliente> {
    private static BancoDeDadosClientes instancia;
    private List<Cliente> listaDeClientes;

    private BancoDeDadosClientes() {
        listaDeClientes = new ArrayList<>();
    }

    public static synchronized BancoDeDadosClientes getInstancia() {
        if (instancia == null) {
            instancia = new BancoDeDadosClientes();
        }
        return instancia;
    }

    public List<Cliente> getListaDeClientes() {
        return listaDeClientes;
    }

    @Override
    public void salvar(Cliente cliente) {
        listaDeClientes.removeIf(c -> c.getIdCliente() == cliente.getIdCliente());
        listaDeClientes.add(cliente);
    }

    @Override
    public void listarTodos(){
        if (listaDeClientes.isEmpty()){
            System.out.println("Não há clientes cadastrados.");
        }

        for (Cliente clientesCadastrados: listaDeClientes){
            System.out.println(clientesCadastrados);
        }
    }

    @Override
    public Cliente buscarPorId(int idCliente) {
        for (Cliente cliente : listaDeClientes) {
            if (cliente.getIdCliente() == idCliente) {
                return cliente;
            }
        }
        return null;
    }

    public List<Cliente> cadastrarClientes(Cliente cliente) {
        listaDeClientes.add(cliente);
        return listaDeClientes;
    }

    public Cliente buscarRegistroCliente() {
        Cliente clienteEncontrado = null;
        for (Cliente clienteDisponivel : listaDeClientes) {

            if (Objects.equals(clienteDisponivel.getTipoDeCliente(), "Pessoa Física")) {
                clienteEncontrado = new PessoaFisica(
                        clienteDisponivel.getIdCliente(),
                        clienteDisponivel.getNome(),
                        clienteDisponivel.getNumeroDoDocumento(),
                        clienteDisponivel.getEndereco(),
                        clienteDisponivel.getTelefone(),
                        clienteDisponivel.getEmail(),
                        clienteDisponivel.getTipoDeCliente()
                );
            } else {
                clienteEncontrado = new PessoaJuridica(
                        clienteDisponivel.getIdCliente(),
                        clienteDisponivel.getNome(),
                        clienteDisponivel.getNumeroDoDocumento(),
                        clienteDisponivel.getEndereco(),
                        clienteDisponivel.getTelefone(),
                        clienteDisponivel.getEmail(),
                        clienteDisponivel.getTipoDeCliente());
            }

        }
        return clienteEncontrado;
    }
}

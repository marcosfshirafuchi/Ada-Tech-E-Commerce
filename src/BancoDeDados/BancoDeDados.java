package BancoDeDados;

public interface BancoDeDados<T>{
    void salvar(T objeto);
    void listarTodos();
    T buscarPorId(int id);
}

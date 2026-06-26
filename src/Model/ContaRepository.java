package Model;

//Contrato
public interface ContaRepository {

    //CRUD
    public void listarTodas();
    public void cadastrar(Conta conta);
    public void procurarPorNumero(int numero);
    public void atualizarDadosDaConta(Conta conta);
    public void deletar(int numero);

    //Métodos Bancários
    public void sacar(int numero, float valor);
    public void depositar(int numero, float valor);
    public void transferir(int numeroOrigin, int numeroDestino, float valor);


}

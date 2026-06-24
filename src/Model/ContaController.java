package Model;

import java.util.ArrayList;

public class ContaController implements ContaRepository {

    ArrayList<Conta> listaContas = new ArrayList<> ();
    int numero = 0;

    //
    @Override
    public void listarTodas () {
        for (Conta contaAtual : listaContas){
            contaAtual.Imprimir ();
        }
    }

    @Override
    public void cadastrar (Conta conta) {
        listaContas.add (conta);
    }

    @Override
    public void procurarPorNumero (int numero) {

    }

    @Override
    public void atualizar (Conta conta) {

    }

    @Override
    public void deletar (int numero) {

    }

    @Override
    public void sacar (int numero, float valor) {
        Conta contaEncontrada = buscarNaCollection (numero);


    }

    @Override
    public void depositar (int numero, float valor) {

    }

    @Override
    public void transferir (int numeroOrigin, int numeroDestino, float valor) {

    }
    
    //Método Auxiliar
    public int gerarNumero(){
        return  ++ numero;
    }

    //Verifica se a conta existe
    public Conta buscarNaCollection(int numero){
        for (Conta contaAtual : listaContas){
            if (contaAtual.getNumeros () == numero){
                return contaAtual;
            }
        }
        return null;
    }

    public void renderJurosDaPoupanca(int numero, float taxa) {
        Conta contaEncontrada = buscarNaCollection(numero);

        if (contaEncontrada != null) {
            // Verifica se a conta é do tipo ContaPoupanca
            if (contaEncontrada instanceof ContaPoupanca) {

                ((ContaPoupanca) contaEncontrada).renderJuros(taxa);
            } else {
                System.out.println("Erro: A conta de número " + numero + " não é uma Conta Poupança!");
            }
        } else {
            System.out.println("A conta número " + numero + " não foi encontrada!");
        }
    }

}

package Controller;
import Model.Conta;
import Model.ContaPoupanca;
import Model.ContaRepository;
import java.util.ArrayList;
import java.util.Optional;

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
        Conta contaEncontrada = buscarNaCollection (numero);
        if (contaEncontrada != null){
            contaEncontrada.Imprimir ();
        }else {
            System.out.println ("conta não encontrada!");
        }
    }

    @Override
    public void atualizarDadosDaConta (Conta conta) {
        int contaAtt = conta.getNumero ();
        Conta contaAntiga = buscarNaCollection (contaAtt);

        if (contaAntiga != null){
            int posicao = listaContas.indexOf (contaAntiga);
            listaContas.set (posicao,conta);
            System.out.println ("conta atualizada com sucesso!");
        }else {
            System.out.println ("conta não encontrada: ");
        }

    }

    @Override
    public void deletar (int numero) {
        Conta contaEncontrada = buscarNaCollection (numero);

        if (contaEncontrada != null){
            listaContas.remove (contaEncontrada);
            System.out.println ("conta removida com sucesso!");
        }else {
            System.out.println ("A conta solicitada não existe");
        }
    }

    @Override
    public void sacar (int numero, float valor) {
        Conta contaEncontrada = buscarNaCollection (numero);
        if (contaEncontrada != null){
            if (contaEncontrada.getSaldo () >= valor){
                float valorEmConta = contaEncontrada.getSaldo ();
                float novoValor = valorEmConta - valor;
                contaEncontrada.setSaldo (novoValor);
                System.out.println ("saque realizado com sucesso!");
            }else{
                System.out.println ("saldo insuficiente: ");
            }
        }else{
            System.out.println ("conta não encontrada!");
        }
    }

    @Override
    public void depositar (int numero, float valor) {
        Conta contaEncontrada = buscarNaCollection (numero);
        if(contaEncontrada != null){
            float valorEmConta = contaEncontrada.getSaldo ();
            float novoValor = valorEmConta + valor;
            contaEncontrada.setSaldo (novoValor);
            System.out.println ("Deposito feito com sucesso!");
        }else {
            System.out.println ("Conta não encontrada: ");
        }
    }

    @Override
    public void transferir (int numeroOrigin, int numeroDestino, float valor) {
        Conta contaOrigin = buscarNaCollection (numeroOrigin);
        Conta contaDestino = buscarNaCollection (numeroDestino);

        if (contaOrigin != null && contaDestino != null){
            if (contaOrigin.getSaldo () >= valor){
                float valorEmConta = contaOrigin.getSaldo ();
                float novoValor = valorEmConta - valor;
                contaOrigin.setSaldo (novoValor);

                float valorEmContaDestino = contaDestino.getSaldo ();
                float novoValorEmContaDestino = valorEmContaDestino + valor;
                contaDestino.setSaldo (novoValorEmContaDestino);
                System.out.println ("Transferência realizada com sucesso!  ");

            }else{
                System.out.println ("Saldo insuficiente: ");
            }
        }else{
            System.out.println ("Conta de origem ou destino não foram encontrada");
        }
    }
    
    //Método Auxiliar
    public int gerarNumero(){
        return  ++ numero;
    }


    //Verifica se a conta existe com Optional - feito em aula
    public Optional<Conta> buscarNaCollectionOptional(int numero){
        for(Conta conta : listaContas){
            if (conta.getNumero () == numero)
                return Optional.of (conta);
        }
        return Optional.empty ();
    }



    //Verifica se a conta existe
    public Conta buscarNaCollection(int numero){
        for (Conta contaAtual : listaContas){
            if (contaAtual.getNumero () == numero){
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

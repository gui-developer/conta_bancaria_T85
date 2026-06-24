package Model;

public class ContaPoupanca extends Conta {

    private int aniversario;

    //sobrescrita do construtor
    public ContaPoupanca (int numeros, int agencia, String tipo, String titular, float saldo, int aniversario) {
        super (numeros, agencia, tipo, titular, saldo);
        this.aniversario = aniversario;
    }

    //Getters e Setters
    public int getAniversario () {
        return aniversario;
    }

    public void setAniversario (int aniversario) {
        this.aniversario = aniversario;
    }

    public void renderJuros(Float taxa){
        float saldoAtual = this.getSaldo ();
        float rendimento = saldoAtual*taxa;
        this.setSaldo (saldoAtual + rendimento);

        System.out.println("Juros de " + (taxa * 100) + "% aplicados com sucesso!");
        System.out.println("Novo saldo: R$ " + this.getSaldo());
    }

}

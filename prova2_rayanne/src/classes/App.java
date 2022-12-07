package classes;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        boolean c = true;
         
        // usuario "João Fernandes", "102030";

        Cliente cliente = new Cliente();
        cliente.setNome("João Fernandes");
        cliente.setCpf("123.456.789-98");
        cliente.setSenha("102030");
        Conta conta = new Conta();
        conta.setNumero(0000);
        conta.setSaldo(800.0f);
        float saldo = conta.getSaldo();
        Transacao transacao = new Transacao();
        transacao.realizarTransacao("18-07-2014", conta,"Pagamento de conta telefona", 30.0f, Conta.depositar);
        transacao.realizarTransacao("18-07-2014", conta,"Pagamento de conta luz", 250.0f, Conta.sacar);
        System.out.println("Deseja imprimir o relatorio? ");
        char resp = s.next().charAt(0);
        s.nextLine();
        if (resp == 's'){
        while (c){
            System.out.println("Qual é o seu usuario e senha?");
            String usuario = s.nextLine();
            String senha = s.nextLine();
            if (usuario.equals(cliente.getNome()) && senha.equals(cliente.getSenha())){
                c = false;
            }
            else {
                System.out.println("Usuario e senha incorretos, tente novamente!");

            }
        }
            System.out.println("Emitindo extrato da conta comum número: " + conta.getNumero());
            System.out.println("Correntista: " + cliente.getNome());
            System.out.println("Saldo Anterior: " + saldo);
            System.out.println("------------------------------");
            transacao.getMovimentos();
            System.out.println("Saldo Atual: " + conta.getSaldo());
        }
    }
}

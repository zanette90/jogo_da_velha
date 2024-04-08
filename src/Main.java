import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static String[][] tabuleiro = new String[3][3];
    static int empate = 0;
    static int rodada = 0;
    static int contaVitoriaX = 0;
    static int contaVitoriaO = 0;
    static String jogador = "X";

    public static void main(String[] args) {
        while (true) {
            Scanner leitor = new Scanner(System.in);

            mostraPlacar();
            zeraTabuleiro();
            mostraTabuleiro();
            rodada = 0;

            System.out.println("BEM VINDOS AO JOGO DA VELHA");

            while (!ganhou() && !verificaEmpate()) {

                System.out.println("Digite uma linha?");
                int linha = leitor.nextInt();

                System.out.println("Digite uma coluna?");
                int coluna = leitor.nextInt();

                if(linha > 3 || coluna > 3 || linha < 0 || coluna < 0 ) {
                    System.out.println("Linha ou coluna inválida");

                } else if (tabuleiro[linha][coluna].equals(" ")) {

                    tabuleiro[linha][coluna] = jogador;
                    if(!ganhou()) {
                        jogador = (jogador.equals("X") ? "O" : "X");
                    }
                    rodada++;
                } else {
                    System.out.println("Essa posição já foi jogada");
                }
                mostraTabuleiro();
            }
            validaGanhador();
        }
    }

    public static void mostraPlacar() {
        System.out.println("Player 1: " + contaVitoriaX + " Player 2: " + contaVitoriaO + " Empates: " + empate);
    }

    public static void mostraTabuleiro() {
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                System.out.print(tabuleiro[k][l]);
                if (l < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
        }
    }
    public static void zeraTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = " ";
            }
        }
    }

    public static boolean verificaEmpate() {
        if (!ganhou() && rodada >= 9) {
            System.out.println("Empate");
            empate++;
            return true;
        }
        return false;
    }
    public static int validaGanhador(){
        if(ganhou()){
            if (jogador.equals("X")){
                return contaVitoriaX++;
            }
        }
        return contaVitoriaO++;
    }

    public static boolean ganhou() {

        //verifica diagonais
        if (tabuleiro[0][0].equals(jogador) && tabuleiro[1][1].equals(jogador) && tabuleiro[2][2].equals(jogador)){
            return true;
        } else if (tabuleiro[2][0].equals(jogador) && tabuleiro[1][1].equals(jogador) && tabuleiro[0][2].equals(jogador)) {
            return true;
        }

        //verifica linhas e colunas
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0].equals(jogador) && tabuleiro[i][1].equals(jogador) && tabuleiro[i][2].equals(jogador)){
                return true;
            } else if (tabuleiro[0][i].equals(jogador) && tabuleiro[1][i].equals(jogador) && tabuleiro[2][i].equals(jogador)){
                return true;
            }
        }
        return false;
    }
}


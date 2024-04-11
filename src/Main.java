import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static String[][] tabuleiro = new String[4][4];
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
            jogador = "X";

            System.out.println("BEM VINDOS AO JOGO DA VELHA");

            while (!ganhou() && !empatou()) {

                System.out.println("Digite uma linha?");
                int linha = leitor.nextInt();

                System.out.println("Digite uma coluna?");
                int coluna = leitor.nextInt();

                if(linha > 3 || coluna > 3 || linha < 1 || coluna < 1 ) {
                    System.out.println("Linha ou coluna inválida");

                }else if (tabuleiro[linha][coluna].equals(" ")) {
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
        for (int k = 1; k < 4; k++) {
            for (int l = 1; l < 4; l++) {
                System.out.print(tabuleiro[k][l]);
                if (l < 3) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
        }
    }
    public static void zeraTabuleiro() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                tabuleiro[i][j] = " ";
            }
        }
    }
    public static void validaGanhador(){
        if(ganhou()){
            if(jogador.equals("X")){
                contaVitoriaX++;
                System.out.println("Jogador X ganhou");
            } else{
                contaVitoriaO++;
                System.out.println("Jogador O ganhou");
            }
        }else {
            empate++;
            System.out.println("Empatou");
        }
    }
    public static boolean empatou(){
        if(rodada < 9){
            return false;
        }
        return true;
    }

    public static boolean ganhou() {
        // verifica as diagonais
        if((tabuleiro[1][1].equals(jogador) && tabuleiro[2][2].equals(jogador) && tabuleiro[3][3].equals(jogador)) ||
                (tabuleiro[3][1].equals(jogador) && tabuleiro[2][2].equals(jogador) && tabuleiro[1][3].equals(jogador))){
            return true;
        }
        //verifica linhas e colunas
        for (int i = 0; i < 3; i++){
            if (tabuleiro[i][1].equals(jogador) && tabuleiro[i][2].equals(jogador) && tabuleiro[i][3].equals(jogador) ||
                    tabuleiro[1][i].equals(jogador) && tabuleiro[2][i].equals(jogador) && tabuleiro[3][i].equals(jogador)){
                return true;
            }
        }
        return false;
    }
}


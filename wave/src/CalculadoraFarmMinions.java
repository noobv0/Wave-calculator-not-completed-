import java.util.Scanner;

public class CalculadoraFarmMinions {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a quantidade de waves: ");
        int quantidadeWaves = scanner.nextInt();

        int[] resultado = calcularFarmDeMinions(quantidadeWaves);
        int tempoFarm = resultado[0];
        int minionsFarm = resultado[1];
        int ouroTotal = resultado[2];

        System.out.println("Tempo total: " + tempoFarm + " segundos");
        System.out.println("Minions totais: " + minionsFarm);
        System.out.println("Ouro total: " + ouroTotal);
    }

    public static int[] calcularFarmDeMinions(int waves) {
        int tempoInicial = 90; // Tempo inicial
        int tempoPorWave = 30;  // Tempo estimado (em segundos) para farmar uma wave
        int minionsPorWave = 6;  // Quantidade média de minions em uma wave
        int minionsPorWaveAumentado = 7; // Catapulta extra a cada 3 waves
        int ouroMinionGuerreiro = 21; // Ouro de um minion guerreiro
        int ouroMinionMago = 14; // Ouro de um minion mago
        int ouroCatapulta = 60; // Ouro de uma catapulta
        int ouroCatapultaExtra = 84; // Ouro de uma catapulta extra após 15 minutos

        int tempoTotal = tempoInicial;
        int minionsTotal = 0;
        int ouroTotal = 0;

        for (int i = 1; i <= waves; i++) {
            tempoTotal += tempoPorWave;

            if (i % 3 == 0) {
                minionsTotal += minionsPorWaveAumentado;
                ouroTotal += 3 * ouroMinionGuerreiro; // Ouro dos guerreiros
                ouroTotal += 3 * ouroMinionMago; // Ouro dos magos

                if (tempoTotal >= 900) {
                    ouroTotal += ouroCatapultaExtra; // Adiciona ouro da catapulta extra após 15 minutos
                } else {
                    ouroTotal += ouroCatapulta; // Adiciona ouro de uma catapulta
                }
            } else {
                minionsTotal += minionsPorWave;
                ouroTotal += 3 * ouroMinionGuerreiro; // Ouro dos guerreiros
                ouroTotal += 3 * ouroMinionMago; // Ouro dos magos
            }
        }

        return new int[]{tempoTotal, minionsTotal, ouroTotal};
    }
}

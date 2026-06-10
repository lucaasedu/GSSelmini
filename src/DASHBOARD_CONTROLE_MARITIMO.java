import java.util.Scanner;

public class DASHBOARD_CONTROLE_MARITIMO  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double altmare, velvento, temoceano, faixaareia;
        int riscoEnchente = 5, contriscos = 0;
        String faseLunar, estacao;

        while (riscoEnchente >= 5) {

            riscoEnchente = 0;

            System.out.println("Digite a altura da maré (em M) neste exato momento: ");
            altmare = sc.nextDouble();

            System.out.println("Digite a velocidade (em Km/h) do vento: ");
            velvento = sc.nextDouble();

            System.out.println("Digite a temperatura (em °C) do oceano: ");
            temoceano = sc.nextDouble();

            sc.nextLine();

            System.out.println("Digite a fase lunar (NOVA, CHEIA, MINGUANTE, CRESCENTE): ");
            faseLunar = sc.nextLine();

            System.out.println("Digite a estação (VERÃO, INVERNO, PRIMAVERA, OUTONO): ");
            estacao = sc.nextLine();

            System.out.println("Digite o tamanho (em M)  da faixa de areia: ");
            faixaareia = sc.nextDouble();

            if (altmare <= 1.4) {
                riscoEnchente = 0;
            } else if (altmare <= 1.6) {
                riscoEnchente = 1;
            } else {
                riscoEnchente = 2;
            }

            if (velvento > 52 && velvento <= 69) {
                riscoEnchente += 1;
            } else if (velvento > 69) {
                riscoEnchente += 2;
            }

            if (faseLunar.equalsIgnoreCase("NOVA") || faseLunar.equalsIgnoreCase("CHEIA")) {
                riscoEnchente += 1;
            }

            if (temoceano > 26.0) {
                riscoEnchente += 2;
            } else if (temoceano > 24.0) {
                riscoEnchente += 1;
            }

            if (faixaareia < 20.0) {
                riscoEnchente += 1;
            }

            if (estacao.equalsIgnoreCase("INVERNO") || estacao.equalsIgnoreCase("OUTONO")) {
                riscoEnchente += 1;
            }

            if (riscoEnchente >= 5) {
                contriscos++;
            } else {
                contriscos = 0;
            }

            System.out.println("RESULTADO DO MONITORAMENTO");
            System.out.println("------------------------------------------------------");
            System.out.println("altura da maré: " + altmare + "M");
            System.out.println("velocidade do vento: " + velvento +"Km/h");
            System.out.println("temperatura do oceano: " + temoceano + "°C");
            System.out.println("Fase lunar: " + faseLunar);
            System.out.println("Estação: " + estacao);
            System.out.println("Tamanho da faixa de areia: " + faixaareia + "M");

            System.out.println("------------------------------------------------------");
            System.out.println("Pontuação final de risco: " + riscoEnchente);

            if (riscoEnchente >= 5) {
                System.out.println("CRITICIDADE: risco alto de enchente.");
            } else if (riscoEnchente >= 2) {
                System.out.println("Cuidado: Condições propícias a alagamentos.");
            } else {
                System.out.println("Maré segura: Condições normais.");
            }

            if (riscoEnchente >= 5) {
                System.out.println("------------------------------------------------------");
                System.out.println("Após 1h verifique novamente");
                System.out.println("------------------------------------------------------");
            }

            if (contriscos >= 4) {
                System.out.println("------------------------------------------------------");
                System.out.println("AVISO: O sistema registrou " + contriscos + " análises CRÍTICAS consecutivas.");
                System.out.println("Alerta de emergência ativado devido à persistência temporal do risco!");
                System.out.println("------------------------------------------------------");
            }
        }
    }
}


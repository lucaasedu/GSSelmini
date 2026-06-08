import java.util.Scanner;

public class Sprint02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // O usuário começa na coluna 12, linha 1
        int y = 1;
        int x = 12;
        double custoTotal = 0;
        String comando;
        int distancia;

        // LAÇO PRINCIPAL PARA RECEBER COMANDOS ATÉ O USUÁRIO DIGITAR SAIR
        do {
            System.out.println("Digite um dos comandos abaixo: \n Frente - [Subir] \n Tras - [Desce] \n Esquerda - [Esquerda] \n Direita - [Direita] \n Sair [Encerrar]");
            comando = sc.nextLine();

            // SE O COMANDO FOR SAIR, EXIBE O CUSTO TOTAL E SAI DO LAÇO
            if (comando.equalsIgnoreCase("SAIR")) {
                // EXIBIÇÃO DA MENSAGEM FINAL
                System.out.println("Custo total: R$ " + custoTotal + " ! Classificação: Sem classificação concluída.");
            } else {

                // VALIDANDO SE A DIREÇÃO RECEBIDA É VÁLIDA
                if (comando.equalsIgnoreCase("FRENTE")
                        || comando.equalsIgnoreCase("TRAS")
                        || comando.equalsIgnoreCase("ESQUERDA")
                        || comando.equalsIgnoreCase("DIREITA")) {
                    System.out.println("Digite a distancia que deseja percorrer no labirinto! Exemplo: 5 ");
                    distancia = sc.nextInt();
                    sc.nextLine();

                    // VALIDANDO SE DISTÂNCIA É POSITIVA E MENOR OU IGUAL A 10
                    if (distancia > 0 && distancia <= 12) {
                        int caminhoValido = 1;
                        int passoX = 0;
                        int passoY = 0;
                        int atualX = x;
                        int atualY = y;

                        // CALCULA A DIREÇÃO DO MOVIMENTO
                        if (comando.equalsIgnoreCase("FRENTE")) {
                            passoY = -1;
                        } else if (comando.equalsIgnoreCase("TRAS")) {
                            passoY = 1;
                        } else if (comando.equalsIgnoreCase("DIREITA")) {
                            passoX = 1;
                        } else {
                            passoX = -1; // Esquerda
                        }

                        int passo = 1;

                        // VALIDA CADA PASSO DO MOVIMENTO
                        while (passo <= distancia) {

                            // AVANÇA UMA CASA NA DIREÇÃO ESCOLHIDA
                            atualX += passoX;
                            atualY += passoY;

                            int posicaoValida = 1;

                            // 1. ALTERADO: VERIFICA SE ESTÁ FORA DOS LIMITES (X de 1 a 12, Y apenas 1)
                            if (atualX < 1 || atualX > 12 || atualY < 1 || atualY > 1) {
                                posicaoValida = 0;
                            } else

                                // 2. ALTERADO: GARANTE QUE O CAMINHO VÁLIDO SEJA APENAS ESSA LINHA DE 1 A 12
                                if (!(atualY == 1 && atualX >= 1 && atualX <= 12)) {
                                    posicaoValida = 0;
                                }

                            if (posicaoValida == 0) {
                                caminhoValido = 0;
                                break;
                            }
                            passo++;
                        }

                        // SE O CAMINHO FOR VÁLIDO, ATUALIZA A POSIÇÃO FINAL
                        if (caminhoValido == 1) {
                            x = atualX;
                            y = atualY;

                            // CALCULA CUSTO PERCORRIDO
                            custoTotal += distancia * 0.5;

                            // VALIDANDO SE CHEGOU NO DESTINO (X = 1 e Y = 1)
                            if (x == 1 && y == 1) {

                                // EXIBIÇÃO DA MENSAGEM FINAL
                                System.out.println("Chegou no destino!");
                                break;
                            }
                        } else {
                            System.out.println("COMANDO INVÁLIDO");
                        }
                    } else {
                        System.out.println("COMANDO INVÁLIDO");
                    }
                } else {
                    System.out.println("COMANDO INVÁLIDO");
                }
            }
        } while (!comando.equalsIgnoreCase("SAIR"));
    }
}
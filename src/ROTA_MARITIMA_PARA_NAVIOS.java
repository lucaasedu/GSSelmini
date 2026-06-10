import java.util.Scanner;

public class ROTA_MARITIMA_PARA_NAVIOS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = 0, y = 0;
        int destinoX = 0, destinoY = 0;
        String comando;
        int distancia;
        int rota = 0;
        int dtsaida = 0, dtchegada = 0;

        while (rota < 1 || rota > 3) {
            System.out.println("Olá! Somos a Sidon e estamos aqui para assegurar uma rota mais eficiente, garantindo êxito no envio de cargas.");
            System.out.println("");
            System.out.println("Por favor, digite a rota desejada");
            System.out.println("1 para Rota 1 (P1 até C1)");
            System.out.println("2 para Rota 2 (P2 até C2)");
            System.out.println("3 para Rota 3 (P3 até C3)");
            System.out.print("Digite a opção (1-3): ");
            rota = sc.nextInt();
            sc.nextLine();

            if (rota < 1 || rota > 3) {
                System.out.println("Opção inválida! Escolha uma rota real.");
            }

            System.out.println("Quando o navio parte?: ");
            dtchegada = sc.nextInt();
            sc.nextLine();

        }

        if (rota == 1) {
            x = 12; y = 1;
            destinoX = 1; destinoY = 1;
            System.out.println("Destino C1");
        } else if (rota == 2) {
            x = 9; y = 2;
            destinoX = 4; destinoY = 9;
            System.out.println("Destino C2");
        } else if (rota == 3) {
            x = 3; y = 4;
            destinoX = 12; destinoY = 11;
            System.out.println("Destino C3");
        }

        do {
            System.out.println("Posição Atual das Coordenadas: X = " + x + ", Y = " + y);
            System.out.println("Digite um dos comandos: Frente, trás, esquerda, direita e, para encerrar, sair.");
            comando = sc.nextLine();

            if (comando.equalsIgnoreCase("SAIR")) {
                System.out.println("Rota interrompida");
            } else {

                if (comando.equalsIgnoreCase("FRENTE")
                        || comando.equalsIgnoreCase("TRAS")
                        || comando.equalsIgnoreCase("ESQUERDA")
                        || comando.equalsIgnoreCase("DIREITA")) {

                    System.out.println("Informe a distância em números que deseja avançar: ");
                    distancia = sc.nextInt();
                    sc.nextLine();

                    if (distancia > 0) {
                        int caminho = 1;
                        int passoX = 0, passoY = 0;
                        int atualX = x, atualY = y;

                        if (comando.equalsIgnoreCase("FRENTE")) {
                            passoY = -1;
                        } else if (comando.equalsIgnoreCase("TRAS")) {
                            passoY = 1;
                        } else if (comando.equalsIgnoreCase("DIREITA")) {
                            passoX = 1;
                        } else {
                            passoX = -1;
                        }

                        int passo = 1;

                        while (passo <= distancia) {
                            atualX += passoX;
                            atualY += passoY;

                            int validacao = 0;

                            if (rota == 1) {
                                if (atualY == 1 && atualX >= 1 && atualX <= 12) {
                                    validacao = 1;
                                }
                            } else if (rota == 2) {
                                if ((atualY == 2 && atualX >= 7 && atualX <= 9) || (atualX == 7 && atualY >= 2 && atualY <= 7) || (atualY == 7 && atualX >= 5 && atualX <= 7) || (atualX == 5 && atualY >= 7 && atualY <= 9) || (atualY == 9 && atualX >= 4 && atualX <= 5)) {
                                    validacao = 1;
                                }
                            } else if (rota == 3) {
                                if ((atualX == 3 && atualY >= 4 && atualY <= 5) || (atualY == 5 && atualX >= 3 && atualX <= 4) || (atualX == 4 && atualY >= 5 && atualY <= 8) || (atualY == 8 && atualX >= 4 && atualX <= 6) || (atualX == 6 && atualY >= 8 && atualY <= 11) || (atualY == 11 && atualX >= 6 && atualX <= 7) || (atualX == 7 && atualY >= 11 && atualY <= 13) || (atualY == 13 && atualX >= 7 && atualX <= 12) || (atualX == 12 && atualY >= 11 && atualY <= 13)) {
                                    validacao = 1;
                                }
                            }

                            if (validacao == 0) {
                                caminho = 0;
                            }
                            passo++;
                        }

                        if (caminho == 1) {
                            x = atualX;
                            y = atualY;
                            int kilometragem = distancia * 900;
                            dtsaida = (dtchegada * 2)+ distancia;

                            if (x == destinoX && y == destinoY) {
                                System.out.println("PARABÉNS! Você finalizou a rota e chegou até o porto!");
                                System.out.println("Foram " + distancia + " dias para chegar ao seu destino" + "(" + rota + ")");
                                System.out.println("Esta rota tem cerca de " + kilometragem + " km.");
                                System.out.println("Segundo a probabilidade, a previsão de chegada está para o dia " + dtsaida + ".");
                            }
                        } else {
                            System.out.println("Este trajeto está fora da rota definida. ");
                        }
                    }
                } else {
                    System.out.println("Este trajeto está fora da rota definida.");
                }
            }
        } while (!comando.equalsIgnoreCase("SAIR"));
    }
}
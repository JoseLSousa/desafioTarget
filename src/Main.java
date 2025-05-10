import java.util.*;

public class Main {

    public static class Registro {
        public int dia;
        public double valor;

        public Registro(int dia, double valor) {
            this.dia = dia;
            this.valor = valor;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Selecione a pergunta: " + "1, 2, 3, 4 ou 5: " + "\n");
            int option = sc.nextInt();

            if (option == 1) {
                int index = 13;
                int soma = 0;
                int k = 0;
                do {
                    k += k + 1;
                    soma = soma + k;
                }
                while (k < index);
                System.out.println(soma);
            } else if (option == 2) {
                System.out.println("Digite um número: ");
                int n = sc.nextInt();
                int a = 0;
                int b = 1;
                for (int i = 0; i < n; i++) {
                    int c = a + b;
                    a = b;
                    b = c;
                    if (n == c) {
                        System.out.println("O número " + n + " pertence a sequência de Fibonacci");
                        break;
                    } else if (c > n) {
                        System.out.println("O número " + n + " não pertence a sequência de Fibonacci");
                        break;
                    }
                }
            } else if (option == 3) {
                ArrayList<Registro> fatDiario = new ArrayList<>();
                for (int i = 0; i < 30; i++)
                    fatDiario.add(new Registro(i, (Math.random() * 1000)));

                Registro menorFaturamento = fatDiario.getFirst();
                Registro maiorFaturamento = fatDiario.getFirst();
                List<Integer> diasAcimaMedia = new ArrayList<>();
                double media = fatDiario.stream().reduce(0.0, (a, b) -> a + b.valor, Double::sum) / fatDiario.size();

                for (Registro r : fatDiario) {
                    if (r.valor < menorFaturamento.valor) {
                        menorFaturamento = r;
                    }
                    if (r.valor > maiorFaturamento.valor) {
                        maiorFaturamento = r;
                    }
                    if (r.valor > media) {
                        diasAcimaMedia.add(r.dia);
                    }
                }
                System.out.println("Menor faturamento: " + menorFaturamento.valor + " no dia " + menorFaturamento.dia);
                System.out.println("Maior faturamento: " + maiorFaturamento.valor + " no dia " + maiorFaturamento.dia);
                System.out.println("Dias com faturamento acima da média: " + diasAcimaMedia);
            } else if (option == 4) {
                Map<String, Double> faturamento = new HashMap<>();
                faturamento.put("SP", 67836.43);
                faturamento.put("RJ", 36678.66);
                faturamento.put("MG", 29229.88);
                faturamento.put("ES", 27165.48);
                faturamento.put("Outros", 19849.53);

                double total = faturamento.values().stream().mapToDouble(Double::doubleValue).sum();

                System.out.printf("Faturamento total: R$ %.2f\n\n", total);

                for (Map.Entry<String, Double> entrada : faturamento.entrySet()) {
                    String estado = entrada.getKey();
                    double valor = entrada.getValue();
                    double percentual = (valor / total) * 100;

                    System.out.printf("%s: R$ %.2f (%.2f%%)\n", estado, valor, percentual);
                }
            }
            else if (option == 5) {
                System.out.println("Digite uma string: ");
                sc.nextLine();
                String input = sc.nextLine();
                StringBuilder output = new StringBuilder();

                for (int i = input.length() - 1; i >= 0; i--) {
                    output.append(input.charAt(i));
                }

                System.out.println("String invertida: " + output);
            }
        }
    }
}
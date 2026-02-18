package application;

import entities.Parcela;
import enums.TipoJuros;
import services.GerarParcelas;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        GerarParcelas gerador = new GerarParcelas();

        System.out.println("--- CALCULADORA DE PARCELAMENTO ---");

        System.out.print("Valor do Capital (Ex: 1000.00): ");
        BigDecimal capital = sc.nextBigDecimal();

        System.out.print("Taxa de Juros Mensal (%): ");
        String taxa = sc.next();

        System.out.print("Quantidade de Meses: ");
        int meses = sc.nextInt();

        System.out.print("Tipo de Juros (1 - SIMPLES / 2 - COMPOSTO): ");
        int opcao = sc.nextInt();
        TipoJuros tipo = (opcao == 1) ? TipoJuros.SIMPLES : TipoJuros.COMPOSTO;

        LocalDate dataInicio = LocalDate.now();

        List<Parcela> resultado = gerador.gerarParcelas(capital, taxa, meses, tipo, dataInicio);

        System.out.println("\n--- PLANO DE PAGAMENTO ---");
        for (Parcela p : resultado) {
            System.out.println(p);
        }

        System.out.println("\nProcessamento concluído com sucesso!");

        sc.close();
    }
}
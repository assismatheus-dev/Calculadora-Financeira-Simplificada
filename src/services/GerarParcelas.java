package services;
import entities.Parcela;
import enums.TipoJuros;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class GerarParcelas {

    private static final CalculadoraJuros calc = new CalculadoraJuros();

    public List<Parcela> gerarParcelas(BigDecimal capital, String taxa, int meses, TipoJuros tipoJuros, LocalDate dataInicio) {
        List<Parcela> parcelas = new ArrayList<>();

        BigDecimal montanteTotal = calc.calcularJuros(tipoJuros, capital, taxa, meses);
        BigDecimal valorParcela = montanteTotal.divide(new BigDecimal(meses), 2, RoundingMode.HALF_EVEN);

        for(int i = 1; i <= meses; i++) {
            LocalDate vencimento = dataInicio.plusMonths(i);
            parcelas.add(new Parcela(i, valorParcela, vencimento));
        }

        return parcelas;
    }

}

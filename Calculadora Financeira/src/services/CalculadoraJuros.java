package services;
import enums.TipoJuros;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculadoraJuros {

    private static final BigDecimal CEM = new BigDecimal("100");

    public BigDecimal calcularJuros(TipoJuros tipoJuros, BigDecimal capital, String taxa, int meses) {
        //J = juro | C = capital inicial | i = taxa de juros (em decimal) | t = tempo

        BigDecimal i = new BigDecimal(taxa).divide(CEM, 4, RoundingMode.HALF_EVEN); //4 casas decimais, adotando o padrão do Banco Central para operações monetárias

        if(tipoJuros == TipoJuros.SIMPLES) {
            //M = C * (1 + t * i)
            BigDecimal juros = i.multiply(new BigDecimal(meses));
            BigDecimal fator = BigDecimal.ONE.add(juros);
            return capital.multiply(fator).setScale(2, RoundingMode.HALF_EVEN);

        } else if(tipoJuros == TipoJuros.COMPOSTO) {
            //M = C * (1 + i)^t
            BigDecimal base = BigDecimal.ONE.add(i);
            BigDecimal fator = base.pow(meses);
            return capital.multiply(fator).setScale(2, RoundingMode.HALF_EVEN);

        } else {
            throw new IllegalArgumentException("OPÇÃO DE TIPO DE JUROS INVÁLIDA -> ESCOLHA ENTRE: |SIMPLES| ou |COMPOSTO|");
        }
    }
}

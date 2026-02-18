package entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Parcela {
    private Integer numero;
    private BigDecimal valor;
    private LocalDate dataVencimento;

    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Parcela(Integer numero, BigDecimal valor, LocalDate dataVencimento) {
        this.numero = numero;
        this.valor = valor;
        this.dataVencimento = dataVencimento;
    }

    public Integer getNumero() {return numero;}
    public BigDecimal getValor() {return valor;}
    public LocalDate getDataVencimento() {return dataVencimento;}

    @Override
    public String toString() {
        return "PARCELA #" + numero + ":\n"
                + "Data de vencimento: " + fmt.format(dataVencimento) + "\n"
                + "Valor: " + String.format("R$%.2f", valor) + "\n";

    }
}

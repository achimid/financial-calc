package br.com.achimid.financalc.service;

import br.com.achimid.financalc.utils.ServiceConstants;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class RentableService {

    private BigDecimal calcularAplicacao(final BigDecimal valorAplicadoSemanalmente, final BigDecimal qtdeSemanasRestantes) {
        // Formula do calculo  M = P . (1 +  i) ^ t/252
        BigDecimal diasAplicados = ServiceConstants.DAYS_ON_WEEK.multiply(qtdeSemanasRestantes);
        return BigDecimal.ONE
                .add(ServiceConstants.SELIC_ANUAL_PERCENT)
                .pow(diasAplicados.divide(ServiceConstants.DIIN_PROFITABLE_DAYS).intValue()) // Pode dar erro se < 36, mas sequi a formula informada
                .multiply(valorAplicadoSemanalmente)
                .setScale(2, BigDecimal.ROUND_DOWN);
    }

    public BigDecimal calcularAmount(final BigDecimal valorAplicadoSemanalmente, final BigDecimal qtdeSemanas){

        BigDecimal amount  = BigDecimal.ZERO;
        BigDecimal qtdeSemanasRestantes = new BigDecimal(qtdeSemanas.doubleValue());

        for (int i = 0; i < qtdeSemanasRestantes.intValue() ; i++) {
            BigDecimal amountAplicacaoIndividual = this.calcularAplicacao(valorAplicadoSemanalmente, qtdeSemanasRestantes);
            amount = amount.add(amountAplicacaoIndividual);
            qtdeSemanasRestantes.subtract(BigDecimal.ONE);
        }

        return amount;
    }


}

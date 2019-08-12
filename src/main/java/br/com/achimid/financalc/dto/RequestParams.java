package br.com.achimid.financalc.dto;

import lombok.Data;

import java.math.BigDecimal;

public class RequestParams {

    public BigDecimal getValorAplicado() {
        return valorAplicado;
    }

    public void setValorAplicado(BigDecimal valorAplicado) {
        this.valorAplicado = valorAplicado;
    }

    private BigDecimal valorAplicado;

}

package br.com.achimid.financalc.utils;

import java.math.BigDecimal;

public class ServiceConstants {

    public static final BigDecimal SELIC_ANUAL_PERCENT = new BigDecimal(6.4).divide(new BigDecimal(100));
    public static final BigDecimal DIIN_PROFITABLE_DAYS = new BigDecimal(252);
    public static final BigDecimal DAYS_ON_WEEK = new BigDecimal(7);

}

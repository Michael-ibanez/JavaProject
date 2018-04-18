package CurrencyConverter;

import java.math.BigDecimal;

public class CurrencyConverter {
    private BigDecimal convertTo, convertFrom;


    public BigDecimal getConvertTo() {
        return convertTo;
    }

    public void setConvertTo(BigDecimal convertTo) {
        this.convertTo = convertTo;
    }

    public BigDecimal getConvertFrom() {
        return convertFrom;
    }

    public void setConvertFrom(BigDecimal convertFrom) {
        this.convertFrom = convertFrom;
    }


}

package com;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

@XmlRootElement(name="Valute")
public class Valute {
    @XmlElement(name="NumCode")
    private String numCode;
    @XmlElement(name="CharCode")
    private String charCode;
    @XmlElement(name="Nominal")
    private int nominal;
    @XmlElement(name="Name")
    private String Name;
    @XmlElement(name="Value")
    private String value;

    public Valute() {

    }

    public Valute(String numCode, String charCode, int nominal, String name, String value) {
        this.numCode = numCode;
        this.charCode = charCode;
        this.nominal = nominal;
        Name = name;
        this.value = value;
    }

    public String getNumCode() {
        return numCode;
    }

    public String getCharCode() {
        return charCode;
    }

    public int getNominal() {
        return nominal;
    }

    public String getName() {
        return Name;
    }

    public String getValue() {
        return value;
    }

    public double getDoubleValue() throws ParseException {
        NumberFormat germanFormat = NumberFormat.getNumberInstance(Locale.GERMANY);
        germanFormat.setParseIntegerOnly(false);
        double val= (double) germanFormat.parse(value);
        return val;

    }
}

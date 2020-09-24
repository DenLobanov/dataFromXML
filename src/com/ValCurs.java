package com;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="ValCurs")
public class ValCurs {

    @XmlAttribute(name="Date")
    private String date;

    @XmlAttribute(name="name")
    private String name;

    @XmlElement(name="Valute")
    private List<Valute> valutes=new ArrayList();

    public ValCurs() {
    }

    public double valueByCharCode(String charCode){
        for(Valute valute:valutes){
            if(valute.getCharCode().equals(charCode)){
                try {
                    return valute.getDoubleValue();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        return -1;
    }

    public String getDate() {
        return date;
    }
}

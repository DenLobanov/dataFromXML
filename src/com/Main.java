package com;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String[] args) {
        String address="http://www.cbr.ru/scripts/XML_daily.asp";


        JAXBContext jaxbContext = null;
        try {
            URL url = new URL(address);
            jaxbContext = JAXBContext.newInstance(ValCurs.class);
            Unmarshaller jUnmarshaller = jaxbContext.createUnmarshaller();
            ValCurs valCurs = (ValCurs) jUnmarshaller.unmarshal(url);

            String code="HKD";
            double result=valCurs.valueByCharCode(code);
            System.out.println("Курс "+code+ " на "+valCurs.getDate()+":");
            System.out.println(result);



        } catch (JAXBException | MalformedURLException e) {
            e.printStackTrace();
        }



    }
}

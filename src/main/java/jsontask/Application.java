package jsontask;

import jsontask.model.Currency;

import java.io.*;
import java.nio.file.Paths;
import java.util.List;

public class Application {

    private static final String FILE = "gson.txt";
    private static final String URL = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json";
    private Request request = new Request(URL);


    public static void main(String[] args) throws IOException {
        Application application = new Application();
        //application.update();
        System.out.println(application.getCurrencyBySn("USD"));
    }

    public void update() throws IOException {
        request.getJSON(FILE);
    }

    public Currency getCurrencyBySn(String shortName) throws IOException {
        List<Currency> currencies = CurrencyParser.getCurrencies(Paths.get(FILE));
        for (Currency currency : currencies) {
            if(currency.getShortName().equals(shortName)) {
                return currency;
            }
        }
        throw new RuntimeException("no currency with short name " + shortName);
    }

}

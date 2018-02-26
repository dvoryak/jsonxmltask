package jsontask;

import jsontask.model.Currency;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class CurrencyParser {

    private static Gson gson = new GsonBuilder()
            .setDateFormat("dd.mm.yyyy")
            .setLenient()
            .create();

    public static List<Currency> getCurrencies(Path path) throws IOException {
        if(!Files.exists(path)) {
            throw new RuntimeException("file is not exist");
        }
        if(!Files.isRegularFile(path)) {
            throw new RuntimeException("isn't a file");
        }
        return getCurrencies(new String(Files.readAllBytes(path),"UTF-8"));
    }

    public static List<Currency> getCurrencies(String json) {
        Currency[] currencies = gson.fromJson(json, Currency[].class);
        return Arrays.asList(currencies);
    }
}

import java.util.HashMap;

class CurrencyModel {
    private HashMap<String, Double> exchangeRates;

    public CurrencyModel() {
        exchangeRates = new HashMap<>();
        exchangeRates.put("RON", 1.0);
        exchangeRates.put("EUR", 4.95);
        exchangeRates.put("USD", 4.5);
    }

    public double convert(String fromCurrency, String toCurrency, double amount) {
        double fromRate = exchangeRates.get(fromCurrency);
        double toRate = exchangeRates.get(toCurrency);

        double amountInRON = amount * fromRate;
        return amountInRON / toRate;
    }
}



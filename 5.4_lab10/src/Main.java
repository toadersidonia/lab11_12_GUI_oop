public class Main {
    public static void main(String[] args) {
        CurrencyModel model = new CurrencyModel();
        CurrencyView view = new CurrencyView();
        new CurrencyController(model, view);
        view.setVisible(true);
    }
}
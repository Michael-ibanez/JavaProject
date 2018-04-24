package edu.baylor.ecs.csi.Controllers;

import edu.baylor.ecs.csi.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;


public class ConvertScreenController extends MainWindow implements Initializable{

    // essential URL structure is built using constants
    private static final String ACCESS_KEY = "a7e0d4369125dbcf6bd70ec3b52a6420";
    private static final String BASE_URL = "http://apilayer.net/api/";
    private static final String ENDPOINT = "live";

    // this object is used for executing requests to the (REST) API
    private CloseableHttpClient httpClient = null;

    private final ObservableList<String> listOfCurrencies = FXCollections.
            observableArrayList("AED", "AFN", "ALL", "AMD","ANG","AOA","AED",
            "ARS", "AUD", "AWG", "AZN", "BAM", "BBD", "BDT", "BGN","BHD","BIF","BMD",
            "BND", "BOB","BRL","BSD","BTC","BTN","BWP","BYN", "BYR", "BZD", "CAD",
            "CDF", "CHF", "CLF", "CLP", "CNY", "COP", "CRC", "CUC", "CUP", "CVE", "CZK",
            "DJF", "DKK", "DOP", "DZD", "EGP", "ERN", "ETB", "EUR", "FJD", "FKP", "GBP",
            "GEL", "GGP", "GHS", "GIP", "GMD", "GNF", "GTQ", "GYD", "HKD", "HNL", "HRK",
            "HTG", "HUF", "IDR", "ILS", "IMP", "INR", "IQD", "IRR", "ISK", "JEP", "JMD",
            "JOD", "JPY", "KES", "KGS", "KHR", "KMF", "KPW", "KRW", "KWD", "KYD", "KZT",
            "LAK", "LBP", "LKR", "LRD","LSL","LTL","LVL","LYD","MAD","MDL","MGA","MKD", "MMK",
            "MNT", "MOP", "MRO", "MUR", "MVR", "MWK", "MXN", "MYR", "MZN", "NAD", "NGN", "NIO",
            "NOK", "NPR", "NZD", "OMR", "PAB", "PEN", "PGK", "PHP", "PKR", "PLN", "PYG",
            "QAR", "RON", "RSD", "RUB", "RWF", "SAR", "SBD", "SCR", "SDG", "SEK", "SGD",
            "SHP", "SLL", "SOS", "SRD", "STD", "SVC", "SYP", "SZL", "THB", "TJS", "TMT",
            "TND", "TOP", "TRY", "TTD", "TWD", "TZS", "UAH", "UGX", "USD", "UYU", "UZS",
            "VEF", "VND", "VUV", "WST", "XAF", "XAG", "XAU", "XCD", "XDR", "XOF", "XPF",
            "YER", "ZAR", "ZMK", "ZMW", "ZWL");


    @FXML
    private ComboBox<String> mainListOfCurrenciesFrom;
    @FXML
    private ComboBox<String> mainListOfCurrenciesTo;
    @FXML
    private Button convertButton;
    @FXML
    private Button backButton;
    @FXML
    private TextField from;
    @FXML
    private TextField to;
    @FXML
    private TextField resultField;
    @FXML
    private Hyperlink credits;

    // Initialization of window
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getWindow().setWidth(475);
        getWindow().setHeight(600);

        mainListOfCurrenciesFrom.setValue("USD");
        mainListOfCurrenciesFrom.setItems(listOfCurrencies);

        mainListOfCurrenciesTo.setValue("GBP");
        mainListOfCurrenciesTo.setItems(listOfCurrencies);
    }

    // If convert button is pressed
    public void convertAction(ActionEvent event) throws IOException {
        System.out.println("Headed to convert");
        httpClient = HttpClients.createDefault();
        sendLiveRequest();
        httpClient.close();
        //new BufferedReader(new InputStreamReader(System.in)).readLine();
    }


    // Credits button
    public void creditsAction(ActionEvent event){
        System.out.println("Created by Michael Ibanez using javaFX");
    }

    // Back button
    public void back(ActionEvent event) throws IOException {
        this.connectToMenu();
        setWindow((Stage)((Node)event.getSource()).getScene().getWindow());
        getWindow().setScene(getCurr());
        getWindow().show();
    }

    public void sendLiveRequest(){

        // The following line initializes the HttpGet Object with the URL in order to send a request
        HttpGet get = new HttpGet(BASE_URL + ENDPOINT + "?access_key=" + ACCESS_KEY);

        try {
            CloseableHttpResponse response =  httpClient.execute(get);
            HttpEntity entity = response.getEntity();

            // the following line converts the JSON Response to an equivalent Java Object
            JSONObject exchangeRates = new JSONObject(EntityUtils.toString(entity));

            System.out.println("Live Currency Exchange Rates");

            // Parsed JSON Objects are accessed according to the JSON resonse's hierarchy, output strings are built
            @SuppressWarnings("RedundantCast") Date timeStampDate = new Date((long)(exchangeRates.getLong("timestamp")*1000));
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");
            String formattedDate = dateFormat.format(timeStampDate);
            System.out.println("Then " + from.getText() + " is : " + Double.valueOf(from.getText()) * exchangeRates.getJSONObject("quotes").
                    getDouble(mainListOfCurrenciesFrom.getValue() + mainListOfCurrenciesTo.getValue()));

            to.setText("1 in " + mainListOfCurrenciesFrom.getValue() + " is : " + String.valueOf(exchangeRates.getJSONObject("quotes").
                    getDouble(mainListOfCurrenciesFrom.getValue() + mainListOfCurrenciesTo.getValue())));

            resultField.setText(String.valueOf(Double.valueOf(from.getText())) + " " + exchangeRates.getString("source") + " in "+ mainListOfCurrenciesTo.getValue() + " : " + Double.toString(Double.valueOf(from.getText()) * exchangeRates.getJSONObject("quotes").
                    getDouble(mainListOfCurrenciesFrom.getValue() + mainListOfCurrenciesTo.getValue())) + " (Date: " + formattedDate + ")");

            response.close();
        } catch (JSONException | ParseException | IOException e) {
            e.printStackTrace();
        }
    }


}

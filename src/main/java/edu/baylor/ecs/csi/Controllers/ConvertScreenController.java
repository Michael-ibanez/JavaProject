/**
 * Author             : Michael Ibanez & CurrencyLayer
 * Date last modified : 4/26/2018
 * Date created       : 4/12/2018
 *
 * API from CurrencyLayer
 *
 */

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
import java.io.*;
import java.net.URL;
import java.text.DecimalFormat;
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


/**
 * The type Convert screen controller.
 */
public class ConvertScreenController extends MainWindow implements Initializable{

    // essential URL structure is built using constants
    private static final String ACCESS_KEY = "a7e0d4369125dbcf6bd70ec3b52a6420";
    private static final String BASE_URL = "http://apilayer.net/api/";
    private static final String ENDPOINT = "live";

    // this object is used for executing requests to the (REST) API
    private CloseableHttpClient httpClient = null;

    private final ObservableList<String> listOfCurrencies = FXCollections.
            observableArrayList("AED", "AFN", "ALL", "AMD","ANG",
                    "AOA","AED", "ARS", "AUD", "AWG", "AZN", "BAM", "BBD",
                    "BDT", "BGN","BHD","BIF","BMD", "CDF", "CHF", "CLF",
                    "CLP", "CNY", "COP", "CRC", "CUC", "CUP", "CVE", "CZK",
                    "DJF", "DKK", "DOP", "DZD", "EGP", "ERN", "ETB", "EUR",
                    "FJD", "FKP", "GBP", "GEL", "GGP", "GHS", "GIP", "GMD",
                    "GNF", "GTQ", "GYD", "HKD", "HNL", "HRK", "HTG", "HUF",
                    "IDR", "ILS", "IMP", "INR", "IQD", "IRR", "ISK", "JEP",
                    "JMD", "JOD", "JPY", "KES", "KGS", "KHR", "KMF", "KPW",
                    "KRW", "KWD", "KYD", "KZT", "LAK", "LBP", "LKR", "LRD",
                    "LSL","LTL","LVL","LYD","MAD","MDL","MGA","MKD", "MMK",
                    "MNT", "MOP", "MRO", "MUR", "MVR", "MWK", "MXN", "MYR",
                    "MZN", "NAD", "NGN", "NIO", "NOK", "NPR", "NZD", "OMR",
                    "PAB", "PEN", "PGK", "PHP", "PKR", "PLN", "PYG", "QAR",
                    "RON", "RSD", "RUB", "RWF", "SAR", "SBD", "SCR", "SDG",
                    "SEK", "SGD", "SHP", "SLL", "SOS", "SRD", "STD", "SVC",
                    "SYP", "SZL", "THB", "TJS", "TMT", "TND", "TOP", "TRY",
                    "TTD", "TWD", "TZS", "UAH", "UGX", "USD", "UYU", "UZS",
                    "VEF", "VND", "VUV", "WST", "XAF", "XAG", "XAU", "XCD",
                    "XDR", "XOF", "XPF", "YER", "ZAR", "ZMK", "ZMW", "ZWL");

    /**
     * The ComboBox of string that we get option of currencies from.
     */
    @FXML
    private ComboBox<String> mainListOfCurrenciesFrom;

    /**
     * The ComboBox of string that we get option of currencies from.
     */
    @FXML
    private ComboBox<String> mainListOfCurrenciesTo;

    /**
     * The convert Button.
     */
    @FXML
    private Button convertButton;

    /**
     * The back Button.
     */
    @FXML
    private Button backButton;

    /**
     * The field to get amount of currency from.
     */
    @FXML
    private TextField from;

    /**
     * The field we write our 1 to 1 conversion to.
     */
    @FXML
    private TextField to;

    /**
     * The field we write our full conversion to
     */
    @FXML
    private TextField resultField;

    /**
     * The credits hyperlink
     */
    @FXML
    private Hyperlink credits;

    /**
     * Initialize
     *    Sets dimension of application window
     *
     * @param l used from super
     * @param r used from super
     */
    @Override
    public void initialize(URL l, ResourceBundle r) {
        getWindow().setWidth(475);
        getWindow().setHeight(600);

        mainListOfCurrenciesFrom.setValue("USD");
        mainListOfCurrenciesFrom.setItems(listOfCurrencies);

        mainListOfCurrenciesTo.setValue("GBP");
        mainListOfCurrenciesTo.setItems(listOfCurrencies);
    }

    /**
     * Convert action.
     *
     * @param event the event
     * @throws IOException the io exception
     */
    public void convertAction(ActionEvent event) throws IOException {
        httpClient = HttpClients.createDefault();
        sendLiveRequest();
        httpClient.close();
    }


    /**
     * Credits action.
     *
     * @param event the event
     */
    public void creditsAction(ActionEvent event){
        System.out.println("Created by Michael Ibanez using javaFX");
    }

    /**
     * Credits action file.
     *
     * @throws IOException the io exception
     */
    public void creditsActionFile() throws IOException {

        // Creating a File object that represents the disk file.
        File newFile = new File("creditsActionFile.txt");
        if(!newFile.exists()){
            try {
                PrintWriter writer = new PrintWriter("/creditsActionFile.txt", "UTF-8");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        PrintStream o = new PrintStream(newFile,"UTF-8");

        // Assign o to output stream
        System.setOut(o);
        System.out.println("Created by Michael Ibanez using javaFX");

    }

    /**
     * Back.
     *
     * @param event the event
     * @throws IOException the io exception
     */
    public void back(ActionEvent event) throws IOException {
        this.connectToMenu();
        setWindow((Stage)((Node)event.getSource()).getScene().getWindow());
        getWindow().setScene(getCurr());
        getWindow().show();
    }

    /**
     * sendLiveRequest.
     *      What convertAction calls to get proper conversion from
     * @throws IOException the io exception
     */
    private void sendLiveRequest(){

        // The following line initializes the HttpGet Object with the URL in order to send a request
        HttpGet get = new HttpGet(BASE_URL + ENDPOINT + "?access_key=" + ACCESS_KEY
                + "&source=" + mainListOfCurrenciesFrom.getValue());

        // Used to round the number we want
        DecimalFormat df = new DecimalFormat("#.####");

        try {
            CloseableHttpResponse response =  httpClient.execute(get);
            HttpEntity entity = response.getEntity();

            // The following line converts the JSON Response to an equivalent Java Object
            JSONObject exchangeRates = new JSONObject(EntityUtils.toString(entity));

            System.out.println("Live Currency Exchange Rates");

            // Parsed JSON Objects are accessed according to the JSON resonse's hierarchy, output strings are built
            @SuppressWarnings("RedundantCast") Date timeStampDate = new Date((long)(exchangeRates.getLong("timestamp")*1000));
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");
            String formattedDate = dateFormat.format(timeStampDate);

            System.out.println("Then " + from.getText() + " is : " + Double.valueOf(from.getText()) * exchangeRates.getJSONObject("quotes").
                    getDouble(mainListOfCurrenciesFrom.getValue() + mainListOfCurrenciesTo.getValue()));

            to.setText("1 in " + mainListOfCurrenciesFrom.getValue() + " is : " + String.valueOf(df.format(exchangeRates.getJSONObject("quotes").
                    getDouble(mainListOfCurrenciesFrom.getValue() + mainListOfCurrenciesTo.getValue()))));

            resultField.setText(String.valueOf(Double.valueOf(from.getText())) + " " + exchangeRates.getString("source")
                    + " in "+ mainListOfCurrenciesTo.getValue() + " : "
                    + df.format(Double.valueOf(from.getText()) * exchangeRates.getJSONObject("quotes").getDouble(mainListOfCurrenciesFrom.getValue() + mainListOfCurrenciesTo.getValue()))
                    + " (Date: " + formattedDate + ")");

            response.close();
        } catch (JSONException | ParseException | IOException e) {
            e.printStackTrace();
        }
    }

}
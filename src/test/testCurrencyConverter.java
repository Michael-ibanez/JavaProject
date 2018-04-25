import edu.baylor.ecs.csi.Controllers.SettingsScreenController;
import edu.baylor.ecs.csi.OpenMain;
import javafx.event.ActionEvent;
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
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.Assert.assertTrue;

public class testCurrencyConverter {
    // essential URL structure is built using constants
    private static final String ACCESS_KEY = "a7e0d4369125dbcf6bd70ec3b52a6420";
    private static final String BASE_URL = "http://apilayer.net/api/";
    private static final String ENDPOINT = "live";


    @Test
    public void testUSGBP() throws IOException {

        // this object is used for executing requests to the (REST) API
        CloseableHttpClient httpClient = HttpClients.createDefault();

        System.out.println("Headed to convert");
        // The following line initializes the HttpGet Object with the URL in order to send a request
        HttpGet get = new HttpGet(BASE_URL + ENDPOINT + "?access_key=" + ACCESS_KEY);

        try {
            CloseableHttpResponse response =  httpClient.execute(get);
            HttpEntity entity = response.getEntity();

            // the following line converts the JSON Response to an equivalent Java Object
            JSONObject exchangeRates = new JSONObject(EntityUtils.toString(entity));

            assertTrue(exchangeRates.getJSONObject("quotes").getDouble("USDGBP") > 0.68
                    && exchangeRates.getJSONObject("quotes").getDouble("USDGBP") < 0.8);

            response.close();
        } catch (JSONException | ParseException | IOException e) {
            e.printStackTrace();
        }
        httpClient.close();

    }

    @Test
    public void testUSDAFN() throws IOException {

        // this object is used for executing requests to the (REST) API
        CloseableHttpClient httpClient = HttpClients.createDefault();

        System.out.println("Headed to convert!");
        // The following line initializes the HttpGet Object with the URL in order to send a request
        HttpGet get = new HttpGet(BASE_URL + ENDPOINT + "?access_key=" + ACCESS_KEY);

        try {
            CloseableHttpResponse response =  httpClient.execute(get);
            HttpEntity entity = response.getEntity();

            // the following line converts the JSON Response to an equivalent Java Object
            JSONObject exchangeRates = new JSONObject(EntityUtils.toString(entity));

            assertTrue(exchangeRates.getJSONObject("quotes").getDouble("USDAFN") > 69
                    && exchangeRates.getJSONObject("quotes").getDouble("USDAFN") < 71);

            response.close();
        } catch (JSONException | ParseException | IOException e) {
            e.printStackTrace();
        }
        httpClient.close();

    }

    @Test
    public void testSettingInjector() throws Exception {

        //User has to go to inject manually to test method
        String[] args = new String[0];
        OpenMain.main(args);

        File file = new File("/Users/michaelibanez/JavaProject/src/main/resources/convertScreen.css");
        boolean result = false;

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if(line.contains("-fx-background-image : url(/bg.jpg);")) {
                    result = true;
                }
            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }

        assertTrue(result);

    }

}

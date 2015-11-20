package fr.mosica.javaBasicTraining.own;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author florent
 */
public class OwmClient {

    private static final Logger LOG = LogManager.getLogger(OwmClient.class);

    /**
     * URL du serveur
     */
    private URL ownUrl;

    private ObjectMapper jsonMapper;

    public OwmClient(URL ownUrl) {
        this.ownUrl = ownUrl;
        this.jsonMapper = new ObjectMapper();
        // attention à la configuration du mapper
    }

    /**
     *
     * @return
     */
    public WeatherResult getWeather() {
        //lire le flux et le convertir en objet

        return null;

    }

    public URL getOwnUrl() {
        return ownUrl;
    }

    public ObjectMapper getJsonMapper() {
        return jsonMapper;
    }

    public void setJsonMapper(ObjectMapper jsonMapper) {
        this.jsonMapper = jsonMapper;
    }

}

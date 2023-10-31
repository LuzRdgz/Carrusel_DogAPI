package api;

import com.google.gson.Gson;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class API {

    public static final String BASE_URL = "https://dog.ceo/api/breeds/image/random/18";

    public static void main(String[] args)  {

        try {

            URL service = new URL(BASE_URL);
            StringBuilder json = new StringBuilder();
            String buffer;
            BufferedReader in = new BufferedReader( new InputStreamReader(service.openStream()));
            while ((buffer = in.readLine()) != null){
                System.out.println(buffer);
                json.append(buffer);
            }
            in.close();
            Gson gson = new Gson();

            apiResponse response = gson.fromJson(json.toString(), apiResponse.class);
            System.out.println(response.getMessage());
            ArrayList<String> urls = response.getMessage();

            for (String u: urls) {
                IMGdownload down = new IMGdownload(u);
                down.start();

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

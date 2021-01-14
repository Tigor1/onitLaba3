package ru.stankin.onit.laba3.servicies;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.stankin.onit.laba3.entity.Cat;
import ru.stankin.onit.laba3.entity.JsonNobelPrize;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;


@Service
public class JSONService {
    private RestTemplate restTemplate;
    private String host = "https://cat-fact.herokuapp.com";
    private JsonNobelPrize jsonNobelPrize;

    @Autowired
    public JSONService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Cat> getCatFacts() throws JsonProcessingException {
        String url = host + "/facts/random?animal_type=cat&amount=10";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<HttpHeaders> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);

        String resultRequest = response.getBody();
        Type type = new TypeToken<List<Cat>>(){}.getType();
        List<Cat> resultMap = new Gson().fromJson(resultRequest, type);
        resultMap.forEach(System.out::println);
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        JsonParser jp = new JsonParser();
//        JsonElement je = JsonParser.parseString(resultRequest);
//        String prettyJsonString = gson.toJson(je);
//        System.out.println(prettyJsonString);
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        return resultMap;
    }

    public String getCatsAndHorseFacts() {
        String url = host + "/facts?animal_type=cat,horse";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<HttpHeaders> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        JsonParser jp = new JsonParser();
        JsonElement je = JsonParser.parseString(response.getBody());
        String prettyJsonString = gson.toJson(je);
        System.out.println(prettyJsonString);
        return prettyJsonString;
    }

    public String getNobelPrize() {
        try {
            String json = Files.readAllLines(Path.of("C:\\Users\\igorl\\Documents\\onitLaba3\\src\\main\\resources\\NobelPrize.json"))
                    .stream()
                    .reduce((result, current)->result += current)
                    .orElse("Non content");

            Type type = new TypeToken<JsonNobelPrize>(){}.getType();
            jsonNobelPrize = new Gson().fromJson(json, type);

            if (!json.equals("Non content")) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                JsonParser jp = new JsonParser();
                JsonElement je = JsonParser.parseString(json);
                json = gson.toJson(je);
            }
            return json;
        } catch (IOException ex) {
            return "can't read the file";
        }
    }

    public void changeStructure() {
        jsonNobelPrize.getPrizes().forEach(x->x.setParameter1("parameter1"));
        Gson gson = new Gson();

        try {
            Files.writeString(Path.of("C:\\Users\\igorl\\Documents\\onitLaba3\\src\\main\\resources\\NobelPrize2.json"),
                    gson.toJson(jsonNobelPrize));
        } catch (IOException ex) {

        }
    }
}

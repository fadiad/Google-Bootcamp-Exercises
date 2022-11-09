package mainB.facade;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class FacadeHttpRequests {

    public int getPage(String pageNum) throws IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        JSONParser parser = new JSONParser();
        JSONObject json = null;

        try {
            HttpGet request = new HttpGet("https://reqres.in/api/users?page=" + pageNum);
            request.addHeader("custom-key", "okaying");
            request.addHeader(HttpHeaders.USER_AGENT, "Googlebot");
            CloseableHttpResponse response = httpClient.execute(request);

            try {
                HttpEntity entity = response.getEntity();

                if (entity != null) {
                    String result = EntityUtils.toString(entity);
                    json = (JSONObject) parser.parse(result);

                    System.out.println("\"GET response is\" : " + json + " .");
                }

                return response.getStatusLine().getStatusCode();

            } catch (ParseException e) {
                System.out.println("can't parse the response from String to Json");
            } finally {
                response.close();
            }
        } finally {
            httpClient.close();
        }

        return 200;
    }


    public int postPage() throws IOException {

        HttpClient httpclient = HttpClients.createDefault();

        HttpPost httppost = new HttpPost("https://reqres.in/api/users");

        List<NameValuePair> params = new ArrayList<>(2);
        params.add(new BasicNameValuePair("name", "morpheus"));
        params.add(new BasicNameValuePair("job", "leader"));
        httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

        HttpResponse response = httpclient.execute(httppost);

        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity);

        System.out.println("\"POST response is\" : " + result + " .");

        return response.getStatusLine().getStatusCode();
    }


    public int putUser() throws IOException {

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPut httpPut = new HttpPut("https://reqres.in/api/users/2");
        httpPut.setHeader("Accept", "application/json");
        httpPut.setHeader("Content-type", "application/json");
        String json = "{ \"name\":\"morpheus\", \"job\":\"zion resident\"}";
        StringEntity stringEntity = new StringEntity(json);
        httpPut.setEntity(stringEntity);

        AtomicInteger statusCode = new AtomicInteger();

        ResponseHandler<String> responseHandler = response -> {
            int status = response.getStatusLine().getStatusCode();
            statusCode.set(status);
            if (status >= 200 && status < 300) {
                HttpEntity entity = response.getEntity();
                return entity != null ? EntityUtils.toString(entity) : null;
            } else {
                throw new ClientProtocolException("Unexpected response status: " + status);
            }
        };

        String responseBody = httpclient.execute(httpPut, responseHandler);
        System.out.println("\"PUT response is\" : " + responseBody + " .");

        return statusCode.get();
    }


    public int deleteUser() throws IOException {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {

            HttpDelete httpDelete = new HttpDelete("https://reqres.in/api/users/2");

            AtomicInteger statusCode = new AtomicInteger();

            // Create a custom response handler
            ResponseHandler<String> responseHandler = response -> {
                int status = response.getStatusLine().getStatusCode();
                statusCode.set(status);
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            };


            String responseBody = httpclient.execute(httpDelete, responseHandler);
            System.out.println("\"DELETE response is\" : " + responseBody + " .");


            return statusCode.get();
        }
    }

}

package md.securitydemo;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.util.Collections;

@SpringBootTest
public class SomeControllerTest
{
    @Value("${client.ssl.trust-store}")
    private Resource trustStore;

    @Value("${client.ssl.trust-store-password}")
    private String trustStorePassword;


    @Test
    public void test() throws Exception
    {
        String url = "https://localhost:8443/secured";
        ResponseEntity<String> response = restTemplate2().getForEntity(url, String.class, Collections.emptyMap());
        String body = response.getBody();
        System.out.println(body);
    }

    RestTemplate restTemplate2() throws Exception
    {
        SSLContext context = new SSLContextBuilder().
                loadTrustMaterial(trustStore.getURL(), trustStorePassword.toCharArray()).
                build();
        SSLConnectionSocketFactory socketFactory =
                new SSLConnectionSocketFactory(context);
        HttpClient client = HttpClients.custom()
                .setSSLSocketFactory(socketFactory)
                .build();
        HttpComponentsClientHttpRequestFactory factory =
                new HttpComponentsClientHttpRequestFactory(client);
        return new RestTemplate(factory);
    }
}

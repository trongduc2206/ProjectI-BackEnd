package com.project.configurations;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

@Configuration
public class HttpClientConfiguration {

    @Value("${rest.client.connectiontimeout}")
    private int connectionTimeout;

    @Value("${rest.client.readtimeout}")
    private int readTimeout;

    @Value("${rest.client.maxperroute}")
    private int maxPerRoute;

    @Value("${rest.client.maxtotalconnection}")
    private int maxTotalConnection;
    
    @Value("${password.ssl.context}")
    private String passwordSSL;
    
    @Autowired
    ResourceLoader resourceLoader;

    @Bean
    public RestTemplate restTemplate() throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException, UnrecoverableKeyException {
        RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory());
        return restTemplate;
    }

    @Bean
    public HttpHeaders httpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        return headers;
    }

    @Bean
    public ClientHttpRequestFactory getClientHttpRequestFactory() throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
    	HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;

        SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom()
                .loadTrustMaterial(null, acceptingTrustStrategy)
                .build();

        SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);

        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(csf)
                .setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE)
                .build();
    	
        
        factory.setHttpClient(httpClient);
        factory.setConnectTimeout(connectionTimeout);
        factory.setReadTimeout(readTimeout);
        return factory;
    }

    @Bean
    public CloseableHttpClient getHttpClient() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException, CertificateException, IOException, UnrecoverableKeyException {
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setDefaultMaxPerRoute(maxPerRoute);
        connectionManager.setMaxTotal(maxTotalConnection);
        KeyStore clientStore = KeyStore.getInstance("PKCS12");
        clientStore.load(resourceLoader.getResource("classpath:/ssl/keystore.p12").getInputStream(), passwordSSL.toCharArray());
        
        SSLContextBuilder sslContextBuilder = new SSLContextBuilder();
//        sslContextBuilder.setProtocol("TLS");
        sslContextBuilder.loadKeyMaterial(clientStore, passwordSSL.toCharArray());
        sslContextBuilder.loadTrustMaterial(new TrustSelfSignedStrategy());

        SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContextBuilder.build());
       
        return HttpClients.custom().setSSLSocketFactory(sslConnectionSocketFactory).setConnectionManager(connectionManager).build();
    }
}

package com.InnoSistemasDocumentos.GestionDocumentos.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Base64;

@Configuration
public class FirebaseConfig {

    @PostConstruct
    public void init() {
        try {
            String base64Creds = System.getenv("FIREBASE_CONFIG_B64");

            if (base64Creds == null || base64Creds.isEmpty()) {
                throw new IllegalStateException("FIREBASE_CONFIG_B64 env variable is not set or empty");
            }

            byte[] decodedBytes = Base64.getDecoder().decode(base64Creds);
            InputStream serviceAccount = new ByteArrayInputStream(decodedBytes);

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
            }

        } catch (Exception e) {
            throw new RuntimeException("Error inicializando Firebase", e);
        }
    }
}

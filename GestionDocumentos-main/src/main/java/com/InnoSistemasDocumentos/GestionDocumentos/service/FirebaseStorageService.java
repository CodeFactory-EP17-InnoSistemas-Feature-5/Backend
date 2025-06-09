package com.InnoSistemasDocumentos.GestionDocumentos.service;

import com.google.cloud.storage.Blob;
import com.google.firebase.cloud.StorageClient;
import com.google.cloud.storage.Bucket;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FirebaseStorageService {

    public String uploadFile(MultipartFile file, String fileName) {
        try {
            Bucket bucket = StorageClient.getInstance().bucket();
            Blob blob = bucket.create(fileName, file.getInputStream(), file.getContentType());
            return blob.getMediaLink(); // o blob.signUrl(...) si es acceso restringido
        } catch (IOException e) {
            throw new RuntimeException("Error al subir archivo a Firebase", e);
        }
    }

    public byte[] downloadFile(String fileName) {
        Bucket bucket = StorageClient.getInstance().bucket();
        Blob blob = bucket.get(fileName);
        return blob.getContent();
    }

    public boolean deleteFile(String fileName) {
        Bucket bucket = StorageClient.getInstance().bucket();
        return bucket.get(fileName).delete();
    }

    public String updateFile(String oldFileName, MultipartFile newFile, String newFileName) {
        deleteFile(oldFileName);
        return uploadFile(newFile, newFileName);
    }
}

package com.InnoSistemasDocumentos.GestionDocumentos.controller;


import com.InnoSistemasDocumentos.GestionDocumentos.service.FirebaseStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/files")
public class FileController {
    private final FirebaseStorageService firebaseStorageService;

    @Autowired
    public FileController(FirebaseStorageService firebaseStorageService) {
        this.firebaseStorageService = firebaseStorageService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        String url = firebaseStorageService.uploadFile(file, file.getOriginalFilename());
        return ResponseEntity.ok(url);
    }

    @GetMapping("/download/{filename}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable String filename) {
        byte[] content = firebaseStorageService.downloadFile(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
                .body(content);
    }

    @DeleteMapping("/delete/{filename}")
    public ResponseEntity<String> deleteFile(@PathVariable String filename) {
        firebaseStorageService.deleteFile(filename);
        return ResponseEntity.ok("Archivo eliminado correctamente");
    }
}

package com.landregistry.backend.Controller;

import com.landregistry.backend.Model.Document;
import com.landregistry.backend.Service.DocumentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/documents")
public class DocumentController {

    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping
    public Document uploadDocument(@RequestBody Document document) {
        return documentService.uploadDocument(document);
    }

    @GetMapping
    public List<Document> getAllDocuments() {
        return documentService.getAllDocuments();
    }
}

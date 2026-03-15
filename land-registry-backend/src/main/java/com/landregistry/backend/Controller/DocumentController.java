package com.landregistry.backend.Controller;

import com.landregistry.backend.dto.DocumentDTO;
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
    public DocumentDTO uploadDocument(@RequestBody DocumentDTO documentDTO) {
        return documentService.uploadDocument(documentDTO);
    }

    @GetMapping
    public List<DocumentDTO> getAllDocuments() {
        return documentService.getAllDocuments();
    }

    @GetMapping("/{id}")
    public DocumentDTO getDocumentById(@PathVariable Long id) {
        return documentService.getDocumentById(id);
    }
}
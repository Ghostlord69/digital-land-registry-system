package com.landregistry.backend.Controller;

import com.landregistry.backend.dto.DocumentDTO;
import com.landregistry.backend.response.ApiResponse;
import com.landregistry.backend.Service.DocumentService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/documents")
public class DocumentController {

    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping
    public ApiResponse<DocumentDTO> uploadDocument(@Valid @RequestBody DocumentDTO documentDTO) {

        DocumentDTO document = documentService.uploadDocument(documentDTO);

        return new ApiResponse<>(
                true,
                "Document uploaded successfully",
                document
        );
    }

    @GetMapping
    public ApiResponse<List<DocumentDTO>> getAllDocuments() {

        List<DocumentDTO> documents = documentService.getAllDocuments();

        return new ApiResponse<>(
                true,
                "Documents fetched successfully",
                documents
        );
    }

    @GetMapping("/{id}")
    public ApiResponse<DocumentDTO> getDocumentById(@PathVariable Long id) {

        DocumentDTO document = documentService.getDocumentById(id);

        return new ApiResponse<>(
                true,
                "Document fetched successfully",
                document
        );
    }
}
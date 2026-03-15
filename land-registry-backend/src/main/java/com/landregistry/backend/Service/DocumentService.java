package com.landregistry.backend.Service;

import com.landregistry.backend.dto.DocumentDTO;
import com.landregistry.backend.exception.ResourceNotFoundException;
import com.landregistry.backend.mapper.DocumentMapper;
import com.landregistry.backend.Model.Document;
import com.landregistry.backend.Repository.DocumentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentService {

    private final DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public DocumentDTO uploadDocument(DocumentDTO documentDTO) {

        Document document = DocumentMapper.toEntity(documentDTO);

        Document savedDocument = documentRepository.save(document);

        return DocumentMapper.toDTO(savedDocument);
    }

    public List<DocumentDTO> getAllDocuments() {

        return documentRepository.findAll()
                .stream()
                .map(DocumentMapper::toDTO)
                .collect(Collectors.toList());
    }

    public DocumentDTO getDocumentById(Long id) {

        Document document = documentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Document not found"));

        return DocumentMapper.toDTO(document);
    }
}
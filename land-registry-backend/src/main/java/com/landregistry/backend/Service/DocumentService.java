package com.landregistry.backend.Service;

import com.landregistry.backend.Model.Property;
import com.landregistry.backend.Model.User;
import com.landregistry.backend.Repository.PropertyRepository;
import com.landregistry.backend.Repository.UserRepository;
import com.landregistry.backend.dto.DocumentDTO;
import com.landregistry.backend.exception.ResourceNotFoundException;
import com.landregistry.backend.mapper.DocumentMapper;
import com.landregistry.backend.Model.Document;
import com.landregistry.backend.Repository.DocumentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentService {

    private final DocumentRepository documentRepository;
    private final PropertyRepository propertyRepository;
    private final UserRepository userRepository;

    public DocumentService(DocumentRepository documentRepository, PropertyRepository propertyRepository, UserRepository userRepository) {
        this.documentRepository = documentRepository;
        this.propertyRepository = propertyRepository;
        this.userRepository = userRepository;
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

    public String saveFile(MultipartFile file, Long propertyId, Long userId) {

        try {
            String uploadDir = System.getProperty("user.dir") + "/uploads/";
            File dir = new File(uploadDir);

            if (!dir.exists()) {
                dir.mkdirs();
            }

            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            String filePath = uploadDir + fileName;

            file.transferTo(new File(filePath));

            Property property = propertyRepository.findById(propertyId)
                    .orElseThrow(() -> new RuntimeException("Property not found"));

            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new RuntimeException("User not found"));

            Document document = new Document();
            document.setDocumentType("IMAGE");
            document.setFilePath(filePath);
            document.setUploadedAt(LocalDateTime.now());
            document.setProperty(property);
            document.setUploadedBy(user);

            documentRepository.save(document);

            return filePath;

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("File upload failed: " + e.getMessage());
        }
    }
}
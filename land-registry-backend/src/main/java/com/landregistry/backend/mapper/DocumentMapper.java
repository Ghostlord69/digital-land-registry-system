package com.landregistry.backend.mapper;

import com.landregistry.backend.dto.DocumentDTO;
import com.landregistry.backend.Model.Document;
import com.landregistry.backend.Model.Property;
import com.landregistry.backend.Model.User;

public class DocumentMapper {

    private DocumentMapper(){}
    public static DocumentDTO toDTO(Document document) {

        if (document == null) {
            return null;
        }

        DocumentDTO dto = new DocumentDTO();

        dto.setId(document.getId());
        dto.setDocumentType(document.getDocumentType());
        dto.setFilePath(document.getFilePath());
        dto.setUploadedAt(document.getUploadedAt());

        if (document.getProperty() != null) {
            dto.setPropertyId(document.getProperty().getId());
        }

        if (document.getUploadedBy() != null) {
            dto.setUploadedBy(document.getUploadedBy().getId());
        }

        return dto;
    }

    public static Document toEntity(DocumentDTO dto) {

        if (dto == null) {
            return null;
        }

        Document document = new Document();

        document.setId(dto.getId());
        document.setDocumentType(dto.getDocumentType());
        document.setFilePath(dto.getFilePath());
        document.setUploadedAt(dto.getUploadedAt());

        if (dto.getPropertyId() != null) {
            Property property = new Property();
            property.setId(dto.getPropertyId());
            document.setProperty(property);
        }

        if (dto.getUploadedBy() != null) {
            User user = new User();
            user.setId(dto.getUploadedBy());
            document.setUploadedBy(user);
        }

        return document;
    }
}
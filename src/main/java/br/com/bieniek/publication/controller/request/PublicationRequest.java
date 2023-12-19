package br.com.bieniek.publication.controller.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublicationRequest {

    @NotBlank(message = "Title is mandatory")
    private String title;

    private String imageUrl;

    @NotBlank(message = "Text is mandatory")
    private String text;
}

package br.com.bieniek.publication.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublicationResponse {

    private String id;
    private String title;
    private String imageUrl;
    private String text;
}

package com.example.demoCrud.controller;

import com.example.demoCrud.Dto.PublisherDto;
import com.example.demoCrud.model.Publisher;
import com.example.demoCrud.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/publisher")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    private PublisherDto mapPublisherToDTO(Publisher publisher) {
        PublisherDto dto = new PublisherDto();
        dto.setId(publisher.getId());
        dto.setName(publisher.getName());
        return dto;
    }

    private List<PublisherDto> mapPublishersToDTOs(Iterable<Publisher> publishers) {
        List<PublisherDto> dtos = new ArrayList<>();
        for (Publisher publisher : publishers) {
            dtos.add(mapPublisherToDTO(publisher));
        }
        return dtos;
    }

    @PostMapping("/newPublisher")
    public PublisherDto newPublisher(@RequestBody Publisher newPublisher) {
        Publisher savedPublisher = this.publisherService.newPublisher(newPublisher);
        return mapPublisherToDTO(savedPublisher);
    }

    @GetMapping("/showPublishers")
    public Iterable<PublisherDto> getAll() {
        Iterable<Publisher> showPublisher = publisherService.getAll();
        return mapPublishersToDTOs(showPublisher);
    }

    @PostMapping("/updatePublisher")
    public PublisherDto updatePublisher(@RequestBody Publisher publisher) {
        Publisher updatePublisher = this.publisherService.editPublisher(publisher);
        return mapPublisherToDTO(updatePublisher);
    }

    @PostMapping(value = "/delete/{id}")
    public Boolean deletePublisher(@PathVariable(value = "id") Long id) {
        return this.publisherService.deletePublisher(id);
    }
}

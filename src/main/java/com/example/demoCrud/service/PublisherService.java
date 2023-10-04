package com.example.demoCrud.service;

import com.example.demoCrud.model.Publisher;
import com.example.demoCrud.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    public Publisher newPublisher(Publisher newPublisher) {
        return publisherRepository.save(newPublisher);
    }

    public Iterable<Publisher> getAll() {
        return this.publisherRepository.findAll();
    }

    public Publisher editPublisher(Publisher publisher) {
        Optional<Publisher> publisherEdit = this.publisherRepository.findById(publisher.getId());
        if (publisherEdit.get() != null) {
            publisherEdit.get().setName(publisher.getName());

            return this.newPublisher(publisherEdit.get());
        }
        return null;
    }

    public Boolean deletePublisher(Long id) {
        this.publisherRepository.deleteById(id);
        return true;
    }
}

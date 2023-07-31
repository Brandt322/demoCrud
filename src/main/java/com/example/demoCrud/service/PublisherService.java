package com.example.demoCrud.service;

import com.example.demoCrud.model.Publisher;

public interface PublisherService {
    Publisher newPublisher(Publisher newPublisher);

    Iterable<Publisher> getAll();

    Publisher editPublisher(Publisher publisher);

    Boolean deletePublisher(Long id);
}

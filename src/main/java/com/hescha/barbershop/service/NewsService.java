package com.hescha.barbershop.service;

import com.hescha.barbershop.entity.News;
import com.hescha.barbershop.repository.NewsRepository;
import org.springframework.stereotype.Service;

@Service
public class NewsService extends CrudImpl<News> {

    public NewsRepository repository;

    public NewsService(NewsRepository repository) {
        super(repository);
        this.repository = repository;
    }

}

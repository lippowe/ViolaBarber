package com.hescha.barbershop.service;


import com.hescha.barbershop.entity.MService;
import com.hescha.barbershop.repository.MServiceRepository;
import org.springframework.stereotype.Service;


@Service
public class MServiceService extends CrudImpl<MService> {

    public MServiceRepository repository;

    public MServiceService(MServiceRepository repository) {
        super(repository);
        this.repository = repository;
    }

}

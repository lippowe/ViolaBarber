package com.hescha.barbershop.service;


import com.hescha.barbershop.entity.Role;
import com.hescha.barbershop.repository.RoleRepository;
import org.springframework.stereotype.Service;


@Service
public class RoleServiceImpl extends CrudImpl<Role> {

    public RoleRepository repository;

    public RoleServiceImpl(RoleRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public Role findByName(String name) {
        return repository.findByNameIgnoreCase(name);
    }

}

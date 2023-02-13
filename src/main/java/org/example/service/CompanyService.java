package org.example.service;

import org.example.database.entity.Company;
import org.example.database.repository.CrudRepository;
import org.example.dto.CompanyReadDto;
import org.example.listner.entity.AccessType;
import org.example.listner.entity.EntityEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {
    private final CrudRepository<Integer, Company> companyCrudRepository;
    private final UserService userService;
    private final ApplicationEventPublisher eventPublisher;

    public CompanyService(CrudRepository<Integer, Company> companyCrudRepository, UserService userService, ApplicationEventPublisher eventPublisher) {
        this.companyCrudRepository = companyCrudRepository;
        this.userService = userService;
        this.eventPublisher = eventPublisher;
    }

    public Optional<CompanyReadDto> findById(Integer id) {
        return companyCrudRepository.findById(id)
                .map(entity -> {
                            eventPublisher.publishEvent(new EntityEvent(entity, AccessType.READ));
                            return new CompanyReadDto(entity.id());
                        }
                );
    }
}

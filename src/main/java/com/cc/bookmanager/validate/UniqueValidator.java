package com.cc.bookmanager.validate;

import com.cc.bookmanager.exception.ExistedException;
import com.cc.bookmanager.model.MDMAEntity;
import javassist.NotFoundException;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Objects;

public class UniqueValidator<
        ENTITY extends MDMAEntity,
        ID_TYPE,
        REPOSITORY extends JpaRepository<ENTITY, ID_TYPE> & JpaSpecificationExecutor<ENTITY>
        > {
    REPOSITORY repository;
    String name;

    public UniqueValidator(REPOSITORY repository, String name) {
        this.repository = repository;
        this.name = name;
    }

    public void checkIdExist(ID_TYPE id) throws NotFoundException {
        if (!repository.existsById(id))
            throw new NotFoundException("Ma " + name + " chua ton tai");
    }

    public void checkFieldUniqueOnCreate(String code, String field) throws ExistedException {
        if (repository.findAll((Specification<ENTITY>) (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(field), code)).size() > 0)
            throw new ExistedException("Ma " + name + " da ton tai");
    }

    public void checkFieldUniqueOnUpdate(ID_TYPE id, String code, String field) throws ExistedException {
        ENTITY expectedEntity = repository.getReferenceById(id);
        List<ENTITY> unexpectedEntities = repository.findAll((Specification<ENTITY>) (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get(field), code));
        if (unexpectedEntities.size() > 0 && !Objects.equals(unexpectedEntities.get(0).getId(), expectedEntity.getId()))
            throw new ExistedException("Ma " + name + " da ton tai");
    }

}

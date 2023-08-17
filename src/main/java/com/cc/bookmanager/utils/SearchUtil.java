package com.cc.bookmanager.utils;

import com.cc.bookmanager.dto.base.simple.request.ApiListBaseRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SearchUtil<
        ENTITY,
        ID_TYPE,
        REPOSITORY extends JpaRepository<ENTITY, ID_TYPE> & JpaSpecificationExecutor<ENTITY>
        > {
    List<Specification<ENTITY>> specifications;
    List<Predicate> tempPredicates;
    REPOSITORY repository;

    public SearchUtil(REPOSITORY repository) {
        this.repository = repository;
        specifications = new ArrayList<>();
        tempPredicates = new ArrayList<>();
    }

    public SearchUtil<ENTITY, ID_TYPE, REPOSITORY> likeOrLikeWithoutSensitiveCase(String keyword, String... fields) {
        if (StringUtils.isNotBlank(keyword)) {
            String finalKeyword = "%" + keyword.trim().toUpperCase() + "%";
            specifications.add(
                    (Specification<ENTITY>) (root, query, criteriaBuilder) -> {
                        for (String field : fields) {
                            tempPredicates.add(criteriaBuilder.like(criteriaBuilder.upper(root.get(field)), finalKeyword));
                        }
                        return criteriaBuilder.or(tempPredicates.toArray(Predicate[]::new));
                    });
            tempPredicates.clear();
        }
        return this;
    }

    public SearchUtil<ENTITY, ID_TYPE, REPOSITORY> likeOrLike(String keyword, String... fields) {
        if (StringUtils.isNotBlank(keyword)) {
            String finalKeyword = "%" + keyword.trim() + "%";
            specifications.add(
                    (Specification<ENTITY>) (root, query, criteriaBuilder) -> {
                        for (String field : fields) {
                            tempPredicates.add(criteriaBuilder.like(root.get(field), finalKeyword));
                        }
                        return criteriaBuilder.or(tempPredicates.toArray(Predicate[]::new));
                    });
            tempPredicates.clear();
        }
        return this;
    }

    public SearchUtil<ENTITY, ID_TYPE, REPOSITORY> findStatus(Integer status) {
        if (status != null)
            specifications.add(
                    (Specification<ENTITY>) (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("status"), status));
        return this;
    }

    public SearchUtil<ENTITY, ID_TYPE, REPOSITORY> simpleEqual(Object query_, String fields) {
        if (query_ != null)
            specifications.add(
                    (Specification<ENTITY>) (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(fields), query_));
        return this;
    }

    public SearchUtil<ENTITY, ID_TYPE, REPOSITORY> custom(Specification<ENTITY> s) {
        specifications.add(s);
        return this;
    }

    public SearchUtil<ENTITY, ID_TYPE, REPOSITORY> findByYear(Integer year, String... fields) {
        if (year != null) {
            specifications.add(
                    (Specification<ENTITY>) (root, query, criteriaBuilder) -> {
                        for (String field : fields) {
                            tempPredicates.add(
                                    criteriaBuilder.equal(
                                            criteriaBuilder.function("year", Integer.class, root.<Date>get(field)),
                                            year)
                            );
                        }
                        return criteriaBuilder.or(tempPredicates.toArray(Predicate[]::new));
                    });
            tempPredicates.clear();
        }
        return this;
    }

    public Page<ENTITY> build(ApiListBaseRequest filter) {
        Page<ENTITY> data;
        if (!specifications.isEmpty()) {
            data = repository.findAll(specifications.stream().reduce(Specification::and).orElseThrow(),
                    FilterDataUtil.buildPageRequest(filter));
            specifications.clear();
        } else {
            data = repository.findAll(FilterDataUtil.buildPageRequest(filter));
        }
        return data;
    }
}

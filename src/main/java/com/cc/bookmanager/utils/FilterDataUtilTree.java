package com.cc.bookmanager.utils;

import com.cc.bookmanager.dto.base.tree.request.ApiListBaseRequest;
import com.cc.bookmanager.enums.TypeSort;
import lombok.experimental.UtilityClass;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@UtilityClass
public class FilterDataUtilTree {
    public static PageRequest buildPageRequest(ApiListBaseRequest filter) {
        if (TypeSort.DESC.equals(filter.getOrderDirection())) {
            return PageRequest.of(filter.getPage(), filter.getSize());
        }
        return PageRequest.of(filter.getPage(), filter.getSize());
    }

    public static PageRequest buildPageRequest(Integer page, Integer pageSize, String field,
                                               TypeSort type) {
        if (TypeSort.DESC.equals(type)) {
            return PageRequest.of(page, pageSize, Sort.by(field).descending());
        }
        return PageRequest.of(page, pageSize, Sort.by(field).ascending());
    }

    public static PageRequest buildPageRequestDefault(String field, Integer page, Integer pageSize) {
        return PageRequest.of(page, pageSize, Sort.by(field).ascending());
    }
}

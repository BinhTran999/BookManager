package com.cc.bookmanager.service;

import com.cc.bookmanager.dto.base.simple.request.ApiBaseRequest;
import com.cc.bookmanager.dto.base.simple.request.ApiListBaseRequest;
import com.cc.bookmanager.dto.base.simple.request.ApiSearchBaseRequest;
import com.cc.bookmanager.dto.base.simple.response.BaseDto;
import com.cc.bookmanager.dto.base.simple.response.BasePage;
import com.cc.bookmanager.mapper.BaseMapper;
import com.cc.bookmanager.model.MDMAEntity;
import com.cc.bookmanager.utils.FilterDataUtil;
import com.cc.bookmanager.utils.SearchUtil;
import com.cc.bookmanager.validate.UniqueValidator;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Date;
import java.util.HashMap;

@AllArgsConstructor
public abstract class BaseService<
        ENTITY extends MDMAEntity,
        REQ_ENTITY extends ApiBaseRequest,
        REQ_SEARCH extends ApiSearchBaseRequest,
        REQ_LIST_ALL extends ApiListBaseRequest,
        RES_ENTITY extends BaseDto,
        ID_TYPE,
        MAPPER extends BaseMapper<REQ_ENTITY, RES_ENTITY, ENTITY>,
        REPOSITORY extends JpaRepository<ENTITY, ID_TYPE> & JpaSpecificationExecutor<ENTITY>
        > {
    protected final REPOSITORY repository;
    protected final MAPPER mapper;
    //protected final LogActionUtil logAction;
    protected final SearchUtil<ENTITY, ID_TYPE, REPOSITORY> searchUtil;
    protected final UniqueValidator<ENTITY, ID_TYPE, REPOSITORY> uniqueValidator;
    protected final String cacheName;

    public BaseService(REPOSITORY repository, MAPPER mapper,/* LogActionUtil logAction,*/ String name) {
        this.repository = repository;
        this.mapper = mapper;
        //this.logAction = logAction;
        this.searchUtil = new SearchUtil<>(repository);
        cacheName = mapper.getClass().getSimpleName().replace("MDM", "").replace("Impl","").replace("Mapper", "");
        uniqueValidator = new UniqueValidator<>(repository, name);
    }

    @Transactional
    @CacheEvict(allEntries = true, cacheResolver = "cacheResolver")
    public RES_ENTITY create(REQ_ENTITY request) {
        ENTITY entity = repository.save(mapper.toEntity(request));
        RES_ENTITY responseEntity = mapper.toDao(entity);
        return responseEntity;
    }

    @SneakyThrows
    @Transactional
    @CacheEvict(allEntries = true, cacheResolver = "cacheResolver")
    public RES_ENTITY update(ID_TYPE id, REQ_ENTITY req) {
        ENTITY entity = repository.getReferenceById(id);
        mapper.update(req, entity);
        RES_ENTITY responseEntity = mapper.toDao(repository.save(entity));
//        logAction.logAction(cacheName, String.valueOf(entity.getId()), JsonUtil.dumpObject(responseEntity),
//                Constants.MA_HANH_DONG.CHINH_SUA, null, new Date(), null);
        return responseEntity;
    }

    @SneakyThrows
    @Transactional
    @CacheEvict(allEntries = true, cacheResolver = "cacheResolver")
    public void delete(ID_TYPE id) {
        uniqueValidator.checkIdExist(id);
        ENTITY object = repository.getReferenceById(id);
//        logAction.logAction(cacheName, String.valueOf(object.getId()), JsonUtil.dumpObject(object),
//                Constants.MA_HANH_DONG.XOA, null, new Date(), null);
        repository.deleteById(id);
    }

    @SneakyThrows
    @Transactional
    @Cacheable(key = "#id", unless = "#result == null", cacheResolver = "cacheResolver")
    public RES_ENTITY detail(ID_TYPE id) {
        uniqueValidator.checkIdExist(id);
        return mapper.toDao(repository.getReferenceById(id));
    }

    @Transactional
    @Cacheable(key = "#listRequest", cacheResolver = "cacheResolver")
    public BasePage<RES_ENTITY> getAll(REQ_LIST_ALL listRequest) {
        Page<ENTITY> page = repository.findAll(FilterDataUtil.buildPageRequest(listRequest));
        return this.map(page);
    }

    @Cacheable(key = "#searchParams", cacheResolver = "cacheResolver")
    public BasePage<RES_ENTITY> search(REQ_SEARCH searchRequest, HashMap<String, Object> searchParams){
        return this.search(searchRequest);
    }


    public abstract BasePage<RES_ENTITY> search(REQ_SEARCH searchRequest);

    protected BasePage<RES_ENTITY> map(Page<ENTITY> page) {
        BasePage<RES_ENTITY> rPage = new BasePage<>();
        rPage.setData(mapper.toListDao(page.getContent()));
        rPage.setTotalPage(page.getTotalPages());
        rPage.setTotalRecord(page.getTotalElements());
        rPage.setPage(page.getPageable().getPageNumber());
        return rPage;
    }

}

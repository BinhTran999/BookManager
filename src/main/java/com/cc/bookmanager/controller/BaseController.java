package com.cc.bookmanager.controller;

import com.cc.bookmanager.dto.base.simple.request.ApiBaseRequest;
import com.cc.bookmanager.dto.base.simple.request.ApiListBaseRequest;
import com.cc.bookmanager.dto.base.simple.request.ApiSearchBaseRequest;
import com.cc.bookmanager.dto.base.simple.response.*;
import com.cc.bookmanager.mapper.BaseMapper;
import com.cc.bookmanager.model.MDMAEntity;
import com.cc.bookmanager.service.BaseService;
import com.cc.bookmanager.validate.ValidUUID;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.reflect.Field;
import java.util.HashMap;

import static com.cc.bookmanager.controller.Endpoints.*;
@RequiredArgsConstructor
@SecurityRequirement(name = "Auth Provider")
@ApiResponses(value = {
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiResponse.class))
        }), @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Yêu cầu không hợp lệ", content = {
        @Content(schema = @Schema(implementation = ApiResponse.class), mediaType = "application/json")
}), @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", description = "Lỗi xác thực tài khoản", content = {
        @Content(schema = @Schema(implementation = ApiResponse.class), mediaType = "application/json")
}), @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Yêu cầu không tồn tại", content = {
        @Content(schema = @Schema(implementation = ApiResponse.class), mediaType = "application/json")
}), @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Lỗi trong quá trình xử lý", content = {
        @Content(schema = @Schema(implementation = ApiResponse.class), mediaType = "application/json")
})
})
public abstract class BaseController<
        ENTITY extends MDMAEntity,
        REQ_ENTITY extends ApiBaseRequest,
        REQ_SEARCH extends ApiSearchBaseRequest,
        REQ_LIST_ALL extends ApiListBaseRequest,
        RES_ENTITY extends BaseDto,
        ID_TYPE,
        MAPPER extends BaseMapper<REQ_ENTITY, RES_ENTITY, ENTITY>,
        REPOSITORY extends JpaRepository<ENTITY, ID_TYPE> & JpaSpecificationExecutor<ENTITY>,
        SERVICE extends BaseService<ENTITY, REQ_ENTITY, REQ_SEARCH, REQ_LIST_ALL, RES_ENTITY, ID_TYPE, MAPPER, REPOSITORY>>
{
    protected SERVICE service;
    protected ApiResponseBuild<RES_ENTITY> apiResponseBuilder = new ApiResponseBuild<>();

    public BaseController(SERVICE service) {
        this.service = service;
    }

    @RequestMapping(value = CREATE_PATH, method = RequestMethod.POST)
    public ApiBaseObjectResponse<RES_ENTITY> create(@RequestBody REQ_ENTITY reqCreate) {
        return apiResponseBuilder.successObject(service.create(reqCreate));
    }

    @RequestMapping(value = UPDATE_PATH, method = RequestMethod.PUT)
    public ApiBaseObjectResponse<RES_ENTITY> update(@PathVariable @ValidUUID ID_TYPE uuid, @RequestBody REQ_ENTITY reqUpdate) {
        return apiResponseBuilder.successObject(service.update(uuid, reqUpdate));
    }

    @RequestMapping(value = GET_ALL_PATH, method = RequestMethod.GET)
    public ApiBaseObjectResponse<BasePage<RES_ENTITY>> getAll(REQ_LIST_ALL reqListAll) {
        return apiResponseBuilder.successObject(service.getAll(reqListAll));
    }

    @SneakyThrows
    @RequestMapping(value = SEARCH_PATH, method = RequestMethod.GET)
    public ApiBaseObjectResponse<BasePage<RES_ENTITY>> search(REQ_SEARCH reqSearch) {
        HashMap<String, Object> map = new HashMap<>();
        Field[] fields = reqSearch.getClass().getDeclaredFields();

        for (Field field: fields) {
            field.setAccessible(true);
            map.put(field.getName(), field.get(reqSearch));
        }
        return apiResponseBuilder.successObject(service.search(reqSearch,map));
    }

    @RequestMapping(value = DETAIL_PATH, method = RequestMethod.GET)
    public ApiBaseObjectResponse<RES_ENTITY> detail(@PathVariable @ValidUUID ID_TYPE uuid) {
        return apiResponseBuilder.successObject(service.detail(uuid));
    }

    @RequestMapping(value = DELETE_PATH, method = RequestMethod.DELETE)
    public ApiBaseResponse delete(@PathVariable @ValidUUID ID_TYPE uuid) {
        service.delete(uuid);
        return apiResponseBuilder.success();
    }
}

package com.cc.bookmanager.dto.base.tree.response;

import java.util.List;

import static com.cc.bookmanager.exception.ExceptionCode.SUCCESS;

public class ApiResponseBuild<T extends BaseDto<T>> {
    public ApiBaseObjectResponse<T> successObject(T t){
        return new ApiBaseObjectResponse<>(SUCCESS.getCode(),SUCCESS.getDetail(),t);
    }

    public ApiBaseResponse success() {
        return new ApiBaseResponse(SUCCESS.getCode(),SUCCESS.getDetail());
    }

    public ApiBaseObjectResponse<BasePage<T>> successObject(BasePage<T> t) {
        return new ApiBaseObjectResponse<>(SUCCESS.getCode(), SUCCESS.getDetail(), t);
    }

    //Bonus

    public ApiBaseObjectResponse<List<T>> successObject(List<T> t){
        return new ApiBaseObjectResponse<>(SUCCESS.getCode(),SUCCESS.getDetail(),t);
    }
}

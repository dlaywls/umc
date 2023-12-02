package umc.spring.base.exception.handler;

import umc.spring.base.Code.BaseErrorCode;
import umc.spring.base.exception.GeneralException;

public class StoreHandler extends GeneralException {
    public StoreHandler(BaseErrorCode errorCode){
        super(errorCode);
    }
}

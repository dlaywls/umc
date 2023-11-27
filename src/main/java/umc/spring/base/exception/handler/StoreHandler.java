package umc.spring.base.exception.handler;

import umc.spring.base.Code;
import umc.spring.base.exception.GeneralException;

public class StoreHandler extends GeneralException {
    public StoreHandler(Code errorCode){
        super(errorCode);
    }
}

package umc.spring.base.exception.handler;


import umc.spring.base.Code.BaseErrorCode;
import umc.spring.base.exception.GeneralException;

public class TempHandler extends GeneralException {
    public TempHandler(BaseErrorCode errorCode){
        super(errorCode);
    }
}

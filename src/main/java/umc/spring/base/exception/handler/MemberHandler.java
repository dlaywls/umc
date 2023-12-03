package umc.spring.base.exception.handler;

import umc.spring.base.Code.status.ErrorStatus;
import umc.spring.base.exception.GeneralException;

public class MemberHandler extends GeneralException {
    public MemberHandler(ErrorStatus errorCode){
        super(errorCode);
    }
}


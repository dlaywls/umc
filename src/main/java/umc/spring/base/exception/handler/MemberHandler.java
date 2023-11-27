package umc.spring.base.exception.handler;

import umc.spring.base.Code;
import umc.spring.base.exception.GeneralException;

public class MemberHandler extends GeneralException {
    public MemberHandler(Code errorCode){
        super(errorCode);
    }
}


package umc.spring.base.exception.handler;

import umc.spring.base.exception.GeneralException;

public class MemberHandler extends GeneralException {
    public MemberHandler(ErrorStatus errorCode){
        super(errorCode);
    }
}


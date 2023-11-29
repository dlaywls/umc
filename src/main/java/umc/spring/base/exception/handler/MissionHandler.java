package umc.spring.base.exception.handler;

import umc.spring.base.Code;
import umc.spring.base.exception.GeneralException;

public class MissionHandler extends GeneralException {
    public MissionHandler(Code errorCode){
        super(errorCode);
    }
}

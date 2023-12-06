package umc.spring.base.exception.handler;

import umc.spring.base.Code.status.ErrorStatus;
import umc.spring.base.exception.GeneralException;

public class MissionHandler extends GeneralException {
    public MissionHandler(ErrorStatus errorCode){
        super(errorCode);
    }
}

package umc.spring.base.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.spring.base.Code.BaseErrorCode;
import umc.spring.base.Code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException{
    private BaseErrorCode code;

    public ErrorReasonDTO getErrorReason() {
        return this.code.getReason();
    }

    public ErrorReasonDTO getErrorReasonHttpStatus(){
        return this.code.getReasonHttpStatus();
    }
}

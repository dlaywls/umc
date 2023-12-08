package umc.spring.base.exception.handler;

import umc.spring.base.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {
    public FoodCategoryHandler(BaseErrorCode errorCode){
        super(errorCode);
    }
}

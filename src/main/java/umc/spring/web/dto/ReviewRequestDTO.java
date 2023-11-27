package umc.spring.web.dto;

import lombok.Getter;

import java.time.LocalDate;

public class ReviewRequestDTO {
    @Getter
    public static class ReviewRegistDto{
        String body;
        Float score;




    }
}

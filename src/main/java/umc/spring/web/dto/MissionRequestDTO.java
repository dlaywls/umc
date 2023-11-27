package umc.spring.web.dto;

import lombok.Getter;

import java.time.LocalDate;

public class MissionRequestDTO {
    @Getter
    public static class MissionRegistDto{
        Integer reward;
        LocalDate deadline;
        String missionSpec;



    }
}

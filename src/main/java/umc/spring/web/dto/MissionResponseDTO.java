package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.validation.annotation.ValidMemberMission;

import java.time.LocalDate;


public class MissionResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionResultDto{
        Long missionId;
        Integer reward;
        LocalDate deadline;
        String missionSpec;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionJoinResultDto{
        Long missionId;
        Long memberId;
        @ValidMemberMission
        Long memberMissionId;
    }


}

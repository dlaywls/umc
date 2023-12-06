package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.validation.annotation.ValidMemberMission;
import umc.spring.web.dto.MemberResponseDTO;
import umc.spring.web.dto.MissionResponseDTO;

import java.time.LocalDateTime;

public class MemberMissionConverter {
    public static MemberMission toMemberMission(Member member, Mission mission){

        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .build();
    }
    public static MissionResponseDTO.MissionJoinResultDto toMemberMissionResultDto(MemberMission memberMission){

        return MissionResponseDTO.MissionJoinResultDto.builder()
                .memberId(memberMission.getMember().getId())
                .missionId(memberMission.getMission().getId())
                .memberMissionId(memberMission.getId())
                .build();
    }
}

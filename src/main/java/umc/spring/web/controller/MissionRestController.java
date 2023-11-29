package umc.spring.web.controller;

import umc.spring.base.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.base.Code;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.MissionService.MissionCommandService;
import umc.spring.validation.annotation.ValidMemberMission;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mission")
public class MissionRestController {
    private final MissionCommandService missionCommandService;

    @PostMapping("/")
    public ResponseDto<MissionResponseDTO.MissionResultDto> regist(@RequestBody @Valid MissionRequestDTO.MissionRegistDto request,
                                                                   @RequestParam Long storeId) {
        Mission mission = missionCommandService.MissionRegist(request, storeId);
        MissionResponseDTO.MissionResultDto resultDto = MissionConverter.toMissionResultDto(mission);
        return ResponseDto.onSuccess(resultDto, Code.OK);
    }

    @PostMapping("/join/{missionId}/")
    public ResponseDto<MissionResponseDTO.MissionResultDto> joinMission(
            @ValidMemberMission(message = "Member is not in the specified mission.")
            @RequestParam Long memberId,
            @PathVariable Long missionId) {
        

        Mission mission = missionCommandService.joinMission(memberId, missionId);

        // 기존 로직에 따라 응답 생성
        MissionResponseDTO.MissionResultDto resultDto = MissionConverter.toMissionResultDto(mission);
        return ResponseDto.onSuccess(resultDto, Code.OK);
    }
}

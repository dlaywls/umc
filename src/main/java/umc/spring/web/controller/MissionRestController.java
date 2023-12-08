package umc.spring.web.controller;

import umc.spring.base.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.MissionService.MissionCommandService;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mission")
public class MissionRestController {
    private final MissionCommandService missionCommandService;

    @PostMapping("/")
    public ApiResponse<MissionResponseDTO.MissionResultDto> regist(@RequestBody @Valid MissionRequestDTO.MissionRegistDto request,
                                                                   @RequestParam Long storeId) {
        Mission mission = missionCommandService.MissionRegist(request, storeId);
        MissionResponseDTO.MissionResultDto resultDto = MissionConverter.toMissionResultDto(mission);
        return ApiResponse.onSuccess(resultDto);
    }

    @PostMapping("/join/{missionId}/")
    public ApiResponse<MissionResponseDTO.MissionJoinResultDto> joinMission(
            @RequestParam Long memberId,
            @PathVariable Long missionId) {


        MemberMission memberMission = missionCommandService.joinMission(memberId, missionId);

        MissionResponseDTO.MissionJoinResultDto resultDto = MemberMissionConverter.toMemberMissionResultDto(memberMission);
        return ApiResponse.onSuccess(resultDto);
    }
}

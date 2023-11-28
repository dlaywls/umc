package umc.spring.service.MissionService;

import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Mission;
import umc.spring.web.dto.MissionRequestDTO;

public interface MissionCommandService {

    @Transactional
    Mission MissionRegist(MissionRequestDTO.MissionRegistDto request, Long storeId);

    Mission joinMission(Long memberId, Long missionId);
}

package umc.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.base.Code;
import umc.spring.base.exception.handler.StoreHandler;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.StoreRepository;
import umc.spring.web.dto.MissionRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public  class MissionCommandServiceImpl implements MissionCommandService{


    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public Mission MissionRegist(MissionRequestDTO.MissionRegistDto request,Long storeId) {

        Store store = storeRepository.findById(storeId)
                .orElseThrow(() ->new StoreHandler(Code.STORE_NOt_FOUND));

        Mission newMission= MissionConverter.toMission(request,store);
        return missionRepository.save(newMission);
    }
}

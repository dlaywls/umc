package umc.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.base.Code.status.ErrorStatus;
import umc.spring.base.exception.handler.MemberHandler;
import umc.spring.base.exception.handler.MissionHandler;
import umc.spring.base.exception.handler.StoreHandler;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.StoreRepository;
import umc.spring.web.dto.MissionRequestDTO;


@Service
@RequiredArgsConstructor
@Transactional
public  class MissionCommandServiceImpl implements MissionCommandService{


    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    @Transactional
    public Mission MissionRegist(MissionRequestDTO.MissionRegistDto request,Long storeId) {

        Store store = storeRepository.findById(storeId)
                .orElseThrow(() ->new StoreHandler(ErrorStatus.STORE_NOt_FOUND));

        Mission newMission= MissionConverter.toMission(request,store);
        return missionRepository.save(newMission);
    }

    public MemberMission joinMission(Long memberId, Long missionId) {

        Member member=memberRepository.findById(memberId)
                .orElseThrow(() ->new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        Mission mission=missionRepository.findById(missionId)
                .orElseThrow(() ->new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        MemberMission memberMission = MemberMissionConverter.toMemberMission(member,mission);


       return memberMissionRepository.save(memberMission);
    }

}

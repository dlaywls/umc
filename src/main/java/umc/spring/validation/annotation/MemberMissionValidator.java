package umc.spring.validation.annotation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


@Component
@RequiredArgsConstructor
public class MemberMissionValidator implements ConstraintValidator<ValidMemberMission,MemberMission>{

    final MemberMissionRepository memberMissionRepository;
    @Override
    public void initialize(ValidMemberMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(MemberMission memberMission, ConstraintValidatorContext context) {
        if (memberMission == null) {
            return true; // 값이 없으면 유효성 검증을 패스하도록 설정
        }
        Long memberId = memberMission.getMember().getId(); // 예시일 뿐, 실제 코드에 맞게 수정 필요
        Long missionId = memberMission.getMission().getId();

        boolean isMemberInMission = memberMissionRepository.existsByMemberIdAndMissionId(memberId, missionId);


        return isMemberInMission;

    }
}

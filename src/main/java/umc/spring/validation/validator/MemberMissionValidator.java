package umc.spring.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.validation.annotation.ValidMemberMission;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


@Component
@RequiredArgsConstructor
public class MemberMissionValidator implements ConstraintValidator<ValidMemberMission, MemberMission>{

    final MemberMissionRepository memberMissionRepository;
    @Override
    public void initialize(ValidMemberMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(MemberMission memberMission, ConstraintValidatorContext context) {

        Long memberId = memberMission.getMember().getId();
        Long missionId = memberMission.getMission().getId();


        boolean isMemberInMission = memberMissionRepository.existsByMemberIdAndMissionId(memberId, missionId);

        if (isMemberInMission) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MEMBERMISSION_ALREADY_EXSISTS.toString()).addConstraintViolation();
        }


        return isMemberInMission;

    }
}

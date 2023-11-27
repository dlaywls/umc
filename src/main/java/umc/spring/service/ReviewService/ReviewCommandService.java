package umc.spring.service.ReviewService;

import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Review;
import umc.spring.web.dto.ReviewRequestDTO;

public interface ReviewCommandService {
    @Transactional
    Review ReviewRegist(ReviewRequestDTO.ReviewRegistDto request, Long memberId, Long storeId);
}

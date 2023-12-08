package umc.spring.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.base.exception.handler.StoreHandler;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.ReviewRepository;
import umc.spring.repository.StoreRepository;
import umc.spring.web.dto.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewCommandServiceImpl implements ReviewCommandService{
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;

    @Override
    @Transactional
    public Review ReviewRegist(ReviewRequestDTO.ReviewRegistDto request, Long memberId, Long storeId) {

        Store store = storeRepository.findById(storeId)
                .orElseThrow(() ->new StoreHandler(ErrorStatus.STORE_NOt_FOUND));

        Member member = memberRepository.findById(storeId)
                .orElseThrow(() ->new StoreHandler(ErrorStatus.MEMBER_NOT_FOUND));

        Review newReview= ReviewConverter.toReview(request,member,store);
        return reviewRepository.save(newReview);
    }
}

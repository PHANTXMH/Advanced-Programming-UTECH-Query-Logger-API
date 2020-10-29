package com.ap.covid19.api.apcovid19.services;

import com.ap.covid19.api.apcovid19.enumerations.Day;
import com.ap.covid19.api.apcovid19.interfaces.LiveChatAvailInt;
import com.ap.covid19.api.apcovid19.models.ApiResponse;
import com.ap.covid19.api.apcovid19.models.LiveChatAvailability;
import com.ap.covid19.api.apcovid19.repositories.LiveChatAvailabilityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class LiveChatAvailabilityService extends BaseServiceHelper implements LiveChatAvailInt {

    private final LiveChatAvailabilityRepository liveChatAvailabilityRepository;

//    public LiveChatAvailabilityService(LiveChatAvailabilityRepository liveChatAvailabilityRepository){
//        this.liveChatAvailabilityRepository = liveChatAvailabilityRepository;
//    }

    @Override
    public ApiResponse createAvailableDays(List<LiveChatAvailability> liveChatAvailabilities) {
        liveChatAvailabilities.forEach(l -> {
            try {
                l.setUser(this.getAuthenticatedUser());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        liveChatAvailabilityRepository.saveAll(liveChatAvailabilities);
        log.info("Creating Live Chat Availability Day");
        return new ApiResponse<>(HttpStatus.CREATED, "Live Chat Availability created", null, null, true);
    }

    @Override
    public ApiResponse deleteAvailableDays(Long id) {
        return null;
    }

    @Override
    public List<LiveChatAvailability> viewAllByStudentRepID(String studentRepID) {
        return null;
    }

    @Override
    public boolean isDayForUserAlreadyExists(Day day, Long userID) {
        return liveChatAvailabilityRepository.findFirstByDayAndUser_Id(day, userID).isPresent();
    }
}

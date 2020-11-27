package com.ap.covid19.api.apcovid19.services;

import com.ap.covid19.api.apcovid19.enumerations.Day;
import com.ap.covid19.api.apcovid19.exceptions.AccessDeniedException;
import com.ap.covid19.api.apcovid19.exceptions.AvailabilityNotFoundException;
import com.ap.covid19.api.apcovid19.interfaces.LiveChatAvailInt;
import com.ap.covid19.api.apcovid19.models.ApiResponse;
import com.ap.covid19.api.apcovid19.models.LiveChatAvailability;
import com.ap.covid19.api.apcovid19.models.LiveChatAvailableTime;
import com.ap.covid19.api.apcovid19.models.User;
import com.ap.covid19.api.apcovid19.repositories.LiveChatAvailabilityRepository;
import com.ap.covid19.api.apcovid19.repositories.LiveChatAvailabilityTimeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class LiveChatAvailabilityService extends BaseServiceHelper implements LiveChatAvailInt {

    private final LiveChatAvailabilityRepository liveChatAvailabilityRepository;

    private final LiveChatAvailabilityTimeRepository liveChatAvailabilityTimeRepository;


    @Override
    public List<ApiResponse<LiveChatAvailability>> createAvailableDays(List<LiveChatAvailability> liveChatAvailabilities) {
        List<ApiResponse<LiveChatAvailability>> apiResponseList = new ArrayList<>();
        liveChatAvailabilities.forEach(l -> {
            try {
                l.setUser(this.getAuthenticatedUser());
                apiResponseList.add(new ApiResponse<>(HttpStatus.CREATED, "Live Chat Availability created", null, l, true));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        liveChatAvailabilityRepository.saveAll(liveChatAvailabilities);
        log.info("Creating Live Chat Availability Day");
        return apiResponseList;
    }

    @Override
    public ApiResponse deleteAvailableDays(final Long id) throws IllegalAccessException {

        User user = getAuthenticatedUser();

        LiveChatAvailability liveChatAvailability = liveChatAvailabilityRepository.findById(id).orElseThrow(() ->
                new AvailabilityNotFoundException(String.format("Availability record not found with ID %s", id)));

        if(!user.getId().equals(liveChatAvailability.getUser().getId()))
            throw new AccessDeniedException("Cannot delete record as it was created by another user");

        liveChatAvailabilityRepository.delete(liveChatAvailability);

        return new ApiResponse<>(HttpStatus.OK, "Availability Session deleted successfully", null, liveChatAvailability, true);

    }

    @Override
    public List<LiveChatAvailability> viewAllByStudentRepID(Long studentRepID) {
        return liveChatAvailabilityRepository.findAllByUser_Id(studentRepID);
    }

    @Override
    public boolean isDayForUserAlreadyExists(Day day, Long userID) {
        return !liveChatAvailabilityRepository.findFirstByDayAndUser_Id(day, userID).isPresent();
    }

    @Override
    public ApiResponse<LiveChatAvailableTime> addAvailableTimeSlot(LiveChatAvailableTime liveChatAvailableTime) {

        liveChatAvailabilityTimeRepository.save(liveChatAvailableTime);

        return new ApiResponse<>(HttpStatus.OK, "Time slot was created successfully", null, liveChatAvailableTime, true);

    }
}

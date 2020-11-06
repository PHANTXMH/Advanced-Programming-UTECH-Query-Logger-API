package com.ap.covid19.api.apcovid19.services;

import com.ap.covid19.api.apcovid19.enumerations.Day;
import com.ap.covid19.api.apcovid19.exceptions.AccessDeniedException;
import com.ap.covid19.api.apcovid19.exceptions.AvailabilityNotFoundException;
import com.ap.covid19.api.apcovid19.interfaces.LiveChatAvailInt;
import com.ap.covid19.api.apcovid19.models.ApiResponse;
import com.ap.covid19.api.apcovid19.models.LiveChatAvailability;
import com.ap.covid19.api.apcovid19.models.User;
import com.ap.covid19.api.apcovid19.repositories.LiveChatAvailabilityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class LiveChatAvailabilityService extends BaseServiceHelper implements LiveChatAvailInt {

    private final LiveChatAvailabilityRepository liveChatAvailabilityRepository;


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
}

package com.ap.covid19.api.apcovid19.services;

import com.ap.covid19.api.apcovid19.enumerations.Day;
import com.ap.covid19.api.apcovid19.exceptions.AccessDeniedException;
import com.ap.covid19.api.apcovid19.exceptions.AvailabilityNotFoundException;
import com.ap.covid19.api.apcovid19.interfaces.LiveChatAvailInt;
import com.ap.covid19.api.apcovid19.models.ApiResponse;
import com.ap.covid19.api.apcovid19.models.LiveChatAvailability;
import com.ap.covid19.api.apcovid19.models.LiveChatAvailableDays;
import com.ap.covid19.api.apcovid19.models.User;
import com.ap.covid19.api.apcovid19.repositories.LiveChatAvailabilityDaysRepository;
import com.ap.covid19.api.apcovid19.repositories.LiveChatAvailabilityRepository;
import com.ap.covid19.api.apcovid19.repositories.LiveChatAvailabilityDaysRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class LiveChatAvailabilityService extends BaseServiceHelper implements LiveChatAvailInt {

    private final LiveChatAvailabilityRepository liveChatAvailabilityRepository;

    private final LiveChatAvailabilityDaysRepository liveChatAvailabilityDaysRepository;


    @Override
    public ApiResponse<LiveChatAvailability> createAvailableDays(LiveChatAvailability liveChatAvailability) throws IllegalAccessException {

        String successMessage = "Availability Session created successfully";

        User user = getAuthenticatedUser();

        liveChatAvailability.setUser(user);

        LiveChatAvailability liveChatAvailabilityForUser = liveChatAvailabilityRepository.findByUser_Id(user.getId());

        if(liveChatAvailabilityForUser != null){
            //liveChatAvailability.setId(liveChatAvailabilityForUser.getId());
            liveChatAvailabilityRepository.delete(liveChatAvailabilityForUser);
            /*
            log.info("Finish removing data");
            List<LiveChatAvailableDays> liveChatAvailableDays = new ArrayList<>();
            if(!CollectionUtils.isEmpty(liveChatAvailabilityForUser.getLiveChatAvailableDays())){
                liveChatAvailabilityForUser.getLiveChatAvailableDays().forEach(l -> {
                    boolean dayAlreadyExists = Boolean.FALSE;
                    if(!CollectionUtils.isEmpty(liveChatAvailability.getLiveChatAvailableDays())){
                        for(LiveChatAvailableDays day: liveChatAvailability.getLiveChatAvailableDays()){
                            if(day.getDay().equals(l.getDay())) {
                                dayAlreadyExists = Boolean.TRUE;
                                break;
                            }

                        }
                    }
                    if(!dayAlreadyExists)
                        liveChatAvailableDays.add(l);
                });
                liveChatAvailability.setLiveChatAvailableDays(liveChatAvailableDays);
            }
            */
            successMessage = "Availability Session was updated successfully";
        }


        liveChatAvailabilityRepository.save(liveChatAvailability);
        log.info("Creating Live Chat Availability Day");
        return new ApiResponse<>(successMessage.equals("Availability Session was updated successfully") ? HttpStatus.OK : HttpStatus.CREATED, successMessage, null, liveChatAvailability, true);
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
    public LiveChatAvailability viewAllByStudentRepID(Long studentRepID) {
        return liveChatAvailabilityRepository.findByUser_Id(studentRepID);
    }

    @Override
    public boolean isDayForUserAlreadyExists(Day day, Long userID) {
        return false;//!liveChatAvailabilityRepository.findFirstByDayAndUser_Id(day, userID).isPresent();
    }

    @Override
    public ApiResponse<LiveChatAvailableDays> addAvailableTimeSlot(LiveChatAvailableDays liveChatAvailableTime) {

        liveChatAvailabilityDaysRepository.save(liveChatAvailableTime);

        return new ApiResponse<>(HttpStatus.OK, "Time slot was created successfully", null, liveChatAvailableTime, true);

    }
}

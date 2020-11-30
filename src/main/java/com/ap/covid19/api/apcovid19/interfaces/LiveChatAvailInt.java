package com.ap.covid19.api.apcovid19.interfaces;

import com.ap.covid19.api.apcovid19.enumerations.Day;
import com.ap.covid19.api.apcovid19.models.ApiResponse;
import com.ap.covid19.api.apcovid19.models.LiveChatAvailability;
import com.ap.covid19.api.apcovid19.models.LiveChatAvailableDays;

public interface LiveChatAvailInt {

    ApiResponse<LiveChatAvailability> createAvailableDays(LiveChatAvailability liveChatAvailability) throws IllegalAccessException;

    ApiResponse deleteAvailableDays(final Long id) throws IllegalAccessException;

    LiveChatAvailability viewAllByStudentRepID(Long studentRepID);

    boolean isDayForUserAlreadyExists(Day day, Long userID);

    ApiResponse<LiveChatAvailableDays> addAvailableTimeSlot(LiveChatAvailableDays liveChatAvailableTime);

}

package com.ap.covid19.api.apcovid19.interfaces;

import com.ap.covid19.api.apcovid19.enumerations.Day;
import com.ap.covid19.api.apcovid19.models.ApiResponse;
import com.ap.covid19.api.apcovid19.models.LiveChatAvailability;
import com.ap.covid19.api.apcovid19.models.LiveChatAvailableTime;

import java.util.List;

public interface LiveChatAvailInt {

    List<ApiResponse<LiveChatAvailability>> createAvailableDays(List<LiveChatAvailability> liveChatAvailabilities);

    ApiResponse deleteAvailableDays(final Long id) throws IllegalAccessException;

    List<LiveChatAvailability> viewAllByStudentRepID(Long studentRepID);

    boolean isDayForUserAlreadyExists(Day day, Long userID);

    ApiResponse<LiveChatAvailableTime> addAvailableTimeSlot(LiveChatAvailableTime liveChatAvailableTime);

}

package com.ap.covid19.api.apcovid19.models;

import lombok.*;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
public class LiveChatMessage {
    private String name;
    private String message;
    private Long from;
    private Long to;
}

package com.ap.covid19.api.apcovid19;

import com.ap.covid19.api.apcovid19.exceptions.ComplaintNotFoundException;
import com.ap.covid19.api.apcovid19.models.Complaints;
import com.ap.covid19.api.apcovid19.models.Services;
import com.ap.covid19.api.apcovid19.models.User;
import com.ap.covid19.api.apcovid19.repositories.ComplaintsRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Apcovid19ApplicationTests {

    @Autowired
    private ComplaintsRepository complaintsRepository;

    @Test
    void readDecryptedComplaints(){
        Complaints complaints = new Complaints();
        complaints.setServices(new Services(1L));
        complaints.setCreatedUser(new User(1L, "ricardogaynor@gmail.com"));
        complaints.setQuery("My debit card was used to charge my bank acct for $46.95 on 9/14/2020. I did not authorize this payment");
        complaintsRepository.save(complaints);

        Complaints complaintsSaved = complaintsRepository.findById(complaints.getId()).orElseThrow(() ->
                new ComplaintNotFoundException(String.format("Complaints with ID %s not found", complaints.getId())));

        Assertions.assertEquals(complaints.getQuery(), complaintsSaved.getQuery());
    }

    @Test
    void contextLoads() {
    }

}

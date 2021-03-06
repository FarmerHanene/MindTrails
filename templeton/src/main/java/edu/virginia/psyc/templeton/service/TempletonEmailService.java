package edu.virginia.psyc.templeton.service;

import edu.virginia.psyc.templeton.domain.TempletonStudy;
import org.mindtrails.domain.Email;
import org.mindtrails.domain.Participant;
import org.mindtrails.domain.Session;
import org.mindtrails.service.EmailService;
import org.mindtrails.service.EmailServiceImpl;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

import java.util.List;

/**
 * A basic email service that behcaves exactly like the core configuration,
 * sending email reminders each day at 2 am and providing endpoints for
 * dealing with standard email messages such as resetting passwords.
 */
@Service
public class TempletonEmailService extends EmailServiceImpl implements EmailService{
    private String FIRST_SESSION = "SESSION1";
    private String SECOND_SESSION = "SESSION2";
    private String THIRD_SESSION = "SESSION3";
    private String FOURTH_SESSION = "SESSION4";

    @Override
    public List<Email> emailTypes() {
        List<Email> emails = super.emailTypes();
        emails.add(new Email(FIRST_SESSION, "Bonus feature from the MindTrails team"));
        emails.add(new Email(SECOND_SESSION, "Bonus feature from the MindTrails team"));
        emails.add(new Email(THIRD_SESSION, "Bonus feature from the MindTrails team"));
        emails.add(new Email(FOURTH_SESSION, "Bonus feature from the MindTrails team"));
        return emails;
    }

    @Override
    public void sendSessionCompletedEmail(Participant participant) {
        Session currentSession = participant.getStudy().getCurrentSession();
        Email email = null;
        if (currentSession.getName().equals(TempletonStudy.FIRST_SESSION.toString())) {
            email = new Email("SESSION1","Bonus feature from the MindTrails team");
        } else if (currentSession.getName().equals(TempletonStudy.SECOND_SESSION.toString())) {
            email = new Email("SESSION2","Bonus feature from the MindTrails team");
        } else if (currentSession.getName().equals(TempletonStudy.THIRD_SESSION.toString())) {
            email = new Email("SESSION3","Bonus feature from the MindTrails team");
        } else if (currentSession.getName().equals(TempletonStudy.FOURTH_SESSION.toString())) {
            email = new Email("SESSION4","Bonus feature from the MindTrails team");
        }
        if (email != null) {
            email.setTo(participant.getEmail());
            email.setParticipant(participant);
            email.setContext(new Context());
            sendEmail(email);
        }
    }
}

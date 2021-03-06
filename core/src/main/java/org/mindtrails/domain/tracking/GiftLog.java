package org.mindtrails.domain.tracking;

import com.fasterxml.jackson.annotation.*;
import org.mindtrails.domain.DoNotDelete;
import org.mindtrails.domain.Exportable;
import org.mindtrails.domain.Participant;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * User: dan
 * Date: 7/24/14
 * Time: 9:33 AM
 * Logs the date and time a particular gift card was awarded.
 */
@Entity
@Table(name="gift_log")
@Exportable
@DoNotDelete
@Data
public class GiftLog implements Comparable<GiftLog> {

    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("participantId")
    private Participant participant;
    private String orderId;
    private String sessionName;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="EEE, dd MMM yyyy HH:mm:ss Z", timezone="EST")
    private Date dateSent;

    public GiftLog() {};

    public GiftLog(Participant participant, String orderId, String sessionName) {
        this.participant = participant;
        this.orderId = orderId;
        this.sessionName = sessionName;
        this.dateSent = new Date();
    }

    @Override
    public int compareTo(GiftLog o) {
        if(this.dateSent == null) return 0;
        return this.dateSent.compareTo(o.dateSent);
    }
}

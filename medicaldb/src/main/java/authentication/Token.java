package authentication;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by inkys_000 on 3/25/2017.
 */
@Entity
@Table(name = "tokens")
public class Token {
    @Id
    @Column(name = "token", nullable = false)
    private String Token;

    @Column(name = "end_time")
    private Date EndTime;

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public Date getEndTime() {
        return EndTime;
    }

    public void setEndTime(Date endTime) {
        EndTime = endTime;
    }
}

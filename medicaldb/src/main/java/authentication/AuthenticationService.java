package authentication;

import org.hibernate.PropertyAccessException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

/**
 * Created by inkys_000 on 3/25/2017.
 */
public class AuthenticationService {
    Session database;
    public AuthenticationService(Session session) {
        database = session;
    }

    /**
     * Registers a user into a database.
     * @param user The user to be registered. The ID will be reassigned.
     * @return The newly created UUID for the user.
     */
    public String register(User user) {
        Transaction t = database.beginTransaction();
        String uuid = UUID.randomUUID().toString();
        user.setId(uuid);
        try {
            database.persist(user);
            t.commit();
            return uuid;
        } catch (PropertyAccessException e) {
            return null;
        }
    }

    public String getId(String username) {
        Query query = database.createQuery("select u from User u where UserName=:username");
        query.setParameter("username", username);
        List list = query.list();
        if (list.size() == 0)
            return null;
        return ((User) list.get(0)).getId();
    }

    public byte[] getSalt(String username) {
        Query query = database.createQuery("select u from User u where UserName=:username");
        query.setParameter("username", username);
        List list = query.list();
        if (list.size() == 0)
            return null;
        return ((User) list.get(0)).getPasswordSalt();
    }

    public String login(String username, byte[] password) {
        Query query = database.createQuery("select u from User u where UserName=:username and PasswordHash=:password");
        query.setParameter("username", username);
        query.setParameter("password", password);
        List list = query.list();
        if (list.size() == 0)
            return null;
        User user = (User) list.get(0);
        String uuid = UUID.randomUUID().toString();
        Token token = new Token();
        token.setToken(uuid);
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 1);
        token.setEndTime(c.getTime());
        user.getTokenList().add(token);

        Transaction transaction = database.beginTransaction();
        database.saveOrUpdate(user);
        database.saveOrUpdate(token);
        transaction.commit();
        return uuid;
    }

    public boolean verifyLogin(String username, String token) {
        Query query = database.createQuery("select s from Token s where UserName=:username AND Token=:token");
        query.setParameter("username", username);
        query.setParameter("token", token);
        List list = query.list();
        if (list.size() == 0)
            return false;
        Token t = (Token) list.get(0);
        if (t.getEndTime().after(Calendar.getInstance().getTime())) {
            database.remove(t);
            return false;
        }
        return true;
    }
}

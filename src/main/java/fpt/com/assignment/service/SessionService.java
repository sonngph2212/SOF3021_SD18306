package fpt.com.assignment.service;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService {

    @Autowired
    HttpSession session;

    public <T> T getSession(String name) {
        return (T) session.getAttribute(name);
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public void removedAttribute(String name) {
        session.removeAttribute(name);
    }
}

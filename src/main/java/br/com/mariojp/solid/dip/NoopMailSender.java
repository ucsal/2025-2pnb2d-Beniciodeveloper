package br.com.mariojp.solid.dip;

public class NoopMailSender implements MailSender {
    @Override
    public void send(String to, String subject, String body) {
        // No-op implementation for DRY_RUN mode
        // Does nothing, avoiding real SMTP usage
    }
}

package br.com.mariojp.solid.dip;

public class EmailNotifier {
	private final MailSender mailSender;

	public EmailNotifier() {
		this.mailSender = createMailSender();
	}

	public EmailNotifier(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	private MailSender createMailSender() {
		if ("true".equalsIgnoreCase(System.getProperty("DRY_RUN"))) {
			return new NoopMailSender();
		}
		return new SmtpMailSender(new SmtpClient());
	}

	public void welcome(User user) {
		mailSender.send(user.email(), "Bem-vindo", "Olá " + user.name());
	}
}

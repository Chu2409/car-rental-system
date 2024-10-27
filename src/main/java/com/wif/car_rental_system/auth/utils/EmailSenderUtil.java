package com.wif.car_rental_system.auth.utils;

import java.nio.charset.StandardCharsets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.java.Log;

@Component
@Log
public class EmailSenderUtil {
  @Autowired
  private JavaMailSender mailSender;

  @Async
  public void sendEmail(
      String to, String token) {

    MimeMessage mensaje = mailSender.createMimeMessage();
    MimeMessageHelper helper;
    try {
      helper = new MimeMessageHelper(mensaje, true, StandardCharsets.UTF_8.name());
      helper.setTo(to);
      helper.setSubject("Token de recuperación de contraseña");
      helper.setText(
          "<html><body><h1>Token de recuperación de contraseña</h1><p>Estimado usuario,</p><p>A continunación encontrará el token de recuperación de contraseñá.</p><p>Puede responder este correo por cualquier duda.</p><p>WIF</p><p><strong>Token:</strong> "
              + token + "</p></body></html>",
          true);

      mailSender.send(mensaje);
    } catch (MessagingException e) {
      log.warning("An error occurred while sending the email: " + e.getMessage());
    }
  }
}

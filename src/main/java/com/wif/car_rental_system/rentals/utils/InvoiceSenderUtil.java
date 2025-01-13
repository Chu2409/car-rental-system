package com.wif.car_rental_system.rentals.utils;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.wif.car_rental_system.rentals.domain.entities.RentalEntity;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.java.Log;

@Component
@Log
public class InvoiceSenderUtil {
    
  @Autowired
  private JavaMailSender mailSender;

  @Async
  public void sendInvoiceEmail(String to, RentalEntity rental) {
    MimeMessage message = mailSender.createMimeMessage();
    MimeMessageHelper helper;
    try {
      helper = new MimeMessageHelper(message, true, StandardCharsets.UTF_8.name());
      helper.setTo(to);
      helper.setSubject("Factura de Alquiler #" + rental.getId());
      helper.setText(generateInvoiceContent(rental), true);

      mailSender.send(message);
    } catch (MessagingException e) {
      log.warning("An error occurred while sending the invoice email: " + e.getMessage());
    }
  }

  private String generateInvoiceContent(RentalEntity rental) {
    return String.format(
        "<html><body style='font-family: Arial, sans-serif; margin: 0; padding: 0; background-color: #f4f4f9;'>"
        + "<div style='max-width: 600px; margin: 50px auto; background-color: #ffffff; padding: 20px; border-radius: 8px; box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);'>"
        + "<h1 style='text-align: center; color: #4CAF50;'>Factura de Alquiler #%d</h1>"
        + "<div style='border-top: 2px solid #4CAF50; border-bottom: 2px solid #4CAF50; padding: 20px 0;'>"
        + "<p style='font-size: 16px; color: #555555;'><strong>Cliente:</strong> %s %s</p>"
        + "<p style='font-size: 16px; color: #555555;'><strong>Auto:</strong> %s %s (%s)</p>"
        + "<p style='font-size: 16px; color: #555555;'><strong>Placa:</strong> %s</p>"
        + "<p style='font-size: 16px; color: #555555;'><strong>Año:</strong> %d</p>"
        + "<p style='font-size: 16px; color: #555555;'><strong>Color:</strong> %s</p>"
        + "<p style='font-size: 16px; color: #555555;'><strong>Total:</strong> $%.2f</p>"
        + "<p style='font-size: 16px; color: #555555;'><strong>Fecha de inicio:</strong> %s</p>"
        + "<p style='font-size: 16px; color: #555555;'><strong>Fecha de fin:</strong> %s</p>"
        + "</div>"
        + "<div style='text-align: center; padding-top: 20px;'>"
        + "<p style='font-size: 14px; color: #777777;'>Gracias por confiar en nuestro servicio.</p>"
        + "</div>"
        + "</div>"
        + "</body></html>",
        
        rental.getId(),
        rental.getUser().getName(),
        rental.getUser().getLastName(),
        
        rental.getCar().getBrand(),
        rental.getCar().getModel(),
        rental.getCar().getType(),
        
        rental.getCar().getPlate(),
        rental.getCar().getYear(),
        rental.getCar().getColor(),
        
        rental.getTotal(),
        rental.getStartDate(),
        rental.getEndDate()
    );
  }



}

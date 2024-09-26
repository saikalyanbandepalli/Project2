package org.revature.RevTaskManagement.service;

import org.revature.RevTaskManagement.models.Otp;
import org.revature.RevTaskManagement.repository.OtpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class OtpService {

    @Autowired
    private OtpRepository otpRepository;

    public String generateOtp() {
        return String.valueOf(new Random().nextInt(900000) + 100000);
    }

    public void saveOtpForUser(int userId, String otp) {
        Otp otpEntity = new Otp (userId, otp);
        otpRepository.deleteAll();
        otpRepository.save(otpEntity);
    }

    public boolean validateOtpForUser(int userId, String otp) {
        Otp otpEntity = otpRepository.findByUserId(userId);
        return otpEntity != null && otpEntity.getOtp().equals(otp);
    }

    public void invalidateOtpForUser(int userId) {
        Otp otpEntity = otpRepository.findByUserId(userId);
        if (otpEntity != null) {
            otpRepository.delete(otpEntity);
        }
    }
}
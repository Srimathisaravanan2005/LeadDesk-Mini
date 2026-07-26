package com.leaddesk.demo.Controller;


import com.leaddesk.demo.model.Admin;
import com.leaddesk.demo.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SetupController {

    @Autowired
    private AdminRepository adminRepository;

    @GetMapping("/")
    public String health() {
        return "LeadDesk Backend is running!";
    }

    @GetMapping("/setup-admin")
    public String setupAdmin() {

        if (adminRepository.findByEmail("admin@gmail.com").isEmpty()) {

            Admin admin = new Admin();
            admin.setEmail("admin@gmail.com");
            admin.setPassword("admin123");

            adminRepository.save(admin);

            return "Admin created!";
        }

        return "Admin already exists!";
    }
}
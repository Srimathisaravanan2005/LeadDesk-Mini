package com.leaddesk.demo.Controller;

import com.leaddesk.demo.model.Lead;
import com.leaddesk.demo.service.LeadService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leads")
@CrossOrigin(origins = "*")

public class LeadController {

    private final LeadService service;

    public LeadController(LeadService service) {
        this.service = service;
    }

    @PostMapping
    public Lead createLead(@Valid @RequestBody Lead lead) {
        return service.saveLead(lead);
    }

    @GetMapping
    public List<Lead> getAllLeads() {
        return service.getAllLeads();
    }

    @GetMapping("/search")
    public List<Lead> search(@RequestParam String name) {
        return service.searchByName(name);
    }

    @PutMapping("/{id}")
    public Lead updateStatus(@PathVariable String id,
                             @RequestParam String status) {

        return service.updateStatus(id, status);
    }
}
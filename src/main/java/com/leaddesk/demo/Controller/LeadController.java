package com.leaddesk.demo.Controller;

import com.leaddesk.demo.model.Lead;
import com.leaddesk.demo.service.LeadService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/leads")
@CrossOrigin(origins = {"https://leaddesk-frontenddh.vercel.app", "http://localhost:5173", "http://localhost:5174"})
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
    public Lead updateStatus(@PathVariable String id, @RequestBody Map<String, String> body) {
        return service.updateStatus(id, body.get("status"));
    }
}

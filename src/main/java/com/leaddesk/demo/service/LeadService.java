package com.leaddesk.demo.service;

import com.leaddesk.demo.model.Lead;
import com.leaddesk.demo.repository.LeadRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeadService {

    private final LeadRepository repository;

    public LeadService(LeadRepository repository) {
        this.repository = repository;
    }

    public Lead saveLead(Lead lead) {
        return repository.save(lead);
    }

    public List<Lead> getAllLeads() {
        return repository.findAll();
    }

    public List<Lead> searchByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    public Lead updateStatus(String id, String status) {

        Lead lead = repository.findById(id).orElseThrow();

        lead.setStatus(status);

        return repository.save(lead);
    }
}
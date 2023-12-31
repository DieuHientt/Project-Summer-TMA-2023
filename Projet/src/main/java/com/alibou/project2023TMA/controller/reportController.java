package com.alibou.project2023TMA.controller;

import com.alibou.project2023TMA.Application;
import com.alibou.project2023TMA.entity.report;
import com.alibou.project2023TMA.service.reportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/report")
public class reportController  {
    @Autowired
    private reportService reportService;
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    //Find All Report
    @GetMapping
    @PreAuthorize("hasRole('client_admin')")
    public ResponseEntity<List<report>> findAllReport() {
        logger.info("Find All Report Success");
        return ResponseEntity.ok(reportService.getAllReport());
    }
    //Find Report By ID
    @GetMapping("/{reportId}")
    @PreAuthorize("hasAnyRole('client_user', 'client_admin')")
    public ResponseEntity<report> getReport(@PathVariable BigInteger reportId) {
        logger.info("Find Report Success");
        return ResponseEntity.ok((report) reportService.getReport(reportId));
    }
    //Create New Report
    @PostMapping
    @PreAuthorize("hasRole('client_admin')")
    public ResponseEntity<report> saveReport(report report) {
        report savedReport = reportService.saveReport(report);
        logger.info("Create Report Success");
        return ResponseEntity.ok(savedReport);
    }
    //Delete Report
    @GetMapping("/not-deleted")
    @PreAuthorize("hasRole('client_admin')")
    public ResponseEntity<List<report>> getReportNotDeleted() {
        List<report> notDeletedReport = reportService.getReportNotDeleted();
        logger.info("Delete Report Success");
        return ResponseEntity.ok(notDeletedReport);
    }
    //Update Report By ID
    @PutMapping("/{reportId}")
    @PreAuthorize("hasRole('client_admin')")
    public ResponseEntity<report> updateReport(@PathVariable BigInteger reportId, @RequestParam Map<String, String> formData) {
        report updatedReportResult  = reportService.updateReport(reportId, formData);
        if (updatedReportResult != null) {
            logger.info("Update Report Success");
            return ResponseEntity.ok(updatedReportResult);
        } else {
            logger.error("Can Find Report Update");
            return ResponseEntity.notFound().build();
        }
    }

}
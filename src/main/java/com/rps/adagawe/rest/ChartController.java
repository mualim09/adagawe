package com.rps.adagawe.rest;

import com.rps.adagawe.helper.AdagaweMethods;
import com.rps.adagawe.helper.AdagaweService;
import com.rps.adagawe.model.JenisPegawai;
import com.rps.adagawe.model.Lowongan;
import com.rps.adagawe.model.VerifikasiPerusahaan;
import com.rps.adagawe.service.JenisPegawaiService;
import com.rps.adagawe.service.LowonganService;
import com.rps.adagawe.service.VerifikasiPerusahaanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@RestController
public class ChartController {

    @Autowired
    VerifikasiPerusahaanService verifikasiPerusahaanService;

    @Autowired
    LowonganService lowonganService;

    @Autowired
    JenisPegawaiService jenisPegawaiService;

    @Autowired
    AdagaweService adagaweService;

    @GetMapping("/api/admin/chart-verifikasi")
    public ResponseEntity<Map<String, Integer>> getBarChartVerifikasi() {
        Map<String, Integer> graphData = AdagaweMethods.getBarChartVerifikasi(verifikasiPerusahaanService);

        return new ResponseEntity<>(graphData, HttpStatus.OK);
    }

    @GetMapping("/api/admin/chart-jenispegawai")
    public ResponseEntity<Map<String, Integer>> getBarChartJenisPegawai() {
        Map<String, Integer> graphData = AdagaweMethods.getBarChartJenisPegawai(jenisPegawaiService, lowonganService);

        return new ResponseEntity<>(graphData, HttpStatus.OK);
    }

    @GetMapping("/api/perusahaan/chart-jenispegawai")
    public ResponseEntity<Map<String, Integer>> getBarChart() {
        int id = AdagaweMethods.getPerusahaanBySession(adagaweService).getId();
        Map<String, Integer> graphData = AdagaweMethods.getBarChartJenisPegawaiByPerusahaan(jenisPegawaiService, lowonganService, id);

        return new ResponseEntity<>(graphData, HttpStatus.OK);
    }
}

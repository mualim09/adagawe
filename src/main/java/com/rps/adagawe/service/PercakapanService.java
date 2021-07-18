package com.rps.adagawe.service;

import com.rps.adagawe.model.Percakapan;
import com.rps.adagawe.repository.PercakapanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PercakapanService {

    @Autowired
    PercakapanRepository percakapanRepository;

    public List<Percakapan> getPercakapanByPesan(int id) {
        return percakapanRepository.findPercakapanByPesan(id);
    }
}

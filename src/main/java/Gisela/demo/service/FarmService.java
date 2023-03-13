package Gisela.demo.service;
import Gisela.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import Gisela.demo.repository.iFarmRepository;

import java.util.List;
@Service
public class FarmService {

    @Autowired
    private iFarmRepository iFarmRepository;
    public Page<Farm> getAllData(Integer page, Integer size, Boolean enabledPagination) {
        return iFarmRepository.findAll(enabledPagination ? PageRequest.of(page, size) : Pageable.unpaged());
    }

    public List<Farm> findProductNm() {
        return iFarmRepository.findProductNm();

    }

}

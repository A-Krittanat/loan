package com.digitalacademy.loan.service;

import com.digitalacademy.loan.constants.LoanError;
import com.digitalacademy.loan.controller.LoanController;
import com.digitalacademy.loan.exception.LoanException;
import com.digitalacademy.loan.model.LoanInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
public class LoanService {
    private static final Logger log = LogManager.getLogger
            (LoanController.class.getName());

    public LoanInfo getLoanInfoById(Long id) throws Exception {
        log.info("Get info by id: {}", id);

        LoanInfo loanInfo = new LoanInfo();
        if(id.equals(1L)) {
            loanInfo.setId(1L);
            loanInfo.setStatus("OK");
            loanInfo.setAccountPayable("102-220-2200");
            loanInfo.setAccountReceivable("102-210-2020");
            loanInfo.setPrincipalAmount(3200.00);
        } else if(id.equals(2L)) {
            log.info("id: {}", id);
            throw new LoanException(
                    LoanError.GET_LOAN_INFO_NOT_FOUND,
                    HttpStatus.BAD_REQUEST
            );
        } else {
            log.info("id: {}", id);
            throw new Exception("Test throw new exception");
        }

        return loanInfo;
    }
}

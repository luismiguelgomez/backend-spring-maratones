package com.co.unbosque.tecnomaraton.service;

import com.co.unbosque.tecnomaraton.dao.UserDao;
import com.co.unbosque.tecnomaraton.models.User;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.logging.Logger;

@Service
public class CsvExportService {
    private static final Logger log = Logger.getLogger(String.valueOf(CsvExportService.class));
    private final UserDao userDao;

    public CsvExportService(UserDao userDao) {
        this.userDao = userDao;
    }


    public void writeEmployeesToCsv(Writer writer) {

        List<User> users = userDao.getUsersInOrder();
        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            for (User user : users) {
                csvPrinter.printRecord(user.getUserId(), user.getName(), user.getEmail(), user.getProgrammingLanguaje(),user.getTeam().getTeamName(),user.getFechaCreacion());
            }
        } catch (IOException e) {
            log.warning(e+"Error While writing CSV ");
        }
    }

}

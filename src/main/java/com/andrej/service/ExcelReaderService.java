package com.andrej.service;

import com.github.pjfanning.xlsx.StreamingReader;
import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class ExcelReaderService {

    private static final Logger logger = LoggerFactory.getLogger(ExcelReaderService.class);

    public List<Long> readNumbers(File inputFile) {
        List<Long> numbers = new ArrayList<>();
        if (inputFile == null) return numbers;

        try (Workbook workbook = StreamingReader.builder()
            .rowCacheSize(100)
            .bufferSize(4096)
            .open(inputFile)) {

            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue;

                Cell cell = row.getCell(1);
                if (cell == null) continue;

                try {
                    double val = cell.getNumericCellValue();

                    if (val > 0 && val == (long) val) {
                        numbers.add((long) val);
                    }
                } catch (Exception e) {
                    //invalid cell value, ignore
                }
            }

        } catch (Exception e) {
            logger.error("Error during streaming excel file", e);
        }

        return numbers;
    }
}
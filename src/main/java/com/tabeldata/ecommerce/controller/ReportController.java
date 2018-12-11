package com.tabeldata.ecommerce.controller;

import com.tabeldata.ecommerce.entity.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

@Controller
@RequestMapping("/report")
public class ReportController {

    @GetMapping("/ecommerce")
    public void exampleReport(HttpServletResponse response) throws JRException, IOException {
        InputStream jasperStream = this.getClass().getResourceAsStream("/jasper/report_ecommerce.jasper");
        Map<String, Object> params = new HashMap<>();

        Pembeli pembeli = new Pembeli(
                "001",
                "Yuda",
                "0822xxx",
                "Sadang Serang",
                "yuda@email.com");

        params.put("pembeli", pembeli);
        List<Pembeli> dataList = Arrays.asList(pembeli);

        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JRBeanCollectionDataSource(dataList));
        response.setContentType("application/x-pdf");
        response.setHeader("Content-disposition", "inline; filename=example.pdf");

        final OutputStream outStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
    }
}

package com.postulacion.app.controller.cliente;

import com.postulacion.app.dto.cliente.ReporteTransaccionesCliente;
import com.postulacion.app.service.cliente.ReporteClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/v1/clientes")
public class ReporteCSVClienteController {

    @Autowired
    private ReporteClienteService reporteTiendaService;

    @GetMapping(value="/reporte-transacciones/{id}", produces = "text/csv")
    public void generarReporteTransaccionesTienda(HttpServletResponse response, @PathVariable("id") Long id, @RequestParam(value = "fechaInicio", required = true) String fechaInicio, @RequestParam(value = "fechaFin", required = true) String fechaFin) throws IOException {
        List<ReporteTransaccionesCliente> reporteTransaccionesCliente = reporteTiendaService.reporteTransaccionesCliente(id, fechaInicio, fechaFin);
        response.setContentType("text/csv");
        String filename = "reporte-transacciones-cliente.csv";
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", filename);
        response.setHeader(headerKey, headerValue);

        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.EXCEL_NORTH_EUROPE_PREFERENCE);

        String[] csvHeader = {"fecha", "monto"};
        String[] nameMapping = {"fecha","monto"};

        csvWriter.writeHeader(csvHeader);

        for (ReporteTransaccionesCliente transaccion : reporteTransaccionesCliente) {
            csvWriter.write(transaccion, nameMapping);
        }
        csvWriter.close();

    }
}

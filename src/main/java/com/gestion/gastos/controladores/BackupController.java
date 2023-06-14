package com.gestion.gastos.controladores;

import com.gestion.gastos.util.Utilidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

@RestController
@RequestMapping("/backup")
@CrossOrigin("*")
public class BackupController {

    @Autowired
    private Utilidades utilidades;

    @GetMapping("/")
    public void backupDatabase(HttpServletResponse response) throws IOException {
        String dbName = "gestion_gastos";
        String dbUser = "root";
        String dbPassword = "";

        String command = "mysqldump --user=" + dbUser + " --password=" + dbPassword + " " + dbName;
        Process process = Runtime.getRuntime().exec(command);

        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=\"backup.sql\"");

        try (InputStream inputStream = process.getInputStream();
             OutputStream outputStream = response.getOutputStream()) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }

        int exitCode;
        try {
            exitCode = process.waitFor();
        } catch (InterruptedException e) {
            utilidades.agregarAuditoria("backupDatabase", "Problema al generar backup", true);
            throw new IOException("Error al generar el backup", e);
        }

        if (exitCode != 0) {
            utilidades.agregarAuditoria("backupDatabase", "Problema al generar backup", true);
            throw new IOException("Error al generar el backup. Código de salida: " + exitCode);
        }
        utilidades.agregarAuditoria("backupDatabase", "Backup generado " + new Date(), false);
    }
}

package mx.badak.eva.api.csv;

import mx.badak.eva.api.model.Person;
import mx.badak.eva.api.serviceImpl.PersonServiceImpl;
import org.apache.commons.csv.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVHelper2 {
    static Person person;
    @Autowired
    static PersonServiceImpl personService;
    public static String TYPE = "text/csv";
    static String[] HEADERs = {"Name", "LastName", "MotherLastName", "Email", "Company"};
    public static boolean hasCSVFormat(MultipartFile file) {
        if (TYPE.equals(file.getContentType())
                || file.getContentType().equals("application/vnd.ms-excel")) {
            return true;
        }

        return false;
    }
    public static List<Person> csvToTutorials(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<Person> personaList = new ArrayList<>();
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                Person persona = new Person(
                        csvRecord.get("Name"),
                        csvRecord.get("LastName"),
                        csvRecord.get("MotherLastName"),
                        csvRecord.get("Email"),
                        csvRecord.get("Company")
                        );
                personaList.add(persona);
                // personService.usersCSVToBD(persona);
            }
            return personaList;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }


    public static ByteArrayInputStream tutorialsToCSV(List<Person> personaList) {
        final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {

            for (Person persona : personaList ) {
                List<String> data = Arrays.asList(
                        String.valueOf(persona.getIdPerson()),
                        persona.getName(),
                        persona.getLastName(),
                        persona.getMotherLastName(),
                        persona.getEmail(),
                        persona.getCompanyName()
                );
                csvPrinter.printRecord(data);
                }
            csvPrinter.flush();
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
        }
    }
}
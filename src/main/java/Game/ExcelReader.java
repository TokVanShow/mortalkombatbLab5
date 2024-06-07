package Game;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс для чтения и записи результатов в Excel файл.
 */
public class ExcelReader {

    private static final List<Result> results = loadResults();
    private static final String RESOURCE_PATH = "/Results.xlsx";
    private static final String FILE_PATH = "Results.xlsx";

    /**
     * Получает список результатов из Excel файла.
     *
     * @return список результатов
     */
    public static List<Result> getResults() {
        return results;
    }

    /**
     * Метод, записывающий в Excel файл отсортированные по убыванию результаты.
     *
     * @param results отсортированная коллекция из объектов Result, включающих в себя имя и очки игрока
     * @throws IOException вызывается при невозможности найти или записать Excel файл
     */
    public static void writeToExcel(List<Result> results) throws IOException {
        XSSFWorkbook book;
        XSSFSheet sheet;

        // Проверка, существует ли локальный файл, если нет, то копирование из ресурсов
        File localFile = new File(FILE_PATH);
        if (!localFile.exists()) {
            try (InputStream in = ExcelReader.class.getResourceAsStream(RESOURCE_PATH)) {
                if (in == null) {
                    throw new FileNotFoundException("Resource file not found: " + RESOURCE_PATH);
                }
                Files.copy(in, Paths.get(FILE_PATH));
            }
        }

        // Открытие книги и листа
        try (InputStream in = new FileInputStream(localFile)) {
            book = new XSSFWorkbook(in);
        }
        sheet = book.getSheet("Результаты ТОП 10");
        if (sheet == null) {
            sheet = book.createSheet("Результаты ТОП 10");
        } else {
            // Очистка существующих строк
            int rowCount = sheet.getLastRowNum();
            for (int i = 0; i <= rowCount; i++) {
                sheet.removeRow(sheet.getRow(i));
            }
        }

        // Запись новых данных
        XSSFRow headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("№");
        headerRow.createCell(1).setCellValue("Имя");
        headerRow.createCell(2).setCellValue("Количество баллов");

        for (int i = 0; i < Math.min(results.size(), 10); i++) {
            Result result = results.get(i);
            XSSFRow row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(i + 1);
            row.createCell(1).setCellValue(result.getName());
            row.createCell(2).setCellValue(result.getPoints());
        }

        // Запись обратно в локальный файл
        try (FileOutputStream fos = new FileOutputStream(localFile)) {
            book.write(fos);
        }
        book.close();
    }

    /**
     * Метод, считывающий данные из Excel файла и записывающий эти данные в коллекцию объектов Result.
     *
     * @return коллекция объектов Result
     * @throws IOException при невозможности найти или прочитать Excel файл
     */
    public static List<Result> readFromExcel() throws IOException {
        List<Result> results = new ArrayList<>();

        // Проверка, существует ли локальный файл, если нет, то копирование из ресурсов
        File localFile = new File(FILE_PATH);
        if (!localFile.exists()) {
            try (InputStream in = ExcelReader.class.getResourceAsStream(RESOURCE_PATH)) {
                if (in == null) {
                    throw new FileNotFoundException("Resource file not found: " + RESOURCE_PATH);
                }
                Files.copy(in, Paths.get(FILE_PATH));
            }
        }

        // Чтение данных из файла
        try (InputStream in = new FileInputStream(localFile);
             XSSFWorkbook book = new XSSFWorkbook(in)) {

            XSSFSheet sheet = book.getSheetAt(0);
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                XSSFRow row = sheet.getRow(i);
                String name = row.getCell(1).getStringCellValue();
                int points = (int) row.getCell(2).getNumericCellValue();
                results.add(new Result(name, points));
            }
        } catch (NullPointerException e) {
            System.out.println("Empty file of records");
        }
        return results;
    }

    /**
     * Метод, загружающий результаты из Excel файла.
     *
     * @return коллекция объектов Result
     */
    private static List<Result> loadResults() {
        try {
            return readFromExcel();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load results from Excel", e);
        }
    }
}

package az.unitedpayment.gmt_integration_example_java.utils;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
public class MultiFormatDateDeserializer extends JsonDeserializer<ZonedDateTime> {
    private static final List<DateTimeFormatter> FORMATTERS = Arrays.asList(
            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSXXX"),  // Nanosecond ve UTC
            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSXXX"),   // Nanosecond, UTC
            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"),       // Millisecond, UTC
            DateTimeFormatter.ISO_OFFSET_DATE_TIME                             // ISO Tarih Zaman Formatı
    );

    @Override
    public ZonedDateTime deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        String date = parser.getText();
        for (DateTimeFormatter formatter : FORMATTERS) {
            try {
                return ZonedDateTime.parse(date, formatter);
            } catch (Exception ignored) {
            }
        }
        throw new IllegalArgumentException("Desteklenmeyen tarih formatı: " + date);
    }
}
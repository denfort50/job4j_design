package ru.job4j.ood.ocp;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarAdapterJSON implements JsonSerializer<Calendar>, JsonDeserializer<Calendar> {

    private static final ThreadLocal<DateFormat> DATE_FORMAT
            = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"));

    @Override
    public Calendar deserialize(JsonElement jsonElement, Type type,
                                JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(DATE_FORMAT.get().parse(jsonElement.getAsJsonPrimitive().getAsString()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar;
    }

    @Override
    public JsonElement serialize(Calendar calendar, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(DATE_FORMAT.get().format(calendar.getTime()));
    }
}

package com.example.myfirstkotlin

import org.joda.time.DateTime
import java.sql.Timestamp
import javax.persistence.AttributeConverter
import javax.persistence.Converter

//joda DateTimeコンバータ
@Converter(autoApply = true)
class JodaDateTimeConverter : AttributeConverter<DateTime, Timestamp> {

    override fun convertToDatabaseColumn(attribute: DateTime?): Timestamp? {
        return if (attribute != null) {
            Timestamp(attribute.millis)
        } else {
            null
        }
    }

    override fun convertToEntityAttribute(dbData: Timestamp?): DateTime? {
        return if (dbData != null) {
            DateTime(dbData)
        } else {
            null
        }
    }
}
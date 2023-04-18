package com.haejun.study.util.converter

import org.springframework.core.convert.converter.Converter
import org.springframework.data.convert.WritingConverter

@WritingConverter
class EnumConverter : Converter<Enum<*>, String> {
    override fun convert(source: Enum<*>): String? {
        return source.name
    }
}

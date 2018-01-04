package com.bskyb.db.enums;

import org.springframework.core.convert.converter.Converter;

public class ModeConverter implements Converter<String, Mode> {
	@Override
	public Mode convert(String mode) {
		return Mode.fromJson(mode);
	}
}
package mh.springboot.restapi.jdbctransactional.model;

import java.math.BigDecimal;

public record Account(int id, String name, BigDecimal amount) {
}
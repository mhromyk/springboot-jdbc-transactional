package mh.springboot.restapi.jdbctransactional.dto;

import java.math.BigDecimal;

public record TransferDto(int senderAccountId, int receiverAccountId, BigDecimal amount) {
}

package com.bosonit.block12kafkaproducer.domain;

import java.time.LocalDateTime;

public record Message (String message, LocalDateTime created){

}

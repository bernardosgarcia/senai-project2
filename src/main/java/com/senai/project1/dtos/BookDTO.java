package com.senai.project1.dtos;

import java.time.LocalDate;

public record BookDTO(Integer bok_id,
                      String bok_title,
                      String bok_author,
                      int bok_isbn,
                      LocalDate bok_pub_date) {
}

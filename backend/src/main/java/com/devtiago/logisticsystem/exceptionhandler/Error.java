package com.devtiago.logisticsystem.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class Error {

    private Integer status;
    private ZonedDateTime dateHour;
    private String title;
    private List<Field> fields;

    @AllArgsConstructor
    public static class Field {

        private String name;
        private String message;

        public String getName() {
            return name;
        }

        public String getMessage() {
            return message;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }


}

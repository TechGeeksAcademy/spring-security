package com.delighthomes.ams.security.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.sql.Blob;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Slf4j
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "USER"/*,schema = "apartment_management_system"*/)
public class DelightUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String first_name;
    private String middle_name;
    private String second_name;
    private String aadhar_no;
    private String pan_no;
    private Integer mobile_no;
    private Integer alternative_mobile_no;
    private String email_id;
    private String status;
    private Date dob;
    private Blob image;
    private String created_ts;
    private String updated_ts;
}

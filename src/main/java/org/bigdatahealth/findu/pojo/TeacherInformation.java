package org.bigdatahealth.findu.pojo;

import lombok.Data;
import org.apache.solr.client.solrj.beans.Field;

import java.io.Serializable;

@Data
public class TeacherInformation  implements Serializable {

    @Field("tea_id")
    private Long id;

    @Field("tea_username")
    private String username;

    @Field("tea_profession")
    private String profession;

    @Field("tea_department")
    private String department;

    @Field("tea_email")
    private String email;

    @Field("tea_sciInformation")
    private String sciInformation;

    @Field("tea_perHomepage")
    private String perHomepage;

    @Field("tea_college")
    private String college;

    @Field("tea_is_four_hundred")
    private Boolean isFourHundred;

}
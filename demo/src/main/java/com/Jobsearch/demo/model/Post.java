package com.Jobsearch.demo.model;


import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Arrays;

//? use for by liberary lombok to create setter and getter


//!uses to connect this class to the database in mongodb
@Document(
        collection="Testing app"
)
public class Post {

    private String desc;
    private String profile ;
    private int exp ;
//! change the name of skills to techs to match with the database entry
    @Field("techs")
    private String[] skills;



    public String[] getSkills() {
        return skills;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Post{" +
                "desc='" + desc + '\'' +
                ", profile='" + profile + '\'' +
                ", exp=" + exp +
                ", skills=" + Arrays.toString(skills) +
                '}';
    }
}

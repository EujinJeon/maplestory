package com.example.maplestory.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CharacterBasic {
    private Date date;
    private String character_name;
    private String world_name;
    private String character_gender;
    private String character_class;
    private String character_class_level;
    private int character_level;
    private int character_exp;
    private String character_exp_rate;
    private String character_guild_name;
    private String character_image;
    private Date character_date_create;
    private String access_flag;
    private String liberation_quest_clear_flag;
}

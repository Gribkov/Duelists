package com.gribkov.roman.duelists;

/**
 * Created by GribkovRV on 05.02.2015.
 */
public class Duelist {

    public final int HEAD = 1; //Голова
    public final int BODY = 2; //Корпус
    public final int LEGS = 3; //Ноги
    //Получение удара
    public void getKick (Integer mPartBodyKick,Integer mPartBodyBlock, Integer mStrength){
        Integer mDamage = 0;
        if(mPartBodyKick == mPartBodyBlock) mDamage=0;
        else mDamage = 1;
        this.setHealth(this.getHealth()-(mDamage*mStrength));
    }
    //Жив и дуэелянт?
    public boolean isDuelistLive(){
        boolean mLive = true;
        if (this.getHealth() <= 0)
            mLive = false;
            else mLive = true;
        return mLive;
    }
    //Создание дуэлянта с дазанными параметрами
    public Duelist(Integer mHealth, Integer mStrength, Integer mLevel) {
        health = mHealth;
        strength = mStrength;
        level = mLevel;
    }
    //Параметры дуэелянта
    public String getDuelistParametrs(String spName, String spHealth, String spStrength, String spExperience ,String spLevel){
        String duelistParameters = "";
        duelistParameters = spName+this.getNameDuelst()+
                spHealth+this.getHealth().toString()+
                spStrength+this.getStrength().toString()+
                spExperience+this.getExperience().toString()+
                spLevel+this.getLevel().toString();
        return duelistParameters;
    }

    public String getDuelistParametrs(String spName, String spHealth, String spStrength, String spExperience){
        String duelistParameters = "";
        duelistParameters = spName+this.getNameDuelst()+
                spHealth+this.getHealth().toString()+
                spStrength+this.getStrength().toString()+
                spExperience+this.getExperience().toString();
        return duelistParameters;
    }

    //Имя персонажа
    private String nameDuelst = "";
    public String getNameDuelst() {
        return nameDuelst;
    }

    public void setNameDuelst(String mNameDuelst) {
        nameDuelst = mNameDuelst;
    }

    //Здоровье персонажа
    private Integer health = 0;
    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer mHealth) {
        health = mHealth;
    }
    //Сила-прочность персонажа
    private Integer strength = 0;

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer mStrength) {
        strength = mStrength;
    }
    //Уровень персонажа
    private Integer level = 0;
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer mLevel) {
        level = mLevel;
    }
    //Опыт персонажа
    private Integer experience = 0;
    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer mExperience) {
        experience = mExperience;
    }

}

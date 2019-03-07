package com.stackroute.plasma.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cache {

    String intent;
    HashMap<String,Long> termWeight=new HashMap<>();
    Boolean type;

    public Cache(String id, String name, long l) {
    }

    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }

    public HashMap<String , Long> getTermWeight() {
        return termWeight;
    }

    public void setTermWeight(HashMap<String, Long> termWeight) {
        this.termWeight = termWeight;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Cache{" +
                "intent='" + intent + '\'' +
                ", termWeight=" + termWeight +
                ", type=" + type +
                '}';
    }
}

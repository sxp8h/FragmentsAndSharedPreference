package com.sxp8h.fragmentosysharedpreference.Beans;

//
//  ::::::::  :::    ::: :::::::::   ::::::::  :::    ::: 
// :+:    :+: :+:    :+: :+:    :+: :+:    :+: :+:    :+: 
// +:+         +:+  +:+  +:+    +:+ +:+    +:+ +:+    +:+ 
// +#++:++#++   +#++:+   +#++:++#+   +#++:++#  +#++:++#++ 
//        +#+  +#+  +#+  +#+        +#+    +#+ +#+    +#+ 
// #+#    #+# #+#    #+# #+#        #+#    #+# #+#    #+# 
//  ######## ###     ### ###         ########  ###    ###
//
//          --------Created by SXP8H--------


public class Artist {

    private String name;
    private String description;

    public Artist(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}

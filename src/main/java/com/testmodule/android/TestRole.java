package com.testmodule.android;

import java.util.ArrayList;
import java.util.List;

public class TestRole {
    public static void main(String[] args) {
        RoleDTO[] roleDTOS = {
                new RoleDTO(),
                new RoleDTO(),
                new RoleDTO(),
                new RoleDTO(),
                new RoleDTO()
        };
        int index = 0;
        addRole(roleDTOS, index);
    }

    public static void addRole(RoleDTO[] roleDTO, int i) {
        if (i < roleDTO.length) {
            roleDTO[i].dtos = new ArrayList<RoleDTO>();
            if(i+1 != roleDTO.length){
                roleDTO[i].dtos.add(roleDTO[i + 1]);
                addRole(roleDTO, i + 1);
            }
        }
    }

}

class RoleDTO {
    private static int initValue;
    public int value;
    public List<RoleDTO> dtos;

    public RoleDTO() {
        value = initValue++;
    }
}
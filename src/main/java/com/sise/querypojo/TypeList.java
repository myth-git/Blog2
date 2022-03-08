package com.sise.querypojo;

/**
 * 分类列表
 */
public class TypeList {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TypeList{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

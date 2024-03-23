package com.ecom.productservice.models;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Product {

    public Long Id;

    public String Name;

    public String Description;

    public  String Image;

    public  Double Price;

    public  Category category;

}

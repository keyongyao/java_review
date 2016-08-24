package com.example.GOF23.bridge;

/**
 * Created by Administrator on 2016/8/19.
 */
public class Combine implements AbstractBridge {
    private Brand brand;
    private ComputerType computerType;

    public Combine(Brand brand, ComputerType computerType) {
        this.brand = brand;
        this.computerType = computerType;
    }

    @Override
    public void setABrand(Brand aBrand) {
        this.brand = brand;
    }

    @Override
    public void setComputerType(ComputerType computerType) {
        this.computerType = computerType;
    }


}


class Levono implements Brand {
    private String name = "联想";

    public String getName() {
        return name;
    }

    @Override
    public void SetVBrand() {

    }

    @Override
    public void delBrand() {

    }
}

class Computer implements ComputerType {
    @Override
    public void addType() {

    }

    @Override
    public void delType() {

    }

}
